package page.mobile.Marco.Marco;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class MarcoConstants {
    // Các locator cho màn hình dashboard
    public static String ADD_BUTTON(String type) {
        String androidXpath = String.format("//android.widget.ImageButton[@content-desc='%s']", type);
        return formatXPathForPlatform(androidXpath);
    }

    public static final String ADD_LOCAL_VAR_BUTTON = formatXPathForPlatform("//android.widget.ImageButton" +
            "[@resource-id='com.arlosoft.macrodroid:id/addVariableButton']");

    public static final String ADD_LOCAL_VAR_LABEL = "com.arlosoft.macrodroid:id/localVarsLabel";
}
