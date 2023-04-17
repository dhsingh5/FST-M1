package groupActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity7 {

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
    public void myAllCourses(){
    driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/all-courses/\"]")).click();

    List< WebElement> courses =driver.findElements(By.xpath("//div[@class=\"ld-course-list-items row\"]/div"));
    courses.size();
    System.out.println("Total number of courses"+courses.size());
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }


}
