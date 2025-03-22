package com.utils;

import com.base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtils {
    public static String captureScreenshot(WebDriver driver, String testName) {
        String screenshotPath = ReportManager.getReportFolder() + testName + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            Files.copy(screenshot.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
