package org.selenium.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ObsquraZoneTest extends BrowserLaunch {

    @Test
    public void verifySingleInputField(){
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");//
        WebElement messageField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
        messageField.sendKeys("Hello Vinitha");
        WebElement showButton = driver.findElement(By.xpath("//button[@id='button-one']"));
        showButton.click();
        WebElement messageElement = driver.findElement(By.xpath("//div[@id='message-one']"));
        String expectedResult= messageElement.getText();
        String actualResult= "Your Message : Hello Vinitha";
        Assert.assertEquals(actualResult,expectedResult,"InValid message");
        //https://selenium.obsqurazone.com/index.php
    }
    @Test
    public void verifyTwoInputFieldsOutput(){

        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");//
        WebElement aField = driver.findElement(By.xpath("//input[@id='value-a']"));
        aField.sendKeys("10");
        WebElement bField = driver.findElement(By.xpath("//input[@id='value-b']"));
        bField.sendKeys("20");
        WebElement getTotalButton = driver.findElement(By.xpath("//button[@id='button-two']"));
        getTotalButton.click();
        int valueA= Integer.parseInt(aField.getAttribute("value"));
        int valueB= Integer.parseInt(bField.getAttribute("value"));
        int sum= valueA + valueB;
        int expectedResult= sum;
        WebElement messageField = driver.findElement(By.xpath("//div[@id='message-two']"));
        String[] split_message=messageField.getText().split(": ");
        int actualResult= Integer.parseInt(split_message[1]);
        Assert.assertEquals(actualResult,expectedResult,"InValid message");
    }
    @Test
    public void verifySingleCheckboxDemo(){

        boolean isSelected;
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@id='gridCheck']"));
        isSelected= checkBoxElement.isSelected();
        Assert.assertFalse(isSelected," Check box is selected");
        checkBoxElement.click();
        isSelected= checkBoxElement.isSelected();
        Assert.assertTrue(isSelected,"Check box is not selected ");
    }

    @Test
    public void verifyRadioButtonDemo(){
        boolean isMaleSelected;
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement maleElement = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        isMaleSelected= maleElement.isSelected();
        Assert.assertFalse(isMaleSelected,"Male radio button is selected");
        maleElement.click();
        isMaleSelected= maleElement.isSelected();
        Assert.assertTrue(isMaleSelected,"Male radio button is not selected ");
        WebElement showSelectedValueElement = driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValueElement.click();
        WebElement showSelectedMessageElement = driver.findElement(By.xpath("//div[@id='message-one']"));
        String actualResult= showSelectedMessageElement.getText();
        String expectedResult= "Radio button 'Male' is checked";
        Assert.assertEquals(actualResult,expectedResult,"Radio button 'Male is not checked");

        boolean isFemaleSelected;
        WebElement femaleElement = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
        isFemaleSelected= femaleElement.isSelected();
        Assert.assertFalse(isFemaleSelected,"Female radio button is selected");
        femaleElement.click();
        isFemaleSelected= femaleElement.isSelected();
        Assert.assertTrue(isFemaleSelected,"Female radio button is not selected ");
        showSelectedValueElement.click();
        String actualFResult= showSelectedMessageElement.getText();
        String expectedFResult= "Radio button 'Female' is checked";
        Assert.assertEquals(actualFResult,expectedFResult,"Radio button 'Female is not checked");
    }

@Test
public void verifyFormWithValidation() {
    driver.get("https://selenium.obsqurazone.com/form-submit.php");
    WebElement firstNameElement = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
    firstNameElement.sendKeys("test");
    Assert.assertNotNull(firstNameElement);
    WebElement lastNameElement = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
    lastNameElement.sendKeys("test");
    Assert.assertNotNull(lastNameElement);
    WebElement userNameElement = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
    userNameElement.sendKeys("test123");
    Assert.assertNotNull(userNameElement);
    WebElement cityElement = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
    cityElement.sendKeys("rom");
    Assert.assertNotNull(cityElement);
    WebElement stateElement = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
    stateElement.sendKeys("rom");
    Assert.assertNotNull(stateElement);
    WebElement zipElement = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
    zipElement.sendKeys("894");
    Assert.assertNotNull(zipElement);

    boolean isSelected;
    WebElement checkBoxElement = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
    isSelected = checkBoxElement.isSelected();
    Assert.assertFalse(isSelected, " Check box is selected");
    checkBoxElement.click();
    isSelected = checkBoxElement.isSelected();
    Assert.assertTrue(isSelected, "Check box is not selected ");

    WebElement submitElement = driver.findElement(By.xpath("//button[@type='submit']"));
    submitElement.click();
    WebElement messageElement = driver.findElement(By.xpath("//div[@id='message-one']"));
    String actualMessageResult = messageElement.getText();
    String expectedMResult = "Form has been submitted successfully!";
    Assert.assertEquals(actualMessageResult, expectedMResult, "Form is not submitted successfully");
}
    @Test
    public void verifyColorSelectFromDropDown(){
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorElement= driver.findElement(By.xpath("//select[@id='single-input-field']"));
        Select select = new Select(colorElement);
        select.selectByVisibleText("Red");
        WebElement selectedColor = select.getFirstSelectedOption();
        String actualResult= selectedColor.getText();
        WebElement msgElement= driver.findElement(By.xpath("//div[@id='message-one']"));
        String[] split_message=msgElement.getText().split(": ");
        String expectedResult= split_message[1];
        Assert.assertEquals(actualResult,expectedResult,"Invalid selection");
    }
    @Test
    public void verifyTotalNoOfValuesInDropDown(){
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorElement= driver.findElement(By.xpath("//select[@id='single-input-field']"));
        Select select = new Select(colorElement);
        List<WebElement> options= select.getOptions();
        int expectedCount =4;
        int actualCount= options.size();
        Assert.assertEquals(actualCount,expectedCount,"Invalid size");
    }
    @Test
    public void verifyValuesInColorSelectDropDown(){
        driver.get("https://selenium.obsqurazone.com/select-input.php");
        WebElement colorElement= driver.findElement(By.xpath("//select[@id='single-input-field']"));
        Select select = new Select(colorElement);
        List<WebElement> options= select.getOptions();
        List<String> actual= new ArrayList<>();
        for (WebElement e :options)
        {
            String element= e.getText();
            actual.add(element);
        }
        List<String> expected= new ArrayList<>();
        expected.add("-- Select --");
        expected.add("Red");
        expected.add("Yellow") ;
        expected.add("Green");
        Assert.assertEquals(actual,expected,"Invalid Data");
    }
    @Test
    public void verifyDropDownWithoutSelect() {
        driver.get("https://selenium.obsqurazone.com/jquery-select.php");
        WebElement stateDropDown=driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']//span[@class='select2-selection__arrow']"));
        stateDropDown.click();
        List<WebElement> DropDownWithoutSelect = driver.findElements(By.xpath("//li[contains(@class,'select2-results__option select2-results__option--selectable')]"));
        for (WebElement dropDownValueElements :DropDownWithoutSelect ) {
            String selectedState = dropDownValueElements.getText();
            if (selectedState.equals("California")) {
                dropDownValueElements.click();
                break;
            }
        }
    }
}