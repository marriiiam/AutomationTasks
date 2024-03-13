import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class SixItems {
    private static WebDriver driver;


    @BeforeTest
    public void openBrowser() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    public void Login() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }
    @Test
    public void sixItems() throws InterruptedException {

        Login();
        Thread.sleep(3000);
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        Assert.assertEquals(items.size(),6,"not 6");
    }
    public WebElement genericLocator(String str){
        String str1 =String.format("//div[@class=\"inventory_item_name \" and contains(text(),'%s')]/ancestor::div[@class=\"inventory_item_label\"]/following-sibling::div/div/following-sibling::button",str);
        WebElement AddToCart = driver.findElement(By.xpath(str1));
        return AddToCart;
    }

    @Test
    public void addItemToCart() throws InterruptedException {
        Login();
        String ItemName = "Sauce Labs Backpack";
        genericLocator(ItemName).click();
        String str2=String.format("//div[contains(text(),'%s')]",ItemName);
        By acutalItem = By.xpath(str2);
        System.out.println(acutalItem);
        driver.get("https://www.saucedemo.com/cart.html");
        Thread.sleep(3000);
        List<WebElement> items = driver.findElements(By.className("cart_item"));
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(items.size() > 0,"0 items");
        assertion.assertEquals(acutalItem,ItemName,"error here");
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
