import com.base.BaseTest;
import com.google.gson.JsonObject;
import com.utils.TestDataManager;
import org.testng.annotations.Test;

public class Marco extends BaseTest {

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = TestDataManager.class)
    public void Marco_TC01(JsonObject testData) {
        String triggerName = testData.get("triggerName").getAsString();
        String triggerDetail = testData.get("triggerDetail").getAsString();
        String actionName = testData.get("actionName").getAsString();
        String actionDetail = testData.get("actionDetail").getAsString();
        String constraintsName = testData.get("constraintsName").getAsString();
        String varName = testData.get("varName").getAsString();
        String varDetail = testData.get("varDetail").getAsString();

        logStep(startStep(), "Open application");
        onboardScreen()
                .clickOnSkipButton()
                .clickOnBackButton();

        logStep(nextStep(), "On Dashboard Page, tap on click Macro");
        dashboardScreen()
                .clickItemOnMenu("Add Macro");

        logStep(nextStep(), "On Macro Page, tap on Trigger to add a trigger");
        marcoScreen()
                .clickAddButton("Add Trigger");

        logStep(nextStep(), "On Trigger Page, tap on Application");
        logStep(nextStep(), "Tap on App Install/Remove/Update");
        addTriggerScreen()
                .chooseCategory("Applications")
                .chooseItem("App Install/Remove/Update");

        logStep(nextStep(), "Select Application Removed radio button");
        logStep(nextStep(), "Select Any Application and OK");
        dialogScreen()
                .selectOption(triggerName)
                .selectOption(triggerDetail);

        logStep("Verify point: ", "The Trigger Macro should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Triggers",
                        triggerName,
                        triggerDetail,
                        "1");

        logStep(nextStep(), "On Macro Page, tap on Action to add an action");
        marcoScreen()
                .clickAddButton("Add Action");

        logStep(nextStep(), "On Action page, tap on Logging");
        logStep(nextStep(), "Select Clear Log");
        addActionScreen()
                .chooseCategory("Logging")
                .chooseItem(actionName);

        logStep(nextStep(), "Select System Log and OK");
        dialogScreen()
                .selectOption(actionDetail);

        logStep("Verify point: ", "The Action Macro should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Actions",
                        actionName,
                        actionDetail,
                        "1");

        logStep(nextStep(), "On Macro Page, tap on Constrains to add a constraint");
        marcoScreen()
                .clickAddButton("Add constraint");

        logStep(nextStep(), "Select Device State");
        logStep(nextStep(), "Select Airplane Mode");
        addConstraintScreen()
                .chooseCategory("Device State")
                .chooseItem("Airplane Mode");

        logStep(nextStep(), "Select Airplane Mode Disable and OK");
        dialogScreen()
                .selectOption(constraintsName);

        logStep("Verify point: ", "The Constraints should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Constraints",
                        constraintsName,
                        "",
                        "1");

        logStep(nextStep(), "On Macro Page, select add Local Variable");
        marcoScreen()
                .clickAddButton("Add Local Variable");

        logStep(nextStep(), "Add an Integer Variable with Name 'Test Case'");
        dialogScreen()
                .createNewVariable(varName, "Integer");

        logStep(nextStep(), "Select new added Variable, and input Value 1");
        marcoScreen()
                .editLocalVariable(varName, varDetail);
        logStep("Verify point: ", "The Local Variable should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Local Variables",
                        varName,
                        varDetail,
                        "1");

    }
}
