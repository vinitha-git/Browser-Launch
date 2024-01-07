package org.selenium.testngcommands;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.listeners.ExtentListener;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.RandomDataUtility;
import org.selenium.utilities.WebElementUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class RegisterPageTest extends Base {
    ThreadLocal<ExtentTest> extentTest = ExtentListener.getTestInstance();
    @Test(priority = 3,groups = "Smoke")
    public void verifyRegisterPageTitle() {
           extentTest.get().assignCategory("Smoke");
           extentTest.get().log(Status.PASS, "URL Loaded successfully");
            WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
            WebElementUtility.clickOnElement(registerField);
            String actualPageTitle = driver.getTitle();
            extentTest.get().log(Status.PASS, "Register page Title received  successfully");
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.REGISTER_PAGE);
            extentTest.get().log(Status.PASS, "Expected title received from Excel");
            String expectedResult = data.get(1);
            extentTest.get().log(Status.PASS, "Data in row 0, column 1 recieved from Excel");
            Assert.assertEquals(actualPageTitle, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test(priority = 4,groups = "Regression")
    public void verifyUserRegistration() {
        extentTest.get().assignCategory("Smoke");
        extentTest.get().log(Status.PASS, "URL Loaded successfully");
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String emailID= firstName+"."+lastName+"123@yahoo.com";
        String password = firstName+"."+lastName;
        extentTest.get().log(Status.PASS, "Assigned faker values successfully");

        WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
        WebElementUtility.clickOnElement(registerField);
        WebElement genderSelection = driver.findElement(By.xpath("//div[@class='gender']//label[text()='Female']"));
        WebElementUtility.clickOnElement(genderSelection);
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        WebElementUtility.enterValue(firstNameField,firstName);
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        WebElementUtility.enterValue(lastNameField,lastName);
        WebElement emailField = driver.findElement(By.id("Email"));
        WebElementUtility.enterValue(emailField,emailID);
        WebElement passwordField = driver.findElement(By.id("Password"));
        WebElementUtility.enterValue(passwordField,password);
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        WebElementUtility.enterValue(confirmPasswordField,password);
        WebElement registerButton = driver.findElement(By.id("register-button"));
        WebElementUtility.clickOnElement(registerButton);
        WebElement actualUserLoginElement = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualId = WebElementUtility.getTextFromElement(actualUserLoginElement);
        Assert.assertEquals(actualId, emailID, Messages.USER_REGISTRATION_FAILED);
    }
}

