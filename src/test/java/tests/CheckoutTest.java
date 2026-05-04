package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void isPersonalInfoValid() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals("Страница не открылась",
                "Checkout: Your Information", checkoutPage.getTitle());
        checkoutPage.fillPersonalInfo("Tatyana", "Lyamkina", "134134");
    }

    @Test
    public void checkEmptyFirstNameField() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals("Страница не открылась",
                "Checkout: Your Information", checkoutPage.getTitle());
        checkoutPage.fillPersonalInfo("", "Lyamkina", "134134");
        assertEquals("Сообщение об ошибке не появилось!",
                "Error: First Name is required", checkoutPage.getErrorMessage());
    }

    @Test
    public void checkEmptyLastNameField() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        assertEquals("Страница не открылась",
                "Checkout: Your Information", checkoutPage.getTitle());
        checkoutPage.fillPersonalInfo("Tahmina", "", "04368");
        assertEquals("Сообщение об ошибке не появилось!",
                "Error: Last Name is required", checkoutPage.getErrorMessage());
    }

    @Test
    public void checkEmptyPostalCodeField() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        softAssert.assertEquals(checkoutPage.getTitle(),
                "Checkout: Your Information", "Страница не открылась");
        checkoutPage.fillPersonalInfo("Tatyana", "Lyamkina", "");
        softAssert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required", "Сообщение об ошибке не появилось!");
        softAssert.assertAll();
    }
}
