package com.design_patterns.creational.abstract_factory;

public class MacCheckbox
        implements Checkbox {

    @Override
    public void paint() {
        System.out.println(
                "Mac Checkbox");
    }
}
