package page.mobile.ActionBlocks.ActionBlockDetail;

public class ActionBlockDetailConstants {

    public static final String ACTION_BLOCK_TITLE_TXF = "com.arlosoft.macrodroid:id/actionBlockNameText";
    public static final String ACTION_BLOCK_DESC_TXF = "com.arlosoft.macrodroid:id/description";

    public static String ACTION_BLOCK_ADD_BTN(String btnName) {
        return String.format("com.arlosoft.macrodroid:id/add%sButton", btnName);
    }

    public static String COLLAPSE_EXPAND_BTN(String inOutVariable) {
        return String.format("com.arlosoft.macrodroid:id/%sCollapseExpandButton", inOutVariable);
    }

    public static final String ACCEPT_BTN = "com.arlosoft.macrodroid:id/acceptButton";

}
