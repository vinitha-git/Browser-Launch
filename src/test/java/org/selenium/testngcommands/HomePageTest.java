package org.selenium.testngcommands;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.automationcore.Base;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageTest extends Base {
    @Test
    public void verifyHomePageTitle() {
        try {

            String actualResult = driver.getTitle();
            ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.HOME_PAGE);
            String expectedResult = data.get(1);
            Assert.assertEquals(actualResult, expectedResult, Messages.TITLE_MISMATCH);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void verifyCommunityPollSelection() {
        List<WebElement> pollTexts = driver.findElements(By.xpath("//li[@class='answer']//label[starts-with(@for,'pollanswers')]"));
        for (WebElement values : pollTexts) {
            String pollValuesTexts = values.getText();
            if (pollValuesTexts.equals(Constants.POOR)) {
                values.click();
            }
            boolean isButtonSelected = values.isSelected();
            Assert.assertFalse(isButtonSelected, Messages.VALUE_SELECTED);

        }
    }
}
