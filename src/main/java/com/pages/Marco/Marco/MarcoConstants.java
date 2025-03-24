package com.pages.Marco.Marco;

public class MarcoConstants {
    // Các locator cho màn hình dashboard
    public static String ADD_BUTTON(String type) {
        return String.format("//android.widget.ImageButton[@content-desc='%s']", type);
    }

    public static String MACRO_ENTRY_NAME(String macroName, String entryName, String index) {
        return String.format("(//android.widget.LinearLayout[android.widget.TextView[@text='%s']]" +
                "//following-sibling::androidx.recyclerview.widget.RecyclerView" +
                "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/macro_edit_entry_name'" +
                        "and @text='%s'])[%s]",
                macroName, entryName, index);
    }

    public static String MACRO_ENTRY_DETAIL(String macroName, String entryDetail, String index) {
        return String.format("(//android.widget.LinearLayout[android.widget.TextView[@text='%s']]" +
                        "//following-sibling::androidx.recyclerview.widget.RecyclerView" +
                        "//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/macro_edit_entry_detail'" +
                        "and @text='%s'])[%s]",
                macroName, entryDetail, index);
    }

    public static final String ADD_LOCAL_VAR_BUTTON = "//android.widget.ImageButton" +
            "[@resource-id='com.arlosoft.macrodroid:id/addVariableButton']";

    public static String LOCAL_VAR_NAME_TXT(String varName) {
        return String.format("//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/macro_edit_entry_name'" +
                " and @text='%s']", varName);
    }
    public static final String VAR_VALUE_TXF = "com.arlosoft.macrodroid:id/enter_variable_dialog_value";
    public static final String ADD_LOCAL_VAR_LABEL = "com.arlosoft.macrodroid:id/localVarsLabel";
}
