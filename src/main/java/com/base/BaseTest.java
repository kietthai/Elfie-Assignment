package com.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.drivers.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pages.ActionBlocks.ActionBlock.ActionBlockScreen;
import com.pages.ActionBlocks.ActionBlockDetail.ActionBlockDetailScreen;
import com.pages.BaseScreen.BaseScreen;
import com.pages.Marco.AddAction.AddActionScreen;
import com.pages.Marco.AddConstraint.AddConstraintScreen;
import com.pages.Marco.AddTrigger.AddTriggerScreen;
import com.pages.Dashboard.DashboardScreen;
import com.pages.Dialog.DialogScreen;
import com.pages.Marco.Marco.MarcoScreen;
import com.pages.Onboard.OnboardScreen;
import com.utils.Logger;
import com.utils.ReportManager;
import com.utils.ScreenshotUtils;
import com.utils.TestDataManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.utils.ReportManager.testThread;


public class BaseTest {
    protected static ExtentReports extent;
    protected int stepCounter = 0; // Biến đếm số bước
    protected int countTestData = 0;
    protected JsonObject testData;

    // Execution Hook
    @BeforeSuite
    public void beforeSuite() {
        ReportManager.setupReport();  // Khởi tạo ExtentReports
    }

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(@Optional("android") String platform, Method method, Object[] testDataParams){
        String testName = method.getName();
        countTestData++;
        // Lấy test data từ tham số truyền vào
        if (testDataParams.length > 0 && testDataParams[0] instanceof JsonObject) {
            testData = (JsonObject) testDataParams[0];
        }

        String formattedData = formatTestData(testData);
        ReportManager.createTest(testName + " - Iterator: [" + countTestData + "]");
        Logger.logInfo("Test Data: <br>" + formattedData.replace("\n", "<br>"));
        Logger.logInfo("Running test on: " + platform);
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(DriverManager.getDriver(), result.getName());
            ExtentTest test = ReportManager.getExtentTest();
            test.fail("Test Failed: " + result.getThrowable().getMessage()  + "\n\n"
                    , (MediaEntityBuilder.createScreenCaptureFromPath(new File(screenshotPath).getName())).build());
        }
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void tearDownReport() {
        ReportManager.flushReport();
    }

    private String formatTestData(JsonObject testData) {
        StringBuilder sb = new StringBuilder();
        sb.append("<details>");
        sb.append("<summary><b>Expand Data</b></summary>");
        sb.append("<table border='1' style='border-collapse: collapse; margin-top: 5px;'>");
        sb.append("<tr><th>Key</th><th>Value</th></tr>");

        for (Map.Entry<String, JsonElement> entry : testData.entrySet()) {
            sb.append("<tr>")
                    .append("<td>").append(entry.getKey()).append("</td>")
                    .append("<td>").append(entry.getValue().getAsString()).append("</td>")
                    .append("</tr>");
        }

        sb.append("</table>");
        sb.append("</details>");
        return sb.toString();
    }

    // Handle log Step to extend report
    protected String startStep() {
        stepCounter = 1; // Reset lại số bước khi bắt đầu testcase mới
        return "Step " + stepCounter + ": ";
    }

    protected String nextStep() {
        stepCounter++; // Tăng số bước lên
        return "Step " + stepCounter + ": ";
    }

    protected void logStep(String step, String stepName) {
        String formattedStep = "<span style='color:green; font-weight:bold;'>---" + step + stepName +"---</span>";
        testThread.get().log(Status.INFO, formattedStep);
        System.out.println(step + stepName);  // In ra console để debug
    }

    // init Screen
    protected OnboardScreen onboardScreen;
    protected DashboardScreen dashboardScreen;
    protected MarcoScreen marcoScreen;
    protected AddTriggerScreen addTriggerScreen;
    protected AddActionScreen addActionScreen;
    protected AddConstraintScreen addConstraintScreen;
    protected DialogScreen dialogScreen;
    protected ActionBlockScreen actionBlockScreen;
    protected ActionBlockDetailScreen actionBlockDetailScreen;
    protected BaseScreen baseScreen;

    protected BaseScreen baseScreen() {
        if (baseScreen == null) {
            baseScreen = new BaseScreen();
        }
        return baseScreen;
    }
    protected OnboardScreen onboardScreen() {
        if (onboardScreen == null) {
            onboardScreen = new OnboardScreen();
        }
        return onboardScreen;
    }
    protected DashboardScreen dashboardScreen() {
        if (dashboardScreen == null) {
            dashboardScreen = new DashboardScreen();
        }
        return dashboardScreen;
    }
    protected MarcoScreen marcoScreen() {
        if (marcoScreen == null) {
            marcoScreen = new MarcoScreen();
        }
        return marcoScreen;
    }
    protected AddTriggerScreen addTriggerScreen() {
        if (addTriggerScreen == null) {
            addTriggerScreen = new AddTriggerScreen();
        }
        return addTriggerScreen;
    }
    protected DialogScreen dialogScreen() {
        if (dialogScreen == null) {
            dialogScreen = new DialogScreen();
        }
        return dialogScreen;
    }
    protected AddActionScreen addActionScreen() {
        if (addActionScreen == null) {
            addActionScreen = new AddActionScreen();
        }
        return addActionScreen;
    }
    protected AddConstraintScreen addConstraintScreen() {
        if (addConstraintScreen == null) {
            addConstraintScreen = new AddConstraintScreen();
        }
        return addConstraintScreen;
    }
    protected ActionBlockScreen actionBlockScreen() {
        if (actionBlockScreen == null) {
            actionBlockScreen = new ActionBlockScreen();
        }
        return actionBlockScreen;
    }
    protected ActionBlockDetailScreen actionBlockDetailScreen() {
        if (actionBlockDetailScreen == null) {
            actionBlockDetailScreen = new ActionBlockDetailScreen();
        }
        return actionBlockDetailScreen;
    }


}
