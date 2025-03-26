package utils.xpath;

import config.ConfigLoader;

public class XPathUtils {
    public static String formatXPathForPlatform(String androidXPath) {
        String platform = ConfigLoader.getPlatform();
        if ("ios".equalsIgnoreCase(platform)) {
            return androidXPath
                    .replace("android.widget.TextView", "XCUIElementTypeStaticText")
                    .replace("android.widget.EditText", "XCUIElementTypeTextField")
                    .replace("android.widget.Button", "XCUIElementTypeButton")
                    .replace("android.widget.CheckBox", "XCUIElementTypeSwitch")
                    .replace("android.widget.ImageView", "XCUIElementTypeImage")
                    .replace("android.widget.ListView", "XCUIElementTypeTable")
                    .replace("android.widget.ScrollView", "XCUIElementTypeScrollView")
                    .replace("@resource-id", "@name")
                    .replace("@text", "@label");
        }
        return androidXPath;
    }
}

