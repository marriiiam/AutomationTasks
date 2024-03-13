import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement userElementPOM(WebDriver driver){
       /* By username = By.id("username");
        WebElement userElement = driver.findElement(username);

        */
        return driver.findElement(By.id("username"));

    }
    public WebElement passElementPOM(WebDriver driver){
        /*By password = By.name("password");
        WebElement passElement = driver.findElement(By.name("password");*/
        return driver.findElement(By.name("password"));


    }


}
