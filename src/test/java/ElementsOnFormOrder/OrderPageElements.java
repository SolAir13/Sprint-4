package ElementsOnFormOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageElements {
    private WebDriver driver;
    private By firstNameClient = By.xpath(".//input[@placeholder='* Имя']"); // поле "имя"
    private By lastNameClient = By.xpath(".//input[@placeholder='* Фамилия']"); // поле "фамилия"
    private By addressClient = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // поле "адрес"
    private By metroStationClient = By.xpath(".//input[@placeholder='* Станция метро']"); // поле "метро"
    private By phoneClient = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // поле "телефон"
    private By furtherButton = By.xpath(".//button[text()='Далее']"); // кнопка "далее"

    public OrderPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstNameClient(String name){
        driver.findElement(firstNameClient).sendKeys(name);
    }
    public void inputLastNameClient(String firstName){
        driver.findElement(lastNameClient).sendKeys(firstName);
    }
    public void inputMetroStationClient(String metro){
        driver.findElement(metroStationClient).sendKeys(metro, Keys.DOWN, Keys.ENTER);
    }
    public void inputPhoneClient(String phone){
        driver.findElement(phoneClient).sendKeys(phone);
    }
    public void inputAddressClient(String address){
        driver.findElement(addressClient).sendKeys(address);
    }
    public void clickFurtherButton(){
        driver.findElement(furtherButton).click();
    }
    public void waitForLoadHeaderAboutRentPage(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb"))); //ожидание загрузки заголовка про аренду
    }
}
