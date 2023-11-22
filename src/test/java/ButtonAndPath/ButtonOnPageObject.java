package ButtonAndPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonOnPageObject {
    private static WebDriver driver;
    private By orderButtonUpOnHomePage = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']"); //локатор кнопки "Заказать" вверху страницы
    private By titleElementPageOrder = By.xpath(".//div[text()='Для кого самокат']");

    private static final By components = By.xpath(".//div[@data-accordion-component= 'AccordionItem']");



    public ButtonOnPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonOnUp() {
        driver.findElement(orderButtonUpOnHomePage).click();// Нажатие на кнопку "Заказать" вверху страницы
    }

    public void waitForLoadHeaderOrderPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(titleElementPageOrder)); //ожидание загрузки заголовка Для кого самокат
    }
    public static void scrollPage(WebElement webElement){
        // Прокрутить страницу до вопросов
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static ParametrsOnMainPage getDataQandA(int index) {
        WebElement webElement = driver.findElements(components).get(index);
        scrollPage(webElement);
        webElement.click();
        return new ParametrsOnMainPage(webElement, driver); //получение компонента из списка
    }
}
