package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Retry;

import static org.testng.Assert.assertEquals;

@Epic("E2E")
@Feature("Checkout")
@Owner("Lyamkina Tatyana")
public class CheckoutTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Открытие страницы Checkout из Cart",
            description = "Открытие страницы Checkout",
            groups = {"cart", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Открытие страницы Checkout из Cart")
    @TmsLink("Check-1")
    public void checkCheckoutButton() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickShoppingCart();
        softAssert.assertEquals(cartPage.getTitle(),
                "Your Cart", "Переход на страницу не выполнен!");
        cartPage.clickCheckoutButton()
                .isPageOpened();
        softAssert.assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information", "Переход на страницу не был выполнен!");
        softAssert.assertAll();
    }

    @Test(testName = "Успешное заполнение страницы Checkout",
            description = "Успешное заполнение страницы Checkout",
            groups = {"checkout", "smoke"},
            retryAnalyzer = Retry.class)
    @Description("Успешное заполнение страницы Checkout")
    @TmsLink("Checkout-1")
    public void isPersonalInfoValid() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .clickShoppingCart()
                .clickCheckoutButton();
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information", "Страница не открылась");
        checkoutPage.fillPersonalInfo("Tatyana", "Lyamkina", "134134");
        assertEquals(checkoutPage.getTitle(), "Checkout: Overview", "Страница не открылась");
    }

    @DataProvider(name = "Тестовые данные для негативных проверок")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"", "Lyamkina", "134134", "Error: First Name is required"},
                {"Tatyana", "", "134134", "Error: Last Name is required"},
                {"Tatyana", "Lyamkina", "", "Error: Postal Code is required"}
        };
    }

    @Test(testName = "Негативное заполнение Checkout",
            description = "Негативное заполнение Checkout",
            groups = {"checkout", "regression"},
            dataProvider = "Тестовые данные для негативных проверок")
    @Description("Неуспешное заполнение страницы Checkout")
    @Epic("E2E")
    @Feature("Checkout")
    @TmsLink("Checkout-2")
    public void negativeCheckout(String firstName, String lastName, String postalCode, String errorMessage) {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .clickShoppingCart()
                .clickCheckoutButton();
        softAssert.assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information", "Страница не открылась");
        checkoutPage.fillPersonalInfo(firstName, lastName, postalCode);
        softAssert.assertEquals(checkoutPage.getErrorMessage(),
                errorMessage, "Сообщение об ошибке не появилось!");
        softAssert.assertAll();
    }
}
