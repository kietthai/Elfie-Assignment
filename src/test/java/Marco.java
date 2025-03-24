import com.base.BaseTest;
import org.testng.annotations.Test;

public class Marco extends BaseTest {

    @Test
    public void TC01() {
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
                .selectOption("Application Removed")
                .selectOption("Any Application");

        logStep("Verify point: ", "The Trigger Macro should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Triggers",
                        "Application Removed",
                        "Any Application",
                        "1");

        logStep(nextStep(), "On Macro Page, tap on Action to add an action");
        marcoScreen()
                .clickAddButton("Add Action");

        logStep(nextStep(), "On Action page, tap on Logging");
        logStep(nextStep(), "Select Clear Log");
        addActionScreen()
                .chooseCategory("Logging")
                .chooseItem("Clear Log");

        logStep(nextStep(), "Select System Log and OK");
        dialogScreen()
                .selectOption("System Log");

        logStep("Verify point: ", "The Action Macro should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Actions",
                        "Clear Log",
                        "System Log",
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
                .selectOption("Airplane Mode Disabled");

        logStep("Verify point: ", "The Constraints should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Constraints",
                        "Airplane Mode Disabled",
                        "",
                        "1");

        logStep(nextStep(), "On Macro Page, select add Local Variable");
        marcoScreen()
                .clickAddButton("Add Local Variable");

        logStep(nextStep(), "Add an Integer Variable with Name 'Test Case'");
        dialogScreen()
                .createNewVariable("Test Case", "Integer");

        logStep(nextStep(), "Select new added Variable, and input Value 1");
        marcoScreen()
                .editLocalVariable("Test Case", "1");
        logStep("Verify point: ", "The Local Variable should show correct added values");
        marcoScreen()
                .verifyEntryDisplayed("Local Variables",
                        "Test Case",
                        "1",
                        "1");

    }
}
