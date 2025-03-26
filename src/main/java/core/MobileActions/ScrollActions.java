package core.MobileActions;

import core.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.locator.ElementLocator;
import utils.locator.ElementType;
import utils.logging.Logger;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ScrollActions {
    public static void scrollDown(int duration) {
        Logger.logInfo("Scrolling down");
        AppiumDriver driver = DriverManager.getMobileDriver();
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
        AppiumDriver driver = DriverManager.getMobileDriver();

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
