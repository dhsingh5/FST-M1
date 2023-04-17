package groupActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {

    WebDriver driver;

    //Create the setup methods
    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        //set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Initialize deriver object
        driver=new FirefoxDriver();

        //open the browser
        driver.get("https://alchemy.hguy.co/lms");

        driver.findElement(By.linkText("My Account")).click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "My Account – Alchemy LMS");

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

        driver.findElement(By.name("wp-submit")).click();


    }
    //Create the test method

    @Test(priority = 1)
    public void completeLesson() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();

        WebElement element = driver.findElement(By.xpath("//img[@src=\"https://alchemy.hguy.co/lms/wp-content/uploads/2019/05/course-1-free-img-400x223.jpg\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

        driver.findElement(By.xpath("//img[@src=\"https://alchemy.hguy.co/lms/wp-content/uploads/2019/05/course-1-free-img-400x223.jpg\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/lessons/developing-strategy/\"]")).click();

        String courseTitle=driver.getTitle();
        System.out.println(courseTitle);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}
