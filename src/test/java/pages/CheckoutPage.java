package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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

    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Заполнение и проверка формы Checkout: Фамилия - '{lastName}', Имя - '{firstName}', Индекс - '{postalCode}'")
    public void fillPersonalInfo(String firstName, String lastName, String postalCode) {
        log.info("Filling out the form Checkout: '{}', '{}', {}", lastName, firstName, postalCode);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
