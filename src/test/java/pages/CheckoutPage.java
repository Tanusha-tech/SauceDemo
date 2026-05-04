package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By FIRST_NAME = By.xpath("//*[@data-test='firstName']");
    private static final By LAST_NAME = By.xpath("//*[@data-test='lastName']");
    private static final By POSTAL_CODE = By.xpath("//*[@data-test='postalCode']");
    private static final By CONTINUE = By.xpath("//*[@data-test='continue']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void fillPersonalInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
