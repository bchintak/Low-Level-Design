package com.design_patterns.creational;

public class WindowsButton
        implements Button {

    @Override
    public void paint() {
        System.out.println(
                "Windows Button");
    }
}
