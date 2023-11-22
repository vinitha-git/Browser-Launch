package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserLaunch {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
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
