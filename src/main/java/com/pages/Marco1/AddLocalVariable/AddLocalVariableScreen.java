package com.pages.Marco1.AddLocalVariable;

import com.action.MobileActions.ClickActions;
import com.action.MobileActions.InputActions;
import com.utils.ElementType;
import com.utils.Logger;

public class AddLocalVariableScreen {
    public AddLocalVariableScreen createNewVariable(String varName, String varType) {
        try {
            ClickActions.click(ElementType.ID, AddLocalVariableConstants.VARIABLE_TYPE_SPINNER);
            ClickActions.click(ElementType.XPATH, AddLocalVariableConstants.VARIABLE_TYPE_CTV(varType));
            InputActions.inputText(ElementType.ID, AddLocalVariableConstants.VARIABLE_NAME_TXF, varName);
            ClickActions.click(ElementType.ID, AddLocalVariableConstants.OK_BUTTON);

            Logger.logInfo(String.format("Create new local variable success with name [%s] and type [%s]"
                    ,varName, varType));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to create new local variable. " + e));
        }
        return this;
    }



}
