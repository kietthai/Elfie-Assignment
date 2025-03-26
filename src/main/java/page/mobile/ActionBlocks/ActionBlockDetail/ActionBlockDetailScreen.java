package page.mobile.ActionBlocks.ActionBlockDetail;

import core.MobileActions.ClickActions;
import core.MobileActions.InputActions;
import page.mobile.BaseScreen.BaseScreen;
import utils.locator.ElementType;
import utils.logging.Logger;

public class ActionBlockDetailScreen extends BaseScreen {

    public ActionBlockDetailScreen clickAddButton(String btnName) {
        try{
            String handleBtnName = ActionBlockDetailConstants.ACTION_BLOCK_ADD_BTN(btnName)
                            .replace(" ", "");
            ClickActions.click(ElementType.ID, handleBtnName);
            Logger.logInfo(String.format("Clicking [%s] item on Action Block Detail screen.", btnName));
        } catch (Exception e){
            Logger.logError(String.format("Fail to clicking [%s] item on  Action Block Detail screen. " + e, btnName));
        }
        return this;
    }

    public ActionBlockDetailScreen inputActionBlockTitle(String title) {
        try{
            InputActions.inputText(ElementType.ID, ActionBlockDetailConstants.ACTION_BLOCK_TITLE_TXF, title);
            Logger.logInfo(String.format("Input Action Block title with value [%s] success", title));
        } catch (Exception e){
            Logger.logError(String.format("Fail to clicking Input Action Block title" + e, title));
        }
        return this;
    }

    public ActionBlockDetailScreen inputActionBlockDesc(String desc) {
        try{
            InputActions.inputText(ElementType.ID, ActionBlockDetailConstants.ACTION_BLOCK_DESC_TXF, desc);
            Logger.logInfo(String.format("Input Action Block desc with value [%s] success", desc));
        } catch (Exception e){
            Logger.logError(String.format("Fail to clicking Input Action Block desc" + e, desc));
        }
        return this;
    }

    public ActionBlockDetailScreen editLocalVariable(String varName, String varValue) {
        super.editLocalVariable(varName, varValue);
        return this;
    }

    public ActionBlockDetailScreen verifyEntryDisplayed(String entryTitle, String entryName, String entryDetail, String index)
    {
        super.verifyEntryDisplayed(entryTitle, entryName, entryDetail, index);
        return this;
    }

    public ActionBlockDetailScreen clickExpandCollapseButton(String inOutVariable)
    {
        try{
            ClickActions.click(ElementType.ID, ActionBlockDetailConstants.COLLAPSE_EXPAND_BTN(inOutVariable));
            Logger.logInfo(String.format("Clicking [%s] Expand Collapse Button on Action Block Detail screen.", inOutVariable));
        } catch (Exception e){
            Logger.logError("Fail to clicking Input Action Block desc" + e);
        }
        return this;
    }

    public ActionBlockDetailScreen clickAcceptButton()
    {
        try{
            ClickActions.click(ElementType.ID, ActionBlockDetailConstants.ACCEPT_BTN);
            Logger.logInfo("Clicking [Accept] button success.");
        } catch (Exception e){
            Logger.logError("Fail to click [Accept] button." + e);
        }
        return this;
    }
}
