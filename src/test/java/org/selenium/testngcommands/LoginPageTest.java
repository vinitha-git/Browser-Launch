package org.selenium.testngcommands;
        import com.aventstack.extentreports.ExtentTest;
        import com.aventstack.extentreports.Status;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.selenium.automationcore.Base;
        import org.selenium.constants.Constants;
        import org.selenium.constants.Messages;
        import org.selenium.dataprovider.DataProviderIteratorable;
        import org.selenium.listeners.ExtentListener;
        import org.selenium.utilities.ExcelUtility;
        import org.selenium.utilities.WebElementUtility;
        import org.testng.Assert;
        import org.testng.annotations.Test;
        import java.util.ArrayList;

public class LoginPageTest extends Base {

        ThreadLocal<ExtentTest> extentTest = ExtentListener.getTestInstance();
    @Test(priority = 5,groups="Smoke")
    public void verifyLoginPageTitle() {
            extentTest.get().assignCategory("Smoke");
            extentTest.get().log(Status.PASS, "URL Loaded successfully");
            WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
            WebElementUtility.clickOnElement(loginField);
            String actualpageTitle = driver.getTitle();
            extentTest.get().log(Status.PASS, "LoginPage Title received  successfully");
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            extentTest.get().log(Status.PASS, "Expected title recieved from Excel");
            String expectedResult = data.get(1);
            extentTest.get().log(Status.PASS, "Data in row 0 , column 1 is received from Excel");
            Assert.assertEquals(actualpageTitle, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test(priority = 6,groups = {"Smoke","Regression"})
    public void verifyUserLogin() {
            extentTest.get().assignCategory("Smoke");
            extentTest.get().log(Status.PASS, "URL Loaded successfully");
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
            extentTest.get().log(Status.PASS, "Expected title recieved from Excel");
            String emailId = data.get(2);
            extentTest.get().log(Status.PASS, "Data in row 0, column 2 recieved from Excel");
            String password= data.get(3);
            extentTest.get().log(Status.PASS, "Data in row 0, column 3 recieved from Excel");
            WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
            WebElementUtility.clickOnElement(loginField);
            WebElement emailField = driver.findElement(By.id("Email"));
            WebElementUtility.enterValue(emailField,emailId);
            WebElement passwordField = driver.findElement(By.id("Password"));
            WebElementUtility.enterValue(passwordField,password);
            WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
            WebElementUtility.clickOnElement(loginButton);
            WebElement loggedAccount = driver.findElement(By.xpath("//a[@class='account']"));
            String actualResult = WebElementUtility.getTextFromElement(loggedAccount);
            Assert.assertEquals(actualResult, emailId, Messages.LOGIN_FAILED_MESSAGE);
    }
        @Test(priority=7,dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviderIteratorable.class,groups = "Sanity")
        public void verifyUserLoginWithInvalidCredentials(String userName, String password){
                extentTest.get().assignCategory("Sanity");
                extentTest.get().log(Status.PASS, "URL Loaded successfully");
                WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
                WebElementUtility.clickOnElement(loginField);
                WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
                WebElementUtility.enterValue(emailField,userName);
                WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
                WebElementUtility.enterValue(passwordField,password);
                WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
                WebElementUtility.clickOnElement(loginButton);
                WebElement actualMsgElement = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
                String actualMsgText =  WebElementUtility.getTextFromElement(actualMsgElement);
                String expectedMsgText =Messages.LOGIN_UNSUCEESFUL;
                Assert.assertEquals(actualMsgText,expectedMsgText,Messages.LOGIN_FAILED_MESSAGE);
        }
}
