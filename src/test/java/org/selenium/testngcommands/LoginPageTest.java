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
        try {
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            String emailId = data.get(2);
            String password= data.get(3);
            WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
            loginField.click();
            WebElement emailField = driver.findElement(By.id("Email"));
            emailField.sendKeys(emailId);
            WebElement passwordField = driver.findElement(By.id("Password"));
            passwordField.sendKeys(password);
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
            loginButton.click();
            WebElement loggedAccount = driver.findElement(By.xpath("//a[@class='account']"));
            String actualResult = loggedAccount.getText();
            Assert.assertEquals(actualResult, emailId, Messages.LOGIN_FAILED);
        }
        catch( Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
