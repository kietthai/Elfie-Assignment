package page.mobile.ActionBlocks.ActionBlock;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class ActionBlockConstants {


    public static final String ADD_BUTTON =
            formatXPathForPlatform(
                    "//android.widget.ImageButton[@resource-id='com.arlosoft.macrodroid:id/fab']");

    public static String ACTION_BLOCK_NAME(String actionName, String index) {
        String androidXpath = String.format(
                "(//android.widget.LinearLayout[@resource-id='com.arlosoft.macrodroid:id/actionBlockContainer'])[%s]" +
                        "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/name' and @text='%s']"
                , index, actionName);
        return formatXPathForPlatform(androidXpath);
    }

    public static String ACTION_BLOCK_DESC(String actionDesc, String index) {
        String androidXpath = String.format(
                "(//android.widget.LinearLayout[@resource-id='com.arlosoft.macrodroid:id/actionBlockContainer'])[%s]" +
                        "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/description' and @text='%s']"
                , index, actionDesc);

        return formatXPathForPlatform(androidXpath);
    }
}
