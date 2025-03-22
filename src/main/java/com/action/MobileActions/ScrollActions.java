package com.action.MobileActions;

import com.drivers.DriverManager;
import com.utils.ElementLocator;
import com.utils.ElementType;
import com.utils.Logger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ScrollActions {
    public static void scrollDown(int duration) {
        Logger.logInfo("Scrolling down");
        AppiumDriver driver = DriverManager.getDriver();
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        PointOption startPoint = PointOption.point(width / 2, (int) (height * 0.8));
        PointOption endPoint = PointOption.point(width / 2, (int) (height * 0.2));

        new TouchAction<>((PerformsTouchActions) driver)
                .press(startPoint)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public static void scrollToElement(ElementType type, String value) {
        Logger.logInfo("Scrolling to element: " + value);
        AppiumDriver driver = DriverManager.getDriver();

        while (true) {
            try {
                WebElement element = driver.findElement(ElementLocator.getBy(type, value));
                if (element.isDisplayed()) {
                    Logger.logInfo("Element found: " + value);
                    break;
                }
            } catch (Exception e) {
                scrollDown(1000);
            }
        }
    }
}
