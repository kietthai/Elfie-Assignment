package com.drivers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static JsonNode config;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readTree(new File("src/main/resources/config.json"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.json", e);
        }
    }

    public static void initDriver(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String appiumServer = config.get("appiumServer").asText(); // Đọc URL từ JSON

        if ("android".equalsIgnoreCase(platform)) {
            JsonNode androidConfig = config.get("android");
            capabilities.setCapability("platformName", androidConfig.get("platformName").asText());
            capabilities.setCapability("deviceName", androidConfig.get("deviceName").asText());
            capabilities.setCapability("app", new File(androidConfig.get("app").asText()).getAbsolutePath());
//            capabilities.setCapability("appPackage", androidConfig.get("appPackage").asText());
//            capabilities.setCapability("appActivity", androidConfig.get("appActivity").asText());
            capabilities.setCapability("automationName", androidConfig.get("automationName").asText());

            driver.set(new AndroidDriver(new URL(appiumServer), capabilities));
            System.out.print(androidConfig);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
