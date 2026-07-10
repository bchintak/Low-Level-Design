package com.design_patterns.structural.bridge.ex2;

public class BasicRemote extends Remote {

    public BasicRemote(TV tv) {
        super(tv);
    }

    @Override
    public void power() {
        tv.on();
    }

}