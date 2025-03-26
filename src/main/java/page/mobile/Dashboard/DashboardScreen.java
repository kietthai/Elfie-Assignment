package page.mobile.Dashboard;

import core.MobileActions.ClickActions;
import utils.locator.ElementType;
import utils.logging.Logger;

public class DashboardScreen {

    public DashboardScreen clickItemOnMenu(String itemMenu) {
        try {
            ClickActions.click(ElementType.XPATH, DashboardConstants.MENU_ITEM(itemMenu));
            Logger.logInfo(String.format("Clicking [%s] item on Dashboard screen.", itemMenu));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to clicking [%s] item on Dashboard screen." + e, itemMenu));
        }
        return this;
    }

}
