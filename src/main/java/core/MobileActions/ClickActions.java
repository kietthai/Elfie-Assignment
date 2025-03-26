package core.MobileActions;

import utils.locator.ElementType;
import org.openqa.selenium.WebElement;

public class ClickActions {
    public static void click(ElementType type, String value) {
        WebElement element = WaitActions.waitForElementToBeClickable(type, value);
        element.click();
    }
}
