package com.action.MobileActions;

import com.action.WaitActions;
import com.drivers.DriverManager;
import com.utils.ElementLocator;
import com.utils.ElementType;
import com.utils.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ElementVerification {

    public static boolean isElementDisplayed(ElementType type, String value) {
        try {
            WebElement element = WaitActions.waitForElementVisible(type, value);
            boolean displayed = element.isDisplayed();
            Logger.logInfo("Element [" + value + "] is displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            Logger.logInfo("Element [" + value + "] not found.");
            return false;
        }
    }

    public static boolean isElementEnabled(ElementType type, String value) {
        try {
            WebElement element = WaitActions.waitForElementVisible(type, value);
            boolean enabled = element.isEnabled();
            Logger.logInfo("Element [" + value + "] is enabled: " + enabled);
            return enabled;
        } catch (Exception e) {
            Logger.logInfo("Element [" + value + "] not found.");
            return false;
        }
    }

    public static boolean isElementSelected(ElementType type, String value) {
        try {
            WebElement element = WaitActions.waitForElementVisible(type, value);
            boolean selected = element.isSelected();
            Logger.logInfo("Element [" + value + "] is selected: " + selected);
            return selected;
        } catch (Exception e) {
            Logger.logInfo("Element [" + value + "] not found.");
            return false;
        }
    }
}
