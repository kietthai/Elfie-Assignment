package page.mobile.Dashboard;

public class DashboardConstants {
    // Các locator cho màn hình dashboard
    public static String MENU_ITEM(String item) {
        return String.format("//android.view.ViewGroup//android.widget.TextView[@resource-id='com.arlosoft.macrodroid:id/title' and @text='%s']", item);
    }
}
