package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Retry;

import static org.testng.Assert.assertEquals;

@Epic("E2E")
@Feature("Product")
@Owner("Lyamkina Tatyana")
public class ProductsTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Проверка добавления товара на Product",
            description = "Проверка добавления товара на Product",
            groups = {"product", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Проверка добавления товара на Product")
    @TmsLink("Product-1")
    public void checkAddToCart() {
        loginPage.open()
                .isPageOpened()
                .login(user, password);
        assertEquals(productsPage.getTitle(),
                "Products", "Переход на страницу не выполнен!");
        productsPage.addToCart("Sauce Labs Backpack");
        assertEquals(productsPage.getRemoveButtonTitle(),
                "Remove", "Продукт не был добавлен!");

    }

    @Test(testName = "Проверка добавления Fake товара на Product",
            description = "Проверка добавления Fake товара на Product",
            groups = {"product", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Проверка добавления Fake товара на Product")
    @TmsLink("Product-1.1")
    public void checkAddToCartFake() {
        loginPage.open()
                .isPageOpened()
                .login(user, password);
        assertEquals(productsPage.getTitle(),
                "Products", "Переход на страницу не выполнен!");
        productsPage.addToCart("Рюкзак");
        assertEquals(productsPage.getRemoveButtonTitle(),
                "Remove", "Продукт не был добавлен!");

    }

    @Test(testName = "Продолжение покупок(Continue Shopping)",
            description = "Продолжение покупок(Continue Shopping)",
            groups = {"cart", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Продолжение покупок(Continue Shopping) из Cart")
    @TmsLink("Product-3")
    public void checkContinueShoppingButton() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .addToCart("Sauce Labs Backpack")
                .clickShoppingCart();
        softAssert.assertEquals(cartPage.getTitle(),
                "Your Cart", "Переход на страницу не выполнен!");
        cartPage.clickContinueShoppingButton()
                .isPageOpened();
        softAssert.assertEquals(productsPage.getTitle(),
                "Products", "Переход на страницу не выполнен!");
        softAssert.assertAll();
    }
}
