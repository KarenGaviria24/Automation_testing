package org.automation.qa.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.qa.messages.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import static java.lang.Thread.sleep;
public class BasicTest {
    private WebDriver driver;

    @BeforeMethod
    public void Initial(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        options.addArguments("--start-maximized");
        options.addArguments("incognito");
    }

    @AfterMethod(alwaysRun = true)
    public void clean(){
        driver.close();
        driver.quit();
    }

    @Parameters({"user", "password"})
    @Test
    public void test1(String userName, String userPassword) throws InterruptedException {
        By user = By.id("user-name");
        By password = By.xpath("//*[@id='password']");

        driver.manage().window().maximize();
        driver.findElement(user).clear();
        driver.findElement(user).sendKeys(userName);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(userPassword);
        sleep(2000);

        By bottomLogin = By.name("login-button");
        driver.findElement(bottomLogin).click();

        By homePageTitle = By.className("title");
        WebElement title = driver.findElement(homePageTitle);
        Assert.assertEquals(title.getText(), Messages.product,Messages.titleAssertion);
        sleep(2000);

    }

    @Test (priority = 1,enabled = false)
    public void test2()throws InterruptedException {
        By bottomLogin = By.name("login-button");
        driver.findElement(bottomLogin).click();

        By error_Message = By.className("error-message-container");
        WebElement error = driver.findElement(error_Message);

        Assert.assertEquals(error.getText(), Messages.errorUserRequired, Messages.assertionEqualsMsg );
        sleep(2000);

    }

    @Test
    @Parameters({"userLocked","password"})
    public void test3 (String userName, String userPassword) throws InterruptedException {
        By user = By.id("user-name");
        By password = By.xpath("//*[@id='password']");

        driver.findElement(user).clear();
        driver.findElement(user).sendKeys(userName);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(userPassword);

        By bottomLogin = By.name("login-button");
        driver.findElement(bottomLogin).click();


        By error_Message = By.className("error-message-container");
        WebElement error = driver.findElement(error_Message);
        Assert.assertEquals(error.getText(), Messages.errorUserLocked, Messages.assertionEqualsMsg);
        sleep(2000);
    }

     @Test
     @Parameters({"userNotRegistered","passwordNull"})
    public void test4(String userName, String userPassword)throws InterruptedException {
         By user = By.id("user-name");
         By password = By.xpath("//*[@id='password']");

         driver.findElement(user).clear();
         driver.findElement(user).sendKeys(userName);

         driver.findElement(password).clear();
         driver.findElement(password).sendKeys(userPassword);

         By bottomLogin = By.name("login-button");
         driver.findElement(bottomLogin).click();

         By error_Message = By.className("error-message-container");
         WebElement error = driver.findElement(error_Message);
         Assert.assertEquals(error.getText(), Messages.errorUserNotRegistered, Messages.assertionEqualsMsg);
         sleep(2000);
     }

     @Test
     @Parameters({"userProblem","password"})
     public void test5 (String userName, String userPassword)throws InterruptedException {
         By user = By.id("user-name");
         By password = By.xpath("//*[@id='password']");

         driver.findElement(user).clear();
         driver.findElement(user).sendKeys(userName);

         driver.findElement(password).clear();
         driver.findElement(password).sendKeys(userPassword);

         By bottomLogin = By.name("login-button");
         driver.findElement(bottomLogin).click();
        sleep(2000);
     }

     @Test
    @Parameters({"userPerformance","password"})
    public void test6 (String userName, String userPassword)throws InterruptedException {
         By user = By.id("user-name");
         By password = By.xpath("//*[@id='password']");

         driver.findElement(user).clear();
         driver.findElement(user).sendKeys(userName);

         driver.findElement(password).clear();
         driver.findElement(password).sendKeys(userPassword);

         By bottomLogin = By.name("login-button");
         driver.findElement(bottomLogin).click();
         sleep(2000);
     }

}




