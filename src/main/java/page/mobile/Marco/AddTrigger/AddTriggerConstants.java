package page.mobile.Marco.AddTrigger;

public class AddTriggerConstants {
    // Các locator cho màn hình triggers
    public static String CATEGORY_TEXT(String category) {
        return String.format("//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/category_name' and @text='%s']", category);
    }

    public static String ITEM_TEXT(String item) {
        return String.format("//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/select_item_name' and @text='%s']", item);
    }

}
