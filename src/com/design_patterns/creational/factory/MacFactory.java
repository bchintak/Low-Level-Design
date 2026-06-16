package com.design_patterns.creational.factory;

import com.design_patterns.creational.Button;
import com.design_patterns.creational.Checkbox;
import com.design_patterns.creational.MacButton;
import com.design_patterns.creational.MacCheckbox;

public class MacFactory
        implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
