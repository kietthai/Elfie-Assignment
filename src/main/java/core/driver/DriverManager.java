package core.driver;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> mobileDriver = new ThreadLocal<>();

    public static void initDriver(String type) {
        switch (type.toLowerCase()) {
            case "web":
                webDriver.set(WebDriverManager.createWebDriver());
                break;
            case "mobile":
                mobileDriver.set(MobileDriverManager.createMobileDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static AppiumDriver getMobileDriver() {
        return mobileDriver.get();
    }

    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
        if (mobileDriver.get() != null) {
            mobileDriver.get().quit();
            mobileDriver.remove();
        }
    }
}
