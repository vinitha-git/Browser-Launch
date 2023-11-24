package org.selenium.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
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
        driver.close();
    }
    @BeforeMethod
    public void setUp(){
        initialiseBrowser("Chrome");
    }
    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
