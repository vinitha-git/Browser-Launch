package org.selenium.testngcommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.automationcore.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends Base {
    @Test
    public void verifyHomePageTitle() {
        String actualResult = driver.getTitle();
        String expectedResult = "Demo Web Shop";
        Assert.assertEquals(actualResult, expectedResult, "Invalid title");

    }

    @Test
    public void verifyCommunityPollSelection() {
        List<WebElement> pollTexts = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        for (WebElement values : pollTexts) {
            String pollValuesTexts = values.getText();
            if (pollValuesTexts.equals("Poor")) {
                values.click();
            }
            boolean isButtonSelected = values.isSelected();
            Assert.assertFalse(isButtonSelected, "Value  selected");

        }
    }
}
