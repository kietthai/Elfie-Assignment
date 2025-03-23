package com.pages.Marco1.Marco;

import com.action.MobileActions.ClickActions;
import com.action.MobileActions.ElementVerification;
import com.action.MobileActions.InputActions;
import com.pages.Marco1.AddLocalVariable.AddLocalVariableConstants;
import com.utils.ElementType;
import com.utils.Logger;

import java.util.ArrayList;
import java.util.List;

public class MarcoScreen {

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

    public MarcoScreen verifyEntryDisplayed(String marcoName, String entryName, String entryDetail, String index)
    {
        try{
            List<String[]> elementsToCheck = new ArrayList<>();
            String handleMacroEntryName = MarcoConstants.MACRO_ENTRY_NAME(marcoName, entryName, index)
                    .replace("LinearLayout", marcoName.equalsIgnoreCase(
                            "Local Variables") ? "FrameLayout" : "LinearLayout");
            elementsToCheck.add(new String[]{"Entry Name", entryName, handleMacroEntryName});

            // Chỉ thêm Entry Detail nếu nó không rỗng
            if (!entryDetail.isEmpty()) {
                String handleMacroEntryDetail = MarcoConstants.MACRO_ENTRY_DETAIL(marcoName, entryDetail, index)
                        .replace("LinearLayout", marcoName.equalsIgnoreCase(
                                "Local Variables") ? "FrameLayout" : "LinearLayout");
                elementsToCheck.add(new String[]{"Entry Detail", entryDetail, handleMacroEntryDetail});
            }

            for (String[] element : elementsToCheck) {
                boolean isExist = ElementVerification.isElementDisplayed(ElementType.XPATH, element[2]);

                if (isExist) {
                    Logger.logPassed(String.format(
                            "%s display with [Marco Name] is [%s], [%s] is [%s] on location [%s]",
                            element[0], marcoName, element[0], element[1], index));
                } else {
                    Logger.logError(String.format(
                            "%s display with [Marco Name] is [%s], [%s] is [%s] on location [%s]",
                            element[0], marcoName, element[0], element[1], index));
                }
            }

        } catch (Exception e){
            Logger.logError(String.format("Fail to verify Entry Displayed. " + e));
        }
        return this;
    }

    public MarcoScreen editLocalVariable(String varName, String varValue) {
        try{
            ClickActions.click(ElementType.XPATH, MarcoConstants.LOCAL_VAR_NAME_TXT(varName));
            InputActions.inputText(ElementType.ID, MarcoConstants.VAR_VALUE_TXF, varValue);
            ClickActions.click(ElementType.ID, AddLocalVariableConstants.OK_BUTTON);

            Logger.logInfo(String.format("Edit local variable success with Variable Name [%s] and Variable Value [%s]",
                    varName, varValue));
        } catch (Exception e){
            Logger.logError(String.format("Fail to edit local variable. " + e));
        }
        return this;
    }
}
