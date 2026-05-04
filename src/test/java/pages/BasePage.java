package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static final By TITLE = By.cssSelector("span.title");
    public final String BASE_URL = "https://www.saucedemo.com/";
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}
