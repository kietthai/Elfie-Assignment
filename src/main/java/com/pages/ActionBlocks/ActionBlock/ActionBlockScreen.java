package com.pages.ActionBlocks.ActionBlock;

import com.action.MobileActions.ClickActions;
import com.utils.ElementType;
import com.utils.Logger;

public class ActionBlockScreen {

    public ActionBlockScreen clickAddButton() {
        try{
            ClickActions.click(ElementType.XPATH, ActionBlockConstants.ADD_BUTTON);
            Logger.logInfo("Clicking [Add] button on Action Blocks screen.");
        } catch (Exception e){
            Logger.logError("Fail to click [Add] button on Action Blocks screen. " + e);
        }
        return this;
    }
}
