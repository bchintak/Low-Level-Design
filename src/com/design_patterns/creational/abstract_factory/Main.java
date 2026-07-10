package com.design_patterns.creational.abstract_factory;

public class Main {

    public static void main(String[] args) {

        GUIFactory factory =
                new WindowsFactory();

        Application app =
                new Application(factory);

        app.render();
    }
}