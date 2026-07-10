package com.design_patterns.creational.abstract_factory;

public class MacButton
        implements Button {

    @Override
    public void paint() {
        System.out.println(
                "Mac Button");
    }
}
