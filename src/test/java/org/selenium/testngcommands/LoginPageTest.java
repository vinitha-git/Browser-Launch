package org.selenium.testngcommands;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.selenium.automationcore.Base;
        import org.selenium.constants.Constants;
        import org.selenium.constants.Messages;
        import org.selenium.utilities.ExcelUtility;
        import org.testng.Assert;
        import org.testng.annotations.Test;

        import java.util.ArrayList;

public class LoginPageTest extends Base {
    @Test
    public void verifyLoginPageTitle() {
        try {
            WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
            loginField.click();
            String actualpageTitle = driver.getTitle();
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            String expectedResult = data.get(1);
            Assert.assertEquals(actualpageTitle, expectedResult, Messages.TITLE_MISMATCH);
        }
        catch( Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void verifyUserLogin() {
        WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Simple@123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginButton.click();
        WebElement loggedAccount = driver.findElement(By.xpath("//a[@class='account']"));
        String actualResult = loggedAccount.getText();
        String expectedResult = "vinithaedwin.test@gmail.com";
        Assert.assertEquals(actualResult, expectedResult, Messages.LOGIN_FAILED);
    }
}
