package MainParametrs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MainParametrs {
    public WebDriver driver;
    public WebElement root;


    public MainParametrs (WebElement root, WebDriver driver) {
        this.driver = driver;
        this.root = root;
    }

}