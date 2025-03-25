import com.base.BaseTest;
import com.google.gson.JsonObject;
import com.utils.Logger;
import com.utils.TestDataManager;
import org.testng.annotations.Test;

public class ActionBlocks extends BaseTest {

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataManager.class)
    public void ActionBlocks_TC02(JsonObject testData) {
        String blockTitle = testData.get("blockTitle").getAsString();
        String blockDesc = testData.get("blockDesc").getAsString();
        String inputVarName = testData.get("inputVarName").getAsString();
        String inputVarValue = testData.get("inputVarValue").getAsString();
        String actionName = testData.get("actionName").getAsString();
        String actionDetail = testData.get("actionDetail").getAsString();
        String outputVarName = testData.get("outputVarName").getAsString();
        String outputVarValue = testData.get("outputVarValue").getAsString();

        logStep(startStep(), "Open application");
        onboardScreen()
                .clickOnSkipButton()
                .clickOnBackButton();

        logStep(nextStep(), "Tap on Action Blocks Menu");
        dashboardScreen()
                .clickItemOnMenu("Action Blocks");

        logStep(nextStep(), "On Action Blocks Page, add an action block Name");
        actionBlockScreen()
                .clickAddButton();
        Logger.logWarning("Action Block Name has been moved to Action Block Detail screen");

        actionBlockDetailScreen()
                .inputActionBlockTitle(blockTitle);

        logStep(nextStep(), "Add an action block description");
        actionBlockDetailScreen()
                .inputActionBlockDesc(blockDesc);

        logStep(nextStep(), "Tap on Add button");
        Logger.logWarning("Add button has been moved to Action Blocks screen");

        logStep(nextStep(), "On Action Block Detail Page, add an input variable name");
        logStep(nextStep(), "Add Boolean value and OK");
        actionBlockDetailScreen()
                .clickAddButton("Input Variable");

        dialogScreen()
                .createNewVariable(inputVarName, "Boolean");

        logStep(nextStep(), "Select newly added input variable");
        logStep(nextStep(), "Select the Value to True");
        actionBlockDetailScreen()
                .clickExpandCollapseButton("input")
                .editLocalVariable(inputVarName, inputVarValue);

        logStep(nextStep(), "On Action Blocks Detail Page, tap on Action to add an action");
        actionBlockDetailScreen()
                .clickAddButton("Action");

        logStep(nextStep(), "On Action page, tap on Logging");
        logStep(nextStep(), "Select Clear Log");
        addActionScreen()
                .chooseCategory("Logging")
                .chooseItem(actionName);

        logStep(nextStep(), "Select System Log and OK");
        dialogScreen()
                .selectOption(actionDetail);

        logStep(nextStep(), "On Action Block Detail Page, add an output variable name");
        logStep(nextStep(), "Add String value and OK");
        actionBlockDetailScreen()
                .clickAddButton("Output Variable");
        dialogScreen()
                .createNewVariable(outputVarName, "String");

        logStep(nextStep(), "Select newly added input variable");
        logStep(nextStep(), "Add String value = 'This is a testing string'");
        actionBlockDetailScreen()
                .clickExpandCollapseButton("output")
                .editLocalVariable(outputVarName, outputVarValue);

        logStep(nextStep(), "Verify information display in Action Block detail page");
        logStep("Verify point: ", "The input variable, action, output variable should show correct information");
        actionBlockDetailScreen()
                .verifyEntryDisplayed("Input Variables",
                        inputVarName,
                        "Default: "+ inputVarValue,
                        "1")
                .verifyEntryDisplayed("Actions",
                        actionName,
                        actionDetail,
                        "1")
                .verifyEntryDisplayed("Output Variables",
                        outputVarName,
                        "Default: "+outputVarValue,
                        "1");

        logStep(nextStep(), "Tap on “V” button to add the action block");
        actionBlockDetailScreen()
                .clickAcceptButton();

        logStep(nextStep(), "In Action Block Page, verify the block name and action block description");
        logStep("Verify point: ", "Action Block should be added and the block name and description should show correctly");
        actionBlockScreen()
                .verifyActionBlockDisplayed("1", blockTitle, blockDesc);
    }
}
