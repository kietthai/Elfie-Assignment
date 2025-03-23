package com.pages.Marco1.AddLocalVariable;

public class AddLocalVariableConstants {
    public static final String VARIABLE_TYPE_SPINNER = "com.arlosoft.macrodroid:id/variable_new_variable_type_spinner";
    public static String VARIABLE_TYPE_CTV(String item) {
        return String.format("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']", item);
    }
    public static final String VARIABLE_NAME_TXF = "com.arlosoft.macrodroid:id/variable_new_variable_dialog_name";
    public static final String OK_BUTTON = "com.arlosoft.macrodroid:id/okButton";


}
