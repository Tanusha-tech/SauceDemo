package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private final By CHECKOUT_ID = By.id("checkout");
    private final By CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_ID).click();
    }

    public boolean isCartNotEmpty() {
        return driver.findElement(CART_ITEM).isDisplayed();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

}
