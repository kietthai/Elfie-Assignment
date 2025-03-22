package com.pages.Onboard;

import com.action.MobileActions.ClickActions;
import com.utils.ElementType;
import com.utils.Logger;

public class OnboardScreen {

    public OnboardScreen clickOnSkipButton() {
        try{
            ClickActions.click(ElementType.ID, OnboardConstants.SKIP_BUTTON);
            Logger.logInfo("Clicking [Skip] button on Onboard screen.");
        } catch (Exception e){
            Logger.logError("Fail to clicking [Skip] button on Onboard screen.");
        }
        return this;
    }

}
