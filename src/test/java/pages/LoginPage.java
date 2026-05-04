package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.cssSelector("#user-name");
    private final By PASSWORD_FIELD = By.cssSelector("#password");
    private final By LOGIN_BUTTON = By.cssSelector("#login-button");
    private final By ERROR_MESSAGE = By.xpath("//*[contains(@class, 'error-message')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        open();
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
