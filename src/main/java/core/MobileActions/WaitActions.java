package core.MobileActions;

import core.driver.DriverManager;
import utils.locator.ElementLocator;
import utils.locator.ElementType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.contants.Timeouts.IMPLICIT_WAIT;

public class WaitActions {
    private static WebDriverWait getWait(int... timeouts) {
        return new WebDriverWait(DriverManager.getMobileDriver(), Duration.ofSeconds(IMPLICIT_WAIT));
    }

    public static WebElement waitForElementVisible(ElementType type, String value, int... timeouts) {
        return getWait(timeouts).until(ExpectedConditions.visibilityOfElementLocated(ElementLocator.getBy(type, value)));
    }

    public static WebElement waitForElementToBeClickable(ElementType type, String value, int... timeouts) {
        return getWait(timeouts).until(ExpectedConditions.elementToBeClickable(ElementLocator.getBy(type, value)));
    }
}
