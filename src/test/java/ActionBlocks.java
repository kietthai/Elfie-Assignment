import com.base.BaseTest;
import com.utils.Logger;
import org.testng.annotations.Test;

public class ActionBlocks extends BaseTest {

    @Test
    public void TC02() {
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
                .inputActionBlockTitle("TC02");

        logStep(nextStep(), "Add an action block description");
        actionBlockDetailScreen()
                .inputActionBlockDesc("TC02_Desc");

        logStep(nextStep(), "Tap on Add button");
        Logger.logWarning("Add button has been moved to Action Blocks screen");

        logStep(nextStep(), "On Action Block Detail Page, add an input variable name");
        logStep(nextStep(), "Add Boolean value and OK");
        actionBlockDetailScreen()
                .clickAddButton("Input Variable");

        dialogScreen()
                .createNewVariable("Input_Var_TC02", "Boolean");

        logStep(nextStep(), "Select newly added input variable");
        logStep(nextStep(), "Select the Value to True");
        actionBlockDetailScreen()
                .clickExpandCollapseButton("input")
                .editLocalVariable("Input_Var_TC02", "True");

        logStep(nextStep(), "On Action Blocks Detail Page, tap on Action to add an action");
        actionBlockDetailScreen()
                .clickAddButton("Action");

        logStep(nextStep(), "On Action page, tap on Logging");
        logStep(nextStep(), "Select Clear Log");
        addActionScreen()
                .chooseCategory("Logging")
                .chooseItem("Clear Log");

        logStep(nextStep(), "Select System Log and OK");
        dialogScreen()
                .selectOption("System Log");

        logStep(nextStep(), "On Action Block Detail Page, add an output variable name");
        logStep(nextStep(), "Add String value and OK");
        actionBlockDetailScreen()
                .clickAddButton("Output Variable");
        dialogScreen()
                .createNewVariable("Output_Var_TC02", "String");

        logStep(nextStep(), "Select newly added input variable");
        logStep(nextStep(), "Add String value = 'This is a testing string'");
        actionBlockDetailScreen()
                .clickExpandCollapseButton("output")
                .editLocalVariable("Output_Var_TC02", "This is a testing string");

        logStep(nextStep(), "Verify information display in Action Block detail page");
        logStep("Verify point: ", "The input variable, action, output variable should show correct information");
        actionBlockDetailScreen()
                .verifyEntryDisplayed("Input Variables",
                        "Input_Var_TC02",
                        "Default: True",
                        "1")
                .verifyEntryDisplayed("Actions",
                        "Clear Log",
                        "System Log",
                        "1")
                .verifyEntryDisplayed("Output Variables",
                        "Input_Var_TC02",
                        "Default: This is a testing string",
                        "1");


        logStep(nextStep(), "Tap on “V” button to add the action block");
        logStep(nextStep(), "In Action Block Page, verify the block name and action block description");
        logStep("Verify point: ", "Action Block should be added and the block name and description should show correctly");
    }
}
