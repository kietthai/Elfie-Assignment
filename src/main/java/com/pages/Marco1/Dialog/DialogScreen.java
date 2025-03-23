package com.pages.Marco1.Dialog;

import com.action.MobileActions.ClickActions;
import com.utils.ElementType;
import com.utils.Logger;

public class DialogScreen {

    public DialogScreen selectOption(String option) {
        try{
            ClickActions.click(ElementType.XPATH, DialogConstants.OPTION_CTV(option));
            Logger.logInfo(String.format("Choosing [%s] item on Dialog.", option));
        } catch (Exception e){
            Logger.logError(String.format("Fail to choose [%s] item on Marco. " + e, option));
        }
        return this;
    }

    public DialogScreen clickOnOkButton() {
        try {
            ClickActions.click(ElementType.ID, DialogConstants.OK_BUTTON);
            Logger.logInfo("Clicking [OK] button on Dialog screen.");
        } catch (Exception e) {
            Logger.logError("Fail to clicking [OK] button on Dialog screen." + e);
        }
        return this;
    }

}
