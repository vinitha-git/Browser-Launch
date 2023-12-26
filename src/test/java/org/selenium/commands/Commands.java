package org.selenium.commands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Commands extends BrowserLaunch {
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
    public void verifyPartialLinkTest() {
        driver.get("https://demo.guru99.com/test/newtours/");
        WebElement element = driver.findElement(By.partialLinkText("destination"));
        element.click();
    }

    @Test
    public void verifyDemoWebShopUserLoginUsingXpath() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginField = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
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
    public void verifyDemoWebShopUserLoginUsingCssSelector() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement loginField = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
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

    @Test
    public void validateTotalNoOfTags() {
        driver.get("https://demowebshop.tricentis.com/");
        List<WebElement> tag = driver.findElements(By.tagName("Input"));
        System.out.println(tag.size());
    }

    @Test
    public void verifyNavigationCommands() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement element = driver.findElement(By.xpath("//a[@class='ico-register']"));
        element.click();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='FirstName']"));
        firstNameElement.sendKeys("Vinitha");
        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='LastName']"));
        lastNameElement.sendKeys("Edwin");
        WebElement emailElement = driver.findElement(By.xpath("//input[@name='Email']"));
        emailElement.sendKeys("vinithaedwin@gmail.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
    }

    @Test
    public void verifyIsSelected() {
        boolean isMaleSelected;
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement maleElement = driver.findElement(By.xpath("//input[@id='gender-male']"));
        isMaleSelected = maleElement.isSelected();
        Assert.assertFalse(isMaleSelected, "Male radio button is selected");
        System.out.println("Gender Male Before Selection " + isMaleSelected);
        maleElement.click();
        isMaleSelected = maleElement.isSelected();
        Assert.assertTrue(isMaleSelected, "Male radio button is not selected ");
        System.out.println("Gender Male After Selection " + isMaleSelected);

    }

    @Test
    public void verifyIsEnabled() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeElement = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
        boolean isSubscribeEnabled = subscribeElement.isEnabled();
        Assert.assertTrue(isSubscribeEnabled, "subscribe button is not enabled");
    }

    @Test
    public void verifyIsDisplayed() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement voteElement = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        boolean isVoteDisplayed = voteElement.isDisplayed();
        Assert.assertTrue(isVoteDisplayed, "vote button is not diaslayed");
    }

    @Test
    public void verifyCommunityPoll() {
        driver.get("https://demowebshop.tricentis.com/");
        // List<WebElement> communityPollElements = driver.findElements(By.tagName("Label"));
        List<WebElement> communityPollElements = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        for (WebElement i : communityPollElements) {
            String s = i.getText();
            if (s.equals("Poor")) {
                i.click();
            }
        }
    }

    @Test
    public void verifyValueSelectFromDropDown() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryElement = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryElement);
        // select.selectByVisibleText("INDIA");
        //select.selectByIndex(23);
        select.selectByValue("IRAQ");
        WebElement selectedCountry = select.getFirstSelectedOption();
        System.out.println(selectedCountry.getText());
    }

    @Test
    public void verifyTotalNoOfDropDownValuesInUI() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement countryElement = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(countryElement);
        List<WebElement> dropDownValues = select.getOptions();
        System.out.println(dropDownValues.size());
    }

    @Test
    public void verifySeleniumCommands() {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        WebElement seleniumElement = driver.findElement(By.xpath("//select[@name='selenium_commands']"));
        Select select = new Select(seleniumElement);
        boolean isMultiple = select.isMultiple();
        System.out.println(isMultiple);
        select.selectByVisibleText("Browser Commands");
        select.selectByVisibleText("sSwitch Command");

        List<WebElement> multiselectOptions = select.getAllSelectedOptions();
        for (WebElement e : multiselectOptions) {
            String element = e.getText();
            System.out.println(element);
        }
        //select.deselectAll();
        select.deselectByValue("Switch Command");
    }

    @Test
    public void verifyFileUpload() {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement fileUploadElement = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        String filepath = new File("src/main/resources/selenium.docx").getAbsolutePath();
        fileUploadElement.sendKeys(filepath);
        WebElement termsElement = driver.findElement(By.xpath("//input[@id='terms']"));
        termsElement.click();
        WebElement submitElement = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitElement.click();
    }

    @Test
    public void verifySubscribeButtonText() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeElement = driver.findElement(By.id("newsletter-subscribe-button"));
        String actual = subscribeElement.getAttribute("value");
        String expected = "Subscribe";
        Assert.assertEquals(actual, expected, "Invalid Subscribe button text found");
    }

    @Test
    public void validateSimpleAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickMeElement = driver.findElement(By.id("alertButton"));
        clickMeElement.click();
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText();
        String expected = "You clicked a button";
        Assert.assertEquals(actual, expected, "Button is not clicked");
        alert.accept();
    }

    @Test
    public void validateConfirmButton() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickElement = driver.findElement(By.id("confirmButton"));
        clickElement.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        String actual = confirmResult.getText();
        Assert.assertEquals(actual, "You selected Cancel", "Invalid alert found");

    }

    @Test
    public void validatePromptButton() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickElement = driver.findElement(By.id("promtButton"));
        clickElement.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Vinitha");
        alert.accept();

        WebElement promptResult = driver.findElement(By.id("promptResult"));
        String actual = promptResult.getText();
        Assert.assertEquals(actual, "You entered Vinitha", "Invalid alert found");
        //https://www.geeksforgeeks.org/set-iterator-method-in-java-with-examples/
    }

    @Test
    public void verifyCustomerDelete() {
        driver.get(" https://demo.guru99.com/test/delete_customer.php");
        WebElement idElement = driver.findElement(By.name("cusid"));
        idElement.sendKeys("12345");
        WebElement submitElement = driver.findElement(By.name("submit"));
        submitElement.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actual = alert.getText();
        String expected = "Customer Successfully Delete!";
        Assert.assertEquals(actual, expected, "Customer not deleted");
        alert.accept();
    }

    @Test
    public void verifyMultipleWindowHAndling(){
        driver.get(" https://demo.guru99.com/popup.php");
        String parentWindowHandleId= driver.getWindowHandle();
        System.out.println(parentWindowHandleId);
        WebElement submitElement = driver.findElement(By.linkText("Click Here"));
        submitElement.click();
        Set<String> windowHandleIDs=driver.getWindowHandles();
        System.out.println(windowHandleIDs);
        Iterator<String> value = windowHandleIDs.iterator();
        while( value.hasNext())
        {
            String handleId= value.next();
            if(!handleId.equals(parentWindowHandleId)) {
                System.out.println("Parent window of child window "+handleId);
                driver.switchTo().window(handleId);
                WebElement emailIdElement = driver.findElement(By.xpath("//input[@name='emailid']"));
                emailIdElement.sendKeys("vinithaedwin.test@gmail.com");
                WebElement submitBtnElement = driver.findElement(By.xpath("//input[@name='btnLogin']"));
                submitBtnElement.click();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowHandleId);
    }
    @Test
    public void verifyFrames() {
        driver.get("https://demoqa.com/frames");
        List<WebElement> iframeTags = driver.findElements(By.tagName("iframe"));
        int size = iframeTags.size();
        System.out.println("Total No of iframes in the webpage is " + size);
        //driver.switchTo().frame(3);
        //driver.switchTo().frame("frame1");
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        WebElement frameText = driver.findElement(By.id("sampleHeading"));
        System.out.println("iframe text = " + frameText.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void verifyRightClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).build().perform();
    }

    @Test
    public void verifyDoubleClick() {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).build().perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }
    @Test
    public void verifyDragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragButton= driver.findElement(By.id("draggable"));
        WebElement dropButton=driver.findElement(By.id("droppable"));
        Actions action=new Actions(driver);
        action.dragAndDrop(dragButton,dropButton).build().perform();

    }
    @Test
    public void dragAndDropByOffset() {
        driver.get("https://demoqa.com/dragabble");
        WebElement dragBox= driver.findElement(By.id("dragBox"));
        Actions action=new Actions(driver);
        action.dragAndDropBy(dragBox,150,150).build().perform();
    }
    @Test
    public void verifyMouseOver() {
        driver.get("https://demoqa.com/menu/");
        WebElement selectItemButton= driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions action=new Actions(driver);
        action.moveToElement(selectItemButton).build().perform();
        WebElement subListButton= driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.moveToElement(subListButton).build().perform();
    }
    @Test
    public void verifyJavaScriptClickAndSendKeys(){
       driver.get("https://demowebshop.tricentis.com/");
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('newsletter-email').value='test@test.com'");
        jse.executeScript("document.getElementById('newsletter-subscribe-button').click()");
    }

    @Test
    public void verifyVerticalScroll(){
        driver.get("https://demowebshop.tricentis.com/");
        JavascriptExecutor jse= (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void verifyScreenshotAfterTestFail() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement login = driver.findElement(By.className("ico-login"));
        login.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("vinithaedwin.test@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Simple@123");
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        WebElement userLogin = driver.findElement(By.className("account"));
        String actualUserLogin = userLogin.getText();
        String expectedUserLogin = "vinithaedwin.test@gmail.com";
        Assert.assertEquals(actualUserLogin, expectedUserLogin, "Login Failed");
    }
    @Test
    public void verifyWait() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
        WebElement clickBtn= driver.findElement(By.id("timerAlertButton"));
        clickBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        //Thread.sleep(6000);
        Alert alerts= driver.switchTo().alert();
        alerts.accept();
    }

    @Test
    public void verifyFluentWait() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
        WebElement clickBtn= driver.findElement(By.id("timerAlertButton"));
        clickBtn.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alerts= driver.switchTo().alert();
        alerts.accept();
    }
    @Test
    public void verifyDiffBetweenFindElementandFindElements() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement subscribeButton =driver.findElement(By.id("newsletter-subscribe-button"));
        System.out.println("WebElement on match " +subscribeButton);
        List<WebElement> communityPoll=driver.findElements(By.xpath("//li[@class='answer']//label"));
        int size=communityPoll.size();
        System.out.println("Size of list on match " +size);
        //onZeromatch
        List<WebElement> communityPollonZeroMatch=driver.findElements(By.xpath("//input[@class='answer123']//label"));
        int sizeonzeroMatch=communityPollonZeroMatch.size();
        System.out.println("Size of list on zero match " +sizeonzeroMatch);
        //WebElement subscribeButtononZeromatch =driver.findElement(By.id("newsletter-subscribe-button123"));
        //on Oneplus match
        WebElement communityPollonOnePlusMatch=driver.findElement(By.xpath("//li[@class='answer']//label"));
        communityPollonOnePlusMatch.click();
    }
    @Test
    public void verifyDiffBetweenCloseAndQuit() {
        driver.get("https://demo.guru99.com/popup.php");
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
    }
}


