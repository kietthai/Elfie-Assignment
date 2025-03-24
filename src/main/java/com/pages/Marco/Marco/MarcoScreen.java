package com.pages.Marco.Marco;

import com.action.MobileActions.ClickActions;
import com.action.MobileActions.ElementVerification;
import com.action.MobileActions.InputActions;
import com.pages.BaseScreen.BaseScreen;
import com.pages.Dialog.DialogConstants;
import com.utils.ElementType;
import com.utils.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MarcoScreen extends BaseScreen {

    public MarcoScreen clickAddButton(String btnName) {
        try{
            if (btnName.equalsIgnoreCase("Add Local Variable")){
                ClickActions.click(ElementType.ID, MarcoConstants.ADD_LOCAL_VAR_LABEL);
                ClickActions.click(ElementType.XPATH, MarcoConstants.ADD_LOCAL_VAR_BUTTON);
            }else {
                ClickActions.click(ElementType.XPATH, MarcoConstants.ADD_BUTTON(btnName));
            }
            Logger.logInfo(String.format("Clicking [%s] item on Marco screen.", btnName));
        } catch (Exception e){
            Logger.logError(String.format("Fail to clicking [%s] item on Marco screen. " + e, btnName));
        }
        return this;
    }

    public MarcoScreen verifyEntryDisplayed(String entryTitle, String entryName, String entryDetail, String index)
    {
        super.verifyEntryDisplayed(entryTitle, entryName, entryDetail, index);
        return this;
    }

    public MarcoScreen editLocalVariable(String varName, String varValue) {
        super.editLocalVariable(varName, varValue);
        return this;
    }
}
