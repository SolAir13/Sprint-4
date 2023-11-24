package AllTestsYandexSamokat;

import ButtonAndPath.ButtonOnPageObject;
import Configure.WebDriverFactory;
import ElementsOnFormOrder.AboutRentElementsOnOrderPage;
import ElementsOnFormOrder.OrderPageElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class OrderTest {
    private WebDriver driver;
    String website = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void setup() throws Exception {
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        WebDriverFactory.navigateToTheUrl(website);
    }

    @Test
    // в этом тесте бага при нажатии на кнопку "Да"
    public void testChromeWhenButtonYesDontClick() {
        ButtonOnPageObject buttonOnPageObject = new ButtonOnPageObject(driver);
        buttonOnPageObject.clickOrderButtonOnUp();
        buttonOnPageObject.waitForLoadHeaderOrderPage();
        OrderPageElements orderPageElements = new OrderPageElements(driver);
        orderPageElements.inputFirstNameClient("Алекс");
        orderPageElements.inputLastNameClient("Тестовский");
        orderPageElements.inputAddressClient("119021, г. Москва, ул. Льва Толстого, д. 16");
        orderPageElements.inputMetroStationClient("Парк Культуры");
        orderPageElements.inputPhoneClient("+79229002200");
        orderPageElements.clickFurtherButton();
        orderPageElements.waitForLoadHeaderAboutRentPage();
        AboutRentElementsOnOrderPage aboutRentElementsOnOrderPage = new AboutRentElementsOnOrderPage(driver);
        aboutRentElementsOnOrderPage.inputWhereToBringFemale("23.11.2023");
        aboutRentElementsOnOrderPage.clickRentalPeriod();
        aboutRentElementsOnOrderPage.choiceRentalPeriod();
        aboutRentElementsOnOrderPage.clickColorFamele();
        aboutRentElementsOnOrderPage.clickChoiceColorFamele();
        aboutRentElementsOnOrderPage.inputCommentClient("Привезите самокат получше=)");
        aboutRentElementsOnOrderPage.clickOrderButton();
        aboutRentElementsOnOrderPage.clickClientButtonYes();
        aboutRentElementsOnOrderPage.waitForLoadPageOrder();
        aboutRentElementsOnOrderPage.waitOrderSuccsessScreen();
        aboutRentElementsOnOrderPage.clickButtonOrderStatus();
    }

    @Test
    public void testMozilaWhenButtonYesClick() {
        ButtonOnPageObject buttonOnPageObject = new ButtonOnPageObject(driver);
        buttonOnPageObject.clickOrderButtonOnUp();
        buttonOnPageObject.waitForLoadHeaderOrderPage();
        OrderPageElements orderPageElements = new OrderPageElements(driver);
        orderPageElements.inputFirstNameClient("Антон");
        orderPageElements.inputLastNameClient("Тестовский");
        orderPageElements.inputAddressClient("119021, г. Москва, ул. Льва Толстого, д. 16");
        orderPageElements.inputMetroStationClient("Киевская");
        orderPageElements.inputPhoneClient("+79229002277");
        orderPageElements.clickFurtherButton();
        orderPageElements.waitForLoadHeaderAboutRentPage();
        AboutRentElementsOnOrderPage aboutRentElementsOnOrderPage = new AboutRentElementsOnOrderPage(driver);
        aboutRentElementsOnOrderPage.inputWhereToBringFemale("23.11.2023");
        aboutRentElementsOnOrderPage.clickRentalPeriod();
        aboutRentElementsOnOrderPage.choiceRentalPeriod();
        aboutRentElementsOnOrderPage.clickColorFamele();
        aboutRentElementsOnOrderPage.clickChoiceColorFamele();
        aboutRentElementsOnOrderPage.inputCommentClient("Привезите самокат получше, который едет быстрее всех");
        aboutRentElementsOnOrderPage.clickOrderButton();
        aboutRentElementsOnOrderPage.clickClientButtonYes();
        aboutRentElementsOnOrderPage.waitForLoadPageOrder();
        aboutRentElementsOnOrderPage.waitOrderSuccsessScreen();
        aboutRentElementsOnOrderPage.clickButtonOrderStatus();
    }

    @After
    public void closeBrow() {
        WebDriverFactory.quitDriver();
    }

}
