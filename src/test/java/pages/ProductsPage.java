package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By SHOPPING_CART = By.xpath("//*[@data-test='shopping-cart-link']");
    private static final By ADD_TO_CART = By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']");
    private final By REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(ADD_TO_CART).click();
    }

    public String getRemoveButtonTitle() {
        return driver.findElement(REMOVE_BUTTON).getText();
    }

    public void clickShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }

}