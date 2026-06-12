package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("E2E")
@Feature("Login")
@Owner("Lyamkina Tatyana")
public class LoginTest extends BaseTest {

    @Test(testName = "Авторизация с валидными данными",
            description = "Авторизация с валидными данными",
            groups = {"login", "smoke"})
    @Description("Успешная авторизация")
    @TmsLink("Login-2")
    public void checkLoginWithPositiveCred() {
        loginPage.open()
                .isPageOpened()
                .login(user, password)
                .isPageOpened();
        assertEquals(productsPage.getTitle(), "Products", "Некорректный заголовок");
    }

    @DataProvider(name = "Тестовые данные для негативных проверок входа")
    public Object[][] loginData() {
        return new Object[][]{
                {user, "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"test", "secret", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(testName = "Негативная авторизация",
            description = "Негативная авторизация",
            groups = {"login", "regression"},
            dataProvider = "Тестовые данные для негативных проверок входа")
    @Description("Негативная авторизация")
    @TmsLink("Login-2")
    public void negativeLogin(String userName, String password, String errorMessage) {
        loginPage.open()
                .isPageOpened()
                .login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}
