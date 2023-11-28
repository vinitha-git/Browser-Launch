package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
    @Test
    public void verifySwagLabsUserLogin() {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement swagLog = driver.findElement(By.className("app_logo"));
        String actualSwagLogoText = swagLog.getText();
        String expectedSwagLogoText = "Swag Labs";
        Assert.assertEquals(actualSwagLogoText, expectedSwagLogoText, "Invalid Logo text found in Login page");
    }

    @Test
    public void verifyDemoLogin() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();
        String currentURL = driver.getCurrentUrl();
        String expectedUrl = "https://demowebshop.tricentis.com/login";
        Assert.assertEquals(currentURL, expectedUrl, "Invalid Url found in Login page");
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Simple@123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.className("account"));
        String actualId = actualUserLoginElement.getText();
        String expectedLoginId = "vinithaedwin.test@gmail.com";
        Assert.assertEquals(actualId, expectedLoginId, "User Login failed");
    }

    @Test
    public void verifyDemoToursRegistration() {
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

    @Test
    public void verifyLinkText() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.linkText("your destination"));
        element.click();
    }
    @Test
    public void verifyPartialLinkTest(){
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.partialLinkText("destination"));
        element.click();
    }
    @Test
    public void verifyDemoWebShopUserLoginUsingXpath(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginField= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        loginField.click();
        WebElement emailField = driver.findElement(By.xpath("//*[@id='Email']"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='Password']"));
        passwordField.sendKeys("Simple@123");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        String actualId = actualUserLoginElement.getText();
        String expectedLoginId = "vinithaedwin.test@gmail.com";
        Assert.assertEquals(actualId, expectedLoginId, "User Login failed");
    }
    @Test
    public void verifyDemoWebShopUserLoginUsingCssSelector(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginField= driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
        loginField.click();
        WebElement emailField = driver.findElement(By.cssSelector("#Email"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.cssSelector("#Password"));
        passwordField.sendKeys("Simple@123");
        WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
        loginButton.click();
        WebElement actualUserLoginElement = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(1) > a"));
        String actualId = actualUserLoginElement.getText();
        String expectedLoginId = "vinithaedwin.test@gmail.com";
        Assert.assertEquals(actualId, expectedLoginId, "User Login failed");
    }
}