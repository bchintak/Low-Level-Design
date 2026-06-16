package com.design_patterns.creational;

import com.design_patterns.creational.Application;
import com.design_patterns.creational.factory.GUIFactory;
import com.design_patterns.creational.factory.WindowsFactory;

public class Main {

    public static void main(String[] args) {

        GUIFactory factory =
                new WindowsFactory();

        Application app =
                new Application(factory);

        app.render();
    }
}