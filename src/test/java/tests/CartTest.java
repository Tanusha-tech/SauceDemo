package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void checkCartIsNotEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.clickShoppingCart();
        assertEquals("Переход на страницу не выполнен!",
                "Your Cart", cartPage.getTitle());
        assertTrue(cartPage.isCartNotEmpty(), "Корзина пуста!");
    }

    @Test
    public void checkCheckoutButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.clickShoppingCart();
        assertEquals("Переход на страницу не выполнен!",
                "Your Cart", cartPage.getTitle());
        cartPage.clickCheckoutButton();
        assertEquals("Переход на страницу не был выполнен!",
                "Checkout: Your Information", checkoutPage.getTitle());
    }

    @Test
    public void checkContinueShoppingButton() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton();
        productsPage.clickShoppingCart();

        assertEquals("Переход на страницу не выполнен!",
                "Your Cart", cartPage.getTitle());
        cartPage.clickContinueShoppingButton();
        assertEquals("Переход на страницу не выполнен!",
                "Products", productsPage.getTitle());
    }
}

