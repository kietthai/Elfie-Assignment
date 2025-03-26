package page.mobile.Marco.AddTrigger;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class AddTriggerConstants {
    // Các locator cho màn hình triggers
    public static String CATEGORY_TEXT(String category) {
        String androidXpath =
                String.format(
                        "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/category_name' and @text='%s']"
                        , category);
        return formatXPathForPlatform(androidXpath);
    }

    public static String ITEM_TEXT(String item) {
        String androidXpath =
                String.format("//android.widget.TextView" +
                        "[@resource-id='com.arlosoft.macrodroid:id/select_item_name' and @text='%s']", item);
        return formatXPathForPlatform(androidXpath);
    }

}
