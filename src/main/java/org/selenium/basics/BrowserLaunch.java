package org.selenium.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        String pageTitle =driver.getTitle();
        System.out.println(pageTitle);
        String currentURL=driver.getCurrentUrl();
        System.out.println(currentURL);

        String handleId= driver.getWindowHandle();
        System.out.println(handleId);
        String pageSource =driver.getPageSource();
        System.out.println(pageSource);
        driver.close();
    }
}
