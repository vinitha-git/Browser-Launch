package org.selenium.testngcommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class RegisterPageTest extends Base {
    @Test(priority = 3)
    public void verifyRegisterPageTitle() {
            WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
            registerField.click();
            String actualPageTitle = driver.getTitle();
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.REGISTER_PAGE);
            String expectedResult = data.get(1);
            Assert.assertEquals(actualPageTitle, expectedResult, Messages.TITLE_MISMATCH);
    }

    @Test(priority = 4)
    public void verifyUserRegistration() {
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String emailID= firstName+"."+lastName+"123@yahoo.com";
        String password = firstName+"."+lastName;

        WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerField.click();
        WebElement genderSelection = driver.findElement(By.xpath("//div[@class='gender']//label[text()='Female']"));
        genderSelection.click();
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys(lastName);
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys(emailID);
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys(password);
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys(password);
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        String actualId = actualUserLoginElement.getText();
        Assert.assertEquals(actualId, emailID, Messages.USER_REGISTRATION_FAILED);
    }
}

