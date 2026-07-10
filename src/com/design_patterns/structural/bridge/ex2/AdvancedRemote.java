package com.design_patterns.structural.bridge.ex2;

public class AdvancedRemote extends Remote {

    public AdvancedRemote(TV tv) {
        super(tv);
    }

    @Override
    public void power() {
        tv.on();
    }

    public void setChannel(int channel) {
        tv.setChannel(channel);
    }

}