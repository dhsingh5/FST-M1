package groupActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity4 {

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
    }
    //Create the test method

    @Test(priority = 1)
    public void secondMostPopularCourse() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
String courseTitle= driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3")).getAttribute("innerText");
        Assert.assertEquals(courseTitle, "Email Marketing Strategies");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }


}
