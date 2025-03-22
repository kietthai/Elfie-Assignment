package com.action.MobileActions;

import com.action.WaitActions;
import com.utils.ElementLocator;
import com.utils.ElementType;
import com.utils.Logger;
import org.openqa.selenium.WebElement;

public class InputActions {
    public static void inputText(ElementType type, String value, String text) {
        Logger.logInfo("Entering text into element: " + value);
        WebElement element = WaitActions.waitForElementVisible(type, value);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(ElementType type, String value) {
        Logger.logInfo("Getting text from element: " + value);
        WebElement element = WaitActions.waitForElementVisible(type, value);
        return element.getText();
    }
}
