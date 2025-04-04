package page.mobile.BaseScreen;

import core.MobileActions.ClickActions;
import core.MobileActions.ElementVerification;
import core.MobileActions.InputActions;
import page.mobile.Dialog.DialogConstants;
import utils.locator.ElementType;
import utils.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class BaseScreen {

    public BaseScreen editLocalVariable(String varName, String varValue) {
        try {
            ClickActions.click(ElementType.XPATH, BaseConstants.LOCAL_VAR_NAME_TXT(varName));
            boolean eleTxfExist = ElementVerification.isElementDisplayed(ElementType.ID, BaseConstants.VAR_VALUE_TXF, 3);
            if (eleTxfExist) {
                InputActions.inputText(ElementType.ID, BaseConstants.VAR_VALUE_TXF, varValue);
            } else {
                String handleVarValue = varValue.toLowerCase();
                ClickActions.click(ElementType.ID, BaseConstants.VAR_VALUE_RDB(handleVarValue));
            }
            ClickActions.click(ElementType.ID, DialogConstants.OK_BUTTON);

            Logger.logInfo(String.format("Edit local variable success with Variable Name [%s] and Variable Value [%s]",
                    varName, varValue));
        } catch (Exception e) {
            Logger.logError(String.format("Fail to edit local variable. " + e));
        }
        return this;
    }

    public BaseScreen verifyEntryDisplayed(String marcoName, String entryName, String entryDetail, String index) {
        try {
            List<String[]> elementsToCheck = new ArrayList<>();
            String handleEntryName = BaseConstants.ENTRY_NAME(marcoName, entryName, index)
                    .replace("[android.widget.LinearLayout", marcoName.equalsIgnoreCase(
                            "Local Variables") ? "[android.widget.FrameLayout" : "[android.widget.LinearLayout");
            elementsToCheck.add(new String[]{"Entry Name", entryName, handleEntryName});

            // Chỉ thêm Entry Detail nếu nó không rỗng
            if (!entryDetail.isEmpty()) {
                String handleEntryDetail = BaseConstants.ENTRY_DETAIL(marcoName, entryDetail, index)
                        .replace("[android.widget.LinearLayout", marcoName.equalsIgnoreCase(
                                "Local Variables") ? "[android.widget.FrameLayout" : "[android.widget.LinearLayout");
                elementsToCheck.add(new String[]{"Entry Detail", entryDetail, handleEntryDetail});
            }

            for (String[] element : elementsToCheck) {
                boolean isExist = ElementVerification.isElementDisplayed(ElementType.XPATH, element[2]);

                if (isExist) {
                    Logger.logPassed(String.format(
                            "%s display with [Name] is [%s], [%s] is [%s] on location [%s]",
                            element[0], marcoName, element[0], element[1], index));
                } else {
                    Logger.logError(String.format(
                            "%s display with [Name] is [%s], [%s] is [%s] on location [%s]",
                            element[0], marcoName, element[0], element[1], index));
                }
            }

        } catch (Exception e) {
            Logger.logError(String.format("Fail to verify Entry Displayed. " + e));
        }
        return this;
    }
}
