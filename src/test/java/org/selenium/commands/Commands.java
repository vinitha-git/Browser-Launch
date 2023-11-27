package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
    @Test
    public void verifySwagLabsUserLogin(){
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField=driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement swagLog = driver.findElement(By.className("app_logo"));
        String actualSwagLogoText= swagLog.getText();
        String expectedSwagLogoText="Swag Labs";
        Assert.assertEquals(actualSwagLogoText, expectedSwagLogoText, "Invalid Logo text found in Login page");
    }

    @Test
    public void verifyDemoLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();
        String currentURL=driver.getCurrentUrl();
        String expectedUrl="https://demowebshop.tricentis.com/login";
        Assert.assertEquals(currentURL,expectedUrl,"Invalid Url found in Login page");
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Simple@123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement actualUserLoginElement=driver.findElement(By.className("account"));
        String actualId= actualUserLoginElement.getText();
        String expectedLoginId="vinithaedwin.test@gmail.com";
        Assert.assertEquals(actualId,expectedLoginId,"User Login failed");
    }
    @Test
    public void verifyDemoToursRegistration(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys("Vinitha");
        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys("Edwin");
        WebElement phoneField = driver.findElement(By.name("phone"));
        phoneField.sendKeys("9105956123");
        WebElement emailField = driver.findElement(By.id("userName"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement address1Field = driver.findElement(By.name("address1"));
        address1Field.sendKeys("Kazhakuttom");
        WebElement cityField = driver.findElement(By.name("city"));
        cityField.sendKeys("Thiruvananthapuram");
        WebElement stateField = driver.findElement(By.name("state"));
        stateField.sendKeys("Kerala");
        WebElement emailUserField = driver.findElement(By.id("email"));
        emailUserField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Simple@123");
        WebElement confirmPasswordField = driver.findElement(By.name("confirmPassword"));
        confirmPasswordField.sendKeys("Simple@123");
        WebElement submitButton = driver.findElement(By.name("submit"));
       // submitButton.click();
    }
}