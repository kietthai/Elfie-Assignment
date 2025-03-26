package page.mobile.Marco.AddTrigger;

import core.MobileActions.ClickActions;
import utils.locator.ElementType;
import utils.logging.Logger;

public class AddTriggerScreen {
    public AddTriggerScreen chooseCategory(String category) {
        try {
            ClickActions.click(ElementType.XPATH, AddTriggerConstants.CATEGORY_TEXT(category));
            Logger.logInfo(String.format("Choose category [%s] on Add Trigger screen.", category));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to choose category [%s] button on Add Trigger screen. " + e, category));
        }
        return this;
    }

    public AddTriggerScreen chooseItem(String item) {
        try {
            ClickActions.click(ElementType.XPATH, AddTriggerConstants.ITEM_TEXT(item));
            Logger.logInfo(String.format("Choose item [%s] on Add Trigger screen.", item));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to choose item [%s] on Add Trigger screen." + e, item));
        }
        return this;
    }

}
