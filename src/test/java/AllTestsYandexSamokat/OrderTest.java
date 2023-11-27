package AllTestsYandexSamokat;

import ButtonAndPath.ButtonOnPageObject;
//import Configure.WebDriverFactory;
import ElementsOnFormOrder.AboutRentElementsOnOrderPage;
import ElementsOnFormOrder.OrderPageElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;

    @Parameterized.Parameter
    public String buttonLocation;

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"top"}, {"bottom"}
        };
    }
    String website = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setup() {
        switch (System.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                this.driver = new ChromeDriver();// инициализация firefox
                driver.get(website);
                break;
            case "firefox":
            default:
                WebDriverManager.firefoxdriver().setup();
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                this.driver = new FirefoxDriver();
                driver.get(website);
        }
    }

    @Test
    // в этом тесте бага при нажатии на кнопку "Да" для браузера chrome. Для браузера firefox тесты проходят
    public void testChromeWhenButtonYesDontClick() {
        ButtonOnPageObject buttonOnPageObject = new ButtonOnPageObject(driver);
        buttonOnPageObject.selectButtonOrderOnHomePage(buttonLocation);
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
    public void closeBrow() {
        driver.quit();
    }

}
