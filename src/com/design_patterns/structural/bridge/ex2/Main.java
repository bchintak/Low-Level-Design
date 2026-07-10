package com.design_patterns.structural.bridge.ex2;

public class Main {

    public static void main(String[] args) {

        TV sony = new SonyTV();

        Remote remote = new AdvancedRemote(sony);

        remote.power();

        ((AdvancedRemote) remote).setChannel(10);

    }

}
