package groupActivity;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
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
    public void verifyInfoBox(){

        String infoBoxTitle=driver.findElement(By.xpath("//h3[text()=\" Actionable Training \"]")).getAttribute("innerText");
        System.out.println(infoBoxTitle);
        //Assertion
        Assert.assertEquals(infoBoxTitle, "Actionable Training");
        //AssertJUnit.assertEquals(srtTitle, "Training Support");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        //Close the browser
        driver.quit();
    }
}
