package page.mobile.Dashboard;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class DashboardConstants {
    // Các locator cho màn hình dashboard
    public static String MENU_ITEM(String item) {
        String androidXpath =
                String.format("//android.view.ViewGroup//android.widget.TextView" +
                        "[@resource-id='com.arlosoft.macrodroid:id/title' and @text='%s']", item);
        return formatXPathForPlatform(androidXpath);
    }
}
