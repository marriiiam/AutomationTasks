import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class Test {

    private WebDriver driver;

    @org.testng.annotations.Test
    public void testDemo(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.get("https://www.saucedemo.com/");

        By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
// System.out.println(loginPageHeader.getText());
        Assert.assertEquals(loginPageHeader.getText(),"Swag Labs","login page header does not match requirement");
        //driver.quit();
        By loginPageButtonSelector = By.className("submit-button");
        WebElement loginPageButton = driver.findElement(loginPageButtonSelector);
        Assert.assertEquals(loginPageButton.getText(),"","login button doesn't match the req");

        //6 elements


    }

}
