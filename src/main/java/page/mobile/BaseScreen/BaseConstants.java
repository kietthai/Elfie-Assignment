package page.mobile.BaseScreen;

import static utils.xpath.XPathUtils.formatXPathForPlatform;

public class BaseConstants {
    public static final String VAR_VALUE_TXF = "com.arlosoft.macrodroid:id/enter_variable_dialog_value";
    public static final String ADD_LOCAL_VAR_LABEL = "com.arlosoft.macrodroid:id/localVarsLabel";

    public static String VAR_VALUE_RDB(String varName) {
        return String.format("com.arlosoft.macrodroid:id/%sRadio", varName);
    }

    public static String LOCAL_VAR_NAME_TXT(String varName) {
        String androidXpath = String.format("//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/macro_edit_entry_name'" +
                " and @text='%s']", varName);

        return formatXPathForPlatform(androidXpath);
    }

    public static String ENTRY_NAME(String macroName, String entryName, String index) {
        String androidXpath = String.format("(//android.widget.LinearLayout[android.widget.LinearLayout[" +
                        "android.widget.TextView[contains(@text,'%s')]]]" +
                        "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/macro_edit_entry_name' " +
                        "and @text='%s'])[%s]",
                macroName, entryName, index);
        return formatXPathForPlatform(androidXpath);
    }

    public static String ENTRY_DETAIL(String macroName, String entryDetail, String index) {
        String androidXpath = String.format("(//android.widget.LinearLayout[android.widget.LinearLayout[" +
                        "android.widget.TextView[contains(@text,'%s')]]]" +
                        "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/macro_edit_entry_detail' " +
                        "and @text='%s'])[%s]",
                macroName, entryDetail, index);
        return formatXPathForPlatform(androidXpath);

    }

}
