package page.mobile.Dialog;

import core.MobileActions.ClickActions;
import core.MobileActions.InputActions;
import utils.locator.ElementType;
import utils.logging.Logger;

public class DialogScreen {

    public DialogScreen selectOption(String option) {
        try {
            ClickActions.click(ElementType.XPATH, DialogConstants.OPTION_CTV(option));
            ClickActions.click(ElementType.ID, DialogConstants.SYSTEM_OK_BUTTON);
            Logger.logInfo(String.format("Choosing [%s] item on Dialog.", option));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to choose [%s] item on Dialog. " + e, option));
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

    public DialogScreen inputVariableName(String varName) {
        try {
            InputActions.inputText(ElementType.ID, DialogConstants.NEW_VARIABLE_TXF, varName);
            Logger.logInfo(String.format("Input variable name success with value [%s] on Dialog screen.", varName));
        } catch (Exception e) {
            Logger.logError("Fail to input variable name on Dialog screen." + e);
        }
        return this;
    }

    public DialogScreen createNewVariable(String varName, String varType) {
        try {
            chooseVariableType(varType);
            inputVariableName(varName);
            clickOnOkButton();

            Logger.logInfo(String.format("Create new local variable success with name [%s] and type [%s]"
                    , varName, varType));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to create new local variable. " + e));
        }
        return this;
    }

    private DialogScreen chooseVariableType(String varType) {
        ClickActions.click(ElementType.ID, DialogConstants.VARIABLE_TYPE_SPINNER);
        ClickActions.click(ElementType.XPATH, DialogConstants.OPTION_CTV(varType));
        return this;
    }

}
