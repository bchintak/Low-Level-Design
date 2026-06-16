package com.design_patterns.creational.factory;

import com.design_patterns.creational.Button;
import com.design_patterns.creational.Checkbox;

public interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
