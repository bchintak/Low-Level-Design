package com.design_patterns.structural.bridge.ex2;

public class SamsungTV implements TV {

    @Override
    public void on() {
        System.out.println("Samsung TV ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV OFF");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Samsung Channel : " + channel);
    }

}