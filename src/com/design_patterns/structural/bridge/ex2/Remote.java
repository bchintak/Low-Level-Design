package com.design_patterns.structural.bridge.ex2;

public abstract class Remote {

    protected TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    public abstract void power();

}
