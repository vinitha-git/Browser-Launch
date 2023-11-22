package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
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
