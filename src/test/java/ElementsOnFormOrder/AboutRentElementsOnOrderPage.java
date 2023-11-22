package ElementsOnFormOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class AboutRentElementsOnOrderPage {
    private WebDriver driver;
    private By whereToBringFemale = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); //поле "куда привезти самокат
    private By  rentalPeriod = By.className("Dropdown-placeholder"); //поле "срок аренды"
    private By  rentalPeriodOneDay = By.xpath(".//div[text()='сутки']"); // выбор периода (сутки)
    private By  colorFamele = By.className("Order_Title__3EKne"); //поле "цвет самоката"
    private By  choiceСolorFamele = By.xpath("//*[@id='black']"); //поле "цвет самоката - черный"
    private By  commentClient = By.xpath(".//input[@placeholder='Комментарий для курьера']"); //поле "комментарий"
    private By orderButton = By.xpath("//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(./text(), 'Заказать')]"); //поле "кнопка заказать"
    private By buttonYes = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(./text(), 'Да')]"); // кнопка "да" в окне "хотите оформить заказ"
    private By buttonStatusOrder = By.xpath("//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(./text(), 'Посмотреть статус')]"); // кнопка "посмотреть статус заказа" после оформления заказа
    private By orderSuccsessScreen = By.className("Order_ModalHeader__3FDaJ"); // Окно успешного заказа

    public AboutRentElementsOnOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputWhereToBringFemale(String date){
        driver.findElement(whereToBringFemale).sendKeys(date, Keys.ENTER);
    }
    public void clickRentalPeriod(){
        driver.findElement(rentalPeriod).click();
    }
    public void choiceRentalPeriod(){
        driver.findElement(rentalPeriodOneDay).click();
    }
    public void clickColorFamele(){
        driver.findElement(colorFamele).click();
    }
    public void clickChoiceColorFamele(){
        driver.findElement(choiceСolorFamele).click();
    }
    public void inputCommentClient(String comment){
        driver.findElement(commentClient).click();
        driver.findElement(commentClient).sendKeys(comment);
    }
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }
    public void clickClientButtonYes(){
        driver.findElement(buttonYes).click();
    }


    public void clickButtonOrderStatus(){
        driver.findElement(buttonStatusOrder).click();
    }

    public void waitForLoadPageOrder(){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));
    }

    public void waitOrderSuccsessScreen(){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(orderSuccsessScreen));
    }

}
