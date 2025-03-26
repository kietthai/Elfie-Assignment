package page.mobile.Onboard;

import core.MobileActions.ClickActions;
import utils.locator.ElementType;
import utils.logging.Logger;

public class OnboardScreen {

    public OnboardScreen clickOnSkipButton() {
        try {
            ClickActions.click(ElementType.ID, OnboardConstants.SKIP_BUTTON);
            Logger.logInfo("Clicking [Skip] button on Onboard screen.");
        } catch (Exception e) {
            Logger.logError("Fail to clicking [Skip] button on Onboard screen." + e);
        }
        return this;
    }

    public OnboardScreen clickOnBackButton() {
        try {
            ClickActions.click(ElementType.XPATH, OnboardConstants.BACK_BUTTON);
            Logger.logInfo("Clicking [Back] button on Onboard screen.");
        } catch (Exception e) {
            Logger.logError("Fail to clicking [Back] button on Onboard screen." + e);
        }
        return this;
    }
}
