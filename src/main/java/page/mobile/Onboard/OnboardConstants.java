package page.mobile.Onboard;

import org.openqa.selenium.By;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class OnboardConstants {
    // Các locator cho màn hình onboard
    public static final String SKIP_BUTTON = "com.arlosoft.macrodroid:id/button_skip";
    public static final String BACK_BUTTON = formatXPathForPlatform("//android.widget.ImageButton[@content-desc='Navigate up']");

}
