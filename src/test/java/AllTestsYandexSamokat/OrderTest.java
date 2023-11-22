package AllTestsYandexSamokat;

import ButtonAndPath.ButtonOnPageObject;
import ElementsOnFormOrder.AboutRentElementsOnOrderPage;
import ElementsOnFormOrder.OrderPageElements;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OrderTest {
    private WebDriver driver;

    @Test
    // в этом тесте бага при нажатии на кнопку "Да"
    public void testChromeWhenButtonYesDontClick() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

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

    @After
    public void closeChrome() {
        driver.quit();
    }


    @Test
    public void testMozilaWhenButtonYesClick() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        ButtonOnPageObject buttonOnPageObject = new ButtonOnPageObject(driver);
        buttonOnPageObject.clickOrderButtonOnUp();
//        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
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
    public void closeFox() {
        driver.quit();
    }

}
