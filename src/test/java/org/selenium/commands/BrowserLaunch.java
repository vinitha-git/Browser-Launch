package org.selenium.commands;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BrowserLaunch {
    WebDriver driver;

    public void initialiseBrowser(String bro) {
        if (bro.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (bro.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (bro.equals("FireFox")) {
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid Browser value received");
        }
        driver.manage().window().maximize();

    }

    public void closeBrowser() {

        //driver.close();
        driver.quit();
    }
    @BeforeMethod
    public void setUp(){
        initialiseBrowser("Chrome");
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
     if(result.getStatus()==ITestResult.FAILURE)
     {
           takeScreenShot(result);
     }
        closeBrowser();
    }

    public void takeScreenShot(ITestResult result) throws IOException {
        TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
        File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("./Screenshots/"+result.getName()+".png"));

    }
}
