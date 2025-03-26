package page.mobile.Dialog;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class DialogConstants {
    // Các locator cho màn hình dashboard
    public static String OPTION_CTV(String option) {
        String androidXpath =
                String.format("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']", option);
        return formatXPathForPlatform(androidXpath);
    }

    public static final String NEW_VARIABLE_TXF = "com.arlosoft.macrodroid:id/variable_new_variable_dialog_name";
    public static final String VARIABLE_TYPE_SPINNER = "com.arlosoft.macrodroid:id/variable_new_variable_type_spinner";
    public static final String OK_BUTTON = "com.arlosoft.macrodroid:id/okButton";
    public static final String SYSTEM_OK_BUTTON = "android:id/button1";


}
