import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LocatorTest {

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

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        driver.findElement(By.id("inventory_container")); //id
        driver.findElement(By.name("description")); //name
        driver.findElement(By.className("select_container")); //className
        driver.findElement(By.tagName("span")); //tagname
        driver.findElement(By.linkText("Twitter")); //linktext
        driver.findElement(By.partialLinkText("Sauce")); //partialLinkText

        driver.findElement(By.xpath("//footer[@class='footer']")); //поиск по атрибуту
        driver.findElement(By.xpath("//button[text()='Add to cart']")); //поиск по тексту
        driver.findElement(By.xpath("//button[contains(@class,'btn_small')]")); //поиск по частичному совпадению атрибута
        driver.findElement(By.xpath("//div[contains(text(), 'Backpack')]")); //поиск по частичному совпадению текста
        driver.findElement(By.xpath("//div[contains(text(), 'Backpack')]/ancestor::div[@class='inventory_item']")); //ancestor
        driver.findElement(By.xpath("//div[@id='inventory_container']/descendant::div[contains(@class,'item_name')]")); //descendant
        driver.findElement(By.xpath("//ul[@class='social']/following::*")); //following
        driver.findElement(By.xpath("//div[@class='pricebar']/parent::*")); //parent
        driver.findElement(By.xpath("//div[@class='pricebar']//preceding::div[contains(@class,'item')]")); //preceding
        driver.findElement(By.xpath("//div[contains(@class,'item_name')  and contains(text(), 'Red')]")); //с условием AND
        //css
        driver.findElement(By.cssSelector(".footer"));//.class
        driver.findElement(By.cssSelector(".bm-item.menu-item")); //class1.class2
        driver.findElement(By.cssSelector(".primary_header .bm-menu-wrap")); //class1 .class2
        driver.findElement(By.cssSelector("#item_5_title_link")); //#id
        driver.findElement(By.cssSelector("img")); //tagname
        driver.findElement(By.cssSelector("span.title"));//tagname.class
        driver.findElement(By.cssSelector("[class=bm-cross]")); //[attribute=value]
        driver.findElement(By.cssSelector("[class~= 'btn_inventory']")); //[attribute~=value]
        driver.findElement(By.cssSelector("[lang|='en']")); //[attribute|=value]
        driver.findElement(By.cssSelector("[href^='http']")); //[attribute^=value]
        driver.findElement(By.cssSelector("[id$='light']")); //[attribute$=value]
        driver.findElement(By.cssSelector("[id*='item']")); //[attribute*=value]
        driver.quit();
    }
}
