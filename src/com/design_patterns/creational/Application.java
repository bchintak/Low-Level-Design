package com.design_patterns.creational;

import com.design_patterns.creational.factory.GUIFactory;

public class Application {

    private Button button;

    private Checkbox checkbox;

    public Application(
            GUIFactory factory) {

        this.button =
                factory.createButton();

        this.checkbox =
                factory.createCheckbox();
    }

    public void render() {

        button.paint();

        checkbox.paint();
    }
}