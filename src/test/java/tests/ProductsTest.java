package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void checkAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals("Переход на страницу не выполнен!",
                "Products", productsPage.getTitle());

        productsPage.clickAddToCartButton();
        assertEquals("Продукт не был добавлен!",
                "Remove", productsPage.getRemoveButtonTitle());

    }

    @Test
    public void checkShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals("Переход на страницу не выполнен",
                "Products", productsPage.getTitle());

        productsPage.clickShoppingCart();
        assertEquals("Переход на страницу не выполнен!",
                "Your Cart", cartPage.getTitle());
    }
}
