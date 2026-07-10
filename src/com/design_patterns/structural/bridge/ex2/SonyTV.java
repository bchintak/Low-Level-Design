package com.design_patterns.structural.bridge.ex2;

public class SonyTV implements TV {

    @Override
    public void on() {
        System.out.println("Sony TV ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sony Channel : " + channel);
    }

}