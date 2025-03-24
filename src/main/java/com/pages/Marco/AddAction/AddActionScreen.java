package com.pages.Marco.AddAction;

import com.pages.Marco.AddTrigger.AddTriggerScreen;

public class AddActionScreen extends AddTriggerScreen {
    public AddActionScreen chooseCategory(String category) {
        super.chooseCategory(category);
        return this;
    }

    public AddActionScreen chooseItem(String item) {
        super.chooseItem(item);
        return this;
    }

}
