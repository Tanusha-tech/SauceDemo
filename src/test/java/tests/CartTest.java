package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Retry;

import static org.testng.Assert.assertEquals;

@Epic("E2E")
@Feature("Cart")
@Owner("Lyamkina Tatyana")
public class CartTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Отображение товара в корзине",
            description = "Отображение товара в корзине",
            groups = {"cart", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Отображение товара в корзине")
    @TmsLink("Cart-2")
    public void checkCartIsNotEmpty() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .clickShoppingCart()
                .isPageOpened();
        softAssert.assertEquals(cartPage.getTitle(),
                "Your Cart", "Переход на страницу не выполнен!");
        softAssert.assertTrue(cartPage.isCartNotEmpty(), "Корзина пуста!");
        softAssert.assertAll();
    }

    @Test(testName = "Проверка перехода в Cart",
            description = "Проверка перехода в Cart",
            groups = {"product", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Проверка перехода в Cart из Product")
    @TmsLink("Cart-3")
    public void checkShoppingCart() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
        assertEquals(productsPage.getTitle(),
                "Products", "Переход на страницу не выполнен");
        productsPage.clickShoppingCart()
                    .isPageOpened();
        assertEquals(cartPage.getTitle(), "Your Cart",
                "Переход на страницу не выполнен!");
    }
}

