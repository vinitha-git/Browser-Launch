package org.selenium.testngcommands;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.selenium.automationcore.Base;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    @Test
    public void verifyLoginPageTitle() {
        WebElement loginField = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginField.click();
        String actualpageTitle = driver.getTitle();
        String expectedpageTitle = "Demo Web Shop. Login";
        Assert.assertEquals(actualpageTitle, expectedpageTitle, "Invalid Title found");
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
        Assert.assertEquals(actualResult, expectedResult, "Login failed");
    }
}
