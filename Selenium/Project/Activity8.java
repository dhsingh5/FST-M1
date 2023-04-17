package groupActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity8 {

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
    public void contactAdmin() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href=\"https://alchemy.hguy.co/lms/contact/\"]")).click();

        WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@name=\"wpforms[fields][0]\"]")).sendKeys("apurvi"+ Keys.TAB);
        driver.findElement(By.xpath("//input[@name=\"wpforms[fields][1]\"]")).sendKeys("apurvi@qq.com"+ Keys.TAB);
        driver.findElement(By.xpath("//input[@name=\"wpforms[fields][3]\"]")).sendKeys("data science"+ Keys.TAB);
        driver.findElement(By.xpath("//textarea[@name=\"wpforms[fields][2]\"]")).sendKeys("Please enquire"+ Keys.TAB);
        driver.findElement(By.xpath("//*[@id=\"wpforms-submit-8\"]")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String message= driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]")).getAttribute("innerText");
    System.out.println(message);

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }



}
