package com.action;

import com.drivers.DriverManager;
import com.utils.ElementLocator;
import com.utils.ElementType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.contants.Timeouts.IMPLICIT_WAIT;

public class WaitActions {
    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(IMPLICIT_WAIT));
    }

    public static WebElement waitForElementVisible(ElementType type, String value) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(ElementLocator.getBy(type, value)));
    }

    public static WebElement waitForElementToBeClickable(ElementType type, String value) {
        return getWait().until(ExpectedConditions.elementToBeClickable(ElementLocator.getBy(type, value)));
    }
}
