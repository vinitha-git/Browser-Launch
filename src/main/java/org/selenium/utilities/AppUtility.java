package org.selenium.utilities;

import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;

import java.util.List;

public class AppUtility {
    public static Boolean selectValueFromRadioButton(List<WebElement> values, String valueToSelect)
    {
        boolean status = false;
        for (WebElement value : values) {
            String text = value.getText();
            if (text.equals(valueToSelect)) {
                value.click();
                status=WebElementUtility.isElementSelected(value);
               break;

            }
        }
        return status;
    }
}
