package Configure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static WebDriver driver = null;

    public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static void navigateToTheUrl(String url) {
        driver.get(url);
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static String getBrowserName() {
        String browserDefault = "firefox"; // Браузер по умолчанию
        String browserSentFromCmd = System.getProperty("browser");
        if (browserSentFromCmd == null) {
            return browserDefault;
        } else {
            return browserSentFromCmd;
        }
    }

}
