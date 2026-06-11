package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private static final By SHOPPING_CART = By.xpath("//*[@data-test='shopping-cart-link']");
    private final By REMOVE_BUTTON = By.xpath("//*[@data-test='remove-sauce-labs-backpack']");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage isPageOpened() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SHOPPING_CART));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }


    public String getRemoveButtonTitle() {
        return driver.findElement(REMOVE_BUTTON).getText();
    }

    @Step("Переход в Cart из Product")
    public CartPage clickShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
        return new CartPage(driver);
    }

    @Step("Добавление товара '{product}' в корзину")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }
}