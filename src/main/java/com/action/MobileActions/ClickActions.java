package com.action.MobileActions;

import com.action.WaitActions;
import com.utils.ElementType;
import org.openqa.selenium.WebElement;

public class ClickActions {
    public static void click(ElementType type, String value) {
        WebElement element = WaitActions.waitForElementToBeClickable(type, value);
        element.click();
    }
}
