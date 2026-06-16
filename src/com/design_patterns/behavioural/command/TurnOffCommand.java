package com.design_patterns.behavioural.command;

public class TurnOffCommand implements Command {

    private final TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
