package com.design_patterns.behavioural.command;

public class Main {

    public static void main(String[] args) {

        TV tv = new TV();

        Command onCommand =
                new TurnOnCommand(tv);

        Command offCommand =
                new TurnOffCommand(tv);

        RemoteControl remote =
                new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}
