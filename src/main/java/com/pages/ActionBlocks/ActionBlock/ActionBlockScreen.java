package com.pages.ActionBlocks.ActionBlock;

import com.action.MobileActions.ClickActions;
import com.action.WaitActions;
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

    public ActionBlockScreen verifyActionBlockDisplayed
            (String indexActionBlock, String actionName, String actionDesc) {
        try{
            WaitActions.waitForElementVisible(ElementType.XPATH,
                    ActionBlockConstants.ACTION_BLOCK_NAME(actionName, indexActionBlock));
            WaitActions.waitForElementVisible(ElementType.XPATH,
                    ActionBlockConstants.ACTION_BLOCK_DESC(actionDesc, indexActionBlock));
            Logger.logInfo(String.format(
                    "Action Block display on [index]: [%s] with [Action Name]: [%s] and [Action Description]: [%s]"
                    , indexActionBlock, actionName, actionDesc));
        } catch (Exception e){
            Logger.logError(String.format(
                    "Action Block display on [index]: [%s] with [Action Name]: [%s] and [Action Description]: [%s]"
                    , indexActionBlock, actionName, actionDesc) + e);
        }
        return this;
    }
}
