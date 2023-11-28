package ButtonAndPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonOnPageObject {
    private static WebDriver driver;
    private By orderButtonUpOnHomePage = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']"); //локатор кнопки "Заказать" вверху страницы

    private By orderButtonDownOnHomePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");//локатор кнопки Заказать в нижней части главной страницы

    private By titleElementPageOrder = By.xpath(".//div[text()='Для кого самокат']");

    private static final By components = By.xpath(".//div[@data-accordion-component= 'AccordionItem']");


    public ButtonOnPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButtonOrderOnHomePage(String buttonLocation) {
        if (buttonLocation.equals("top")) {
            driver.findElement(orderButtonUpOnHomePage).click();
        } else if (buttonLocation.equals("bottom")) {
            WebElement element = driver.findElement(orderButtonDownOnHomePage);
            scrollToElementOnPage(element);
            element.click();
        } else {
            System.out.println("Такой кнопки не сущетсвует!");
        }
    }

    public void clickOrderButtonOnUp() {
        driver.findElement(orderButtonUpOnHomePage).click();// Нажатие на кнопку "Заказать" вверху страницы
    }


    public void waitForLoadHeaderOrderPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(titleElementPageOrder)); //ожидание загрузки заголовка Для кого самокат
    }

    public static void scrollToElementOnPage(WebElement webElement) {
        // Прокрутить страницу до вопросов
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static ParametrsOnMainPage getDataQandA(int index) {
        WebElement webElement = driver.findElements(components).get(index);
        scrollToElementOnPage(webElement);
        webElement.click();
        return new ParametrsOnMainPage(webElement, driver); //получение компонента из списка
    }
}
