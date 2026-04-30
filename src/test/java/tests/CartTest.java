package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class CartTest {

    @Test
    public void chekLocator() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notification");
        options.addArguments("--disable-popup_blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        String nameProduct = driver.findElement(By.xpath("//div[contains(@class,'item_name') and contains(text(), 'Jacket')]")).getText();
        String itemPrice = driver.findElement(By.xpath("//div[@class='inventory_item'][4]//div[contains(@class,'item_price')]")).getText();

        driver.findElement(By.xpath("//div[@class='inventory_item'][4]//button")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        String saleNameProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String salePrice = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        softAssert.assertEquals(saleNameProduct, nameProduct, "Не совпадает название");
        softAssert.assertEquals(salePrice, itemPrice, "Не совпадает цена");

        softAssert.assertAll();
        driver.quit();
    }
}
