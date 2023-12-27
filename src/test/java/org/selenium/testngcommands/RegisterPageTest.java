package org.selenium.testngcommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.automationcore.Base;
import org.selenium.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends Base {
    @Test
    public void verifyRegisterPageTitle() {
        WebElement registerField = driver.findElement(By.xpath("//a[@class='ico-register']"));
        registerField.click();
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Demo Web Shop. Register";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Invalid title");
    }

    @Test
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
        Assert.assertEquals(actualId, emailID, "User Registration failed");
    }


}

