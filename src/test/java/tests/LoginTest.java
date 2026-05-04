package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class LoginTest extends BaseTest {
    @Test
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals("Некорректный заголовок", "Products", productsPage.getTitle());
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals("Epic sadface: Password is required", loginPage.getErrorMessage());
    }

    @Test
    public void checkLoginWithEmptyUser() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
    }

    @Test
    public void checkLoginWithNegativeCred() {
        loginPage.open();
        loginPage.login("test", "test");
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage());
    }
}
