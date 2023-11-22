package ButtonAndPath;

import MainParametrs.MainParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParametrsOnMainPage extends MainParametrs {
    private By question = By.xpath(".//div[contains(@id, 'accordion__heading')]");//локатор блока с вопросами на главной странице
    private By answer = By.xpath(".//div[contains(@id, 'accordion__panel')]");//локатор блока с ответами на главной странице

    public ParametrsOnMainPage(WebElement root, WebDriver driver) {
        super(root, driver);
    }

    public String getQuestion() {
        return root.findElement(question).getText();// метод получения текста вопроса из списка
    }

    public String getAnswer() {
        return root.findElement(answer).getText();// метод получения текста ответа из списка
    }

}
