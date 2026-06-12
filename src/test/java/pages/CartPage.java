package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CartPage extends BasePage {

    private static final By TITLE = By.xpath("//*[@data-test='title']");
    private final By CHECKOUT_ID = By.id("checkout");
    private final By CONTINUE_SHOPPING = By.id("continue-shopping");
    private final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage isPageOpened() {
        log.info("Opening the Cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_SHOPPING));
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Переход в Checkout из Cart")
    public CheckoutPage clickCheckoutButton() {
        log.info("Transition to Checkout from Cart");
        driver.findElement(CHECKOUT_ID).click();
        return new CheckoutPage(driver);
    }

    @Step("Поиск товара в корзине")
    public boolean isCartNotEmpty() {
        log.info("Search for a product in the cart");
        return driver.findElement(CART_ITEM).isDisplayed();
    }

    @Step("Переход в магазин из Cart")
    public ProductsPage clickContinueShoppingButton() {
        log.info("Going to the store from Cart\n");
        driver.findElement(CONTINUE_SHOPPING).click();
        return new ProductsPage(driver);
    }
}
