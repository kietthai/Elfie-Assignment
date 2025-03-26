package utils.logging;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager {
    private static ExtentReports extent;
    public static final ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    // Lưu timestamp để tạo folder riêng mỗi lần chạy
    private static final String TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    private static final String REPORT_FOLDER = "reports/" + TIMESTAMP + "/";

    public static void setupReport() {
        String reportPath = REPORT_FOLDER + "Report_" + TIMESTAMP + ".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static ExtentTest createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        testThread.set(test);
        return test;
    }

    public static ExtentTest getExtentTest() {
        return testThread.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static String getReportFolder() {
        return REPORT_FOLDER;
    }
}
