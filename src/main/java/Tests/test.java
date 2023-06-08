package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static java.lang.Thread.sleep;
public class test {
    public static void main(String[] args) throws InterruptedException {
        String prud = "Products";
        By user = By.id("user-name");
        By password = By.xpath("//*[@id='password']");
        By bottomLogin = By.name("login-button");
        By homePageTitle = By.className("title");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("incognito");

        //Instancia del Browser
        WebDriver driver = new ChromeDriver(options);
        // Open facebook
        driver.get("https://www.saucedemo.com/");

        // Maximize browser
        // driver.manage().window().maximize();

        //caso 1
        driver.findElement(user).clear();
        driver.findElement(user).sendKeys("standard_user");

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("secret_sauce");
        sleep(2000);

        driver.findElement(bottomLogin).click();
        sleep(2000);

        WebElement title = driver.findElement(homePageTitle);
        Assert.assertEquals(title.getText(), prud, "El titulo de la pagina no es el esperado");
        driver.close();
        driver.quit();
    }
}
