package com.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.drivers.DriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.Marco1.AddAction.AddActionScreen;
import com.pages.Marco1.AddConstraint.AddConstraintScreen;
import com.pages.Marco1.AddLocalVariable.AddLocalVariableScreen;
import com.pages.Marco1.AddTrigger.AddTriggerScreen;
import com.pages.Dashboard.DashboardScreen;
import com.pages.Marco1.Dialog.DialogScreen;
import com.pages.Marco1.Marco.MarcoScreen;
import com.pages.Onboard.OnboardScreen;
import com.utils.Logger;
import com.utils.ReportManager;
import com.utils.ScreenshotUtils;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;

import static com.utils.ReportManager.testThread;


public class BaseTest {
    protected static ExtentReports extent;
    private static String reportFolderPath;
    protected int stepCounter = 0; // Biến đếm số bước

    // Execution Hook
    @BeforeSuite
    public void beforeSuite() {
        ReportManager.setupReport();  // Khởi tạo ExtentReports
    }

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(@Optional("android") String platform, ITestResult result) throws MalformedURLException {
        String testName = result.getMethod().getMethodName(); // Lấy tên test method
        ReportManager.createTest(testName);
        Logger.logInfo("Running test on: " + platform);
        DriverManager.initDriver(platform);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(DriverManager.getDriver(), result.getName());
            ExtentTest test = ReportManager.getExtentTest();
            test.fail("Test Failed: " + result.getThrowable().getMessage()  + "\n\n"
                    , (MediaEntityBuilder.createScreenCaptureFromPath(new File(screenshotPath).getName())).build());
        }
    }

    @AfterSuite
    public void tearDownReport() {
        ReportManager.flushReport();
    }

    public static String getReportFolderPath() {
        return reportFolderPath;
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
    protected AddLocalVariableScreen addLocalVariableScreen;
    protected DialogScreen dialogScreen;



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

    protected AddLocalVariableScreen addLocalVariableScreen() {
        if (addLocalVariableScreen == null) {
            addLocalVariableScreen = new AddLocalVariableScreen();
        }
        return addLocalVariableScreen;
    }


}
