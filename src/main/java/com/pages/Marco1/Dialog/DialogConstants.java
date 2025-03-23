package com.pages.Marco1.Dialog;

public class DialogConstants {
    // Các locator cho màn hình dashboard
    public static String OPTION_CTV(String option) {
        return String.format("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']", option);
    }

    public static final String OK_BUTTON = "android:id/button1";

}
