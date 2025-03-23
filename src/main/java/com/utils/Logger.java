package com.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.utils.ReportManager.testThread;

public class Logger {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ExtentTest extentTest;

    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }

    private static String getCurrentTime() {
        return sdf.format(new Date());
    }

    public static void logInfo(String message) {
        String log = "[INFO] [" + getCurrentTime() + "] " + message;
        System.out.println(log);
        testThread.get().log(Status.INFO, message);
        if (extentTest != null) extentTest.info(message);
    }

    public static void logPassed(String message) {
        String log = "[PASS] [" + getCurrentTime() + "] " + message;
        System.out.println(log);
        testThread.get().log(Status.PASS, message);
        if (extentTest != null) extentTest.info(message);
    }

    public static void logError(String message) {
        String log = "[ERROR] [" + getCurrentTime() + "] " + message;
        System.err.println(log);
        if (extentTest != null) extentTest.fail(message);
        Assert.fail(message);
    }

    public static void logWarning(String message) {
        String log = "[WARNING] [" + getCurrentTime() + "] " + message;
        System.out.println(log);
        testThread.get().log(Status.INFO, message);
        if (extentTest != null) extentTest.warning(message);
    }
}
