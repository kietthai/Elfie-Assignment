package core.driver;

import config.ConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverManager {
    public static AppiumDriver createMobileDriver() {
        JsonNode mobileConfig = ConfigReader.getMobileConfig();
        String platform = mobileConfig.get("platform").asText();
        AppiumDriverManager.startAppiumService();
        return platform.equalsIgnoreCase("android") ? createAndroidDriver() : createIOSDriver();
    }

    private static AppiumDriver createAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        JsonNode androidConfig = ConfigReader.getMobileConfig().get("android");

        capabilities.setCapability("platformName", androidConfig.get("platformName").asText());
        capabilities.setCapability("appium:deviceName", androidConfig.get("deviceName").asText());
        capabilities.setCapability("appium:app", new File(androidConfig.get("app").asText()).getAbsolutePath());
        capabilities.setCapability("appium:automationName", androidConfig.get("automationName").asText());
        capabilities.setCapability("appium:disableWindowAnimation", true);
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static AppiumDriver createIOSDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        JsonNode iosConfig = ConfigReader.getMobileConfig().get("ios");

        capabilities.setCapability("appium:platformName", iosConfig.get("platformName").asText());
        capabilities.setCapability("appium:deviceName", iosConfig.get("deviceName").asText());
        capabilities.setCapability("appium:app", new File(iosConfig.get("app").asText()).getAbsolutePath());
        capabilities.setCapability("appium:automationName", iosConfig.get("automationName").asText());

        try {
            return new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
