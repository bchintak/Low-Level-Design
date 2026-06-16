package com.design_patterns.creational.factory;

import com.design_patterns.creational.Button;
import com.design_patterns.creational.Checkbox;
import com.design_patterns.creational.WindowsButton;
import com.design_patterns.creational.WindowsCheckbox;

public class WindowsFactory
        implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
