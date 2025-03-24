package com.pages.Dialog;

public class DialogConstants {
    // Các locator cho màn hình dashboard
    public static String OPTION_CTV(String option) {
        return String.format("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']", option);
    }

    public static final String NEW_VARIABLE_TXF = "com.arlosoft.macrodroid:id/variable_new_variable_dialog_name";
    public static final String VARIABLE_TYPE_SPINNER = "com.arlosoft.macrodroid:id/variable_new_variable_type_spinner";
    public static String VARIABLE_TYPE_CTV(String item) {
        return String.format("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']", item);
    }
    public static final String VARIABLE_NAME_TXF = "com.arlosoft.macrodroid:id/variable_new_variable_dialog_name";
    public static final String OK_BUTTON = "com.arlosoft.macrodroid:id/okButton";
    public static final String SYSTEM_OK_BUTTON = "android:id/button1";


}
