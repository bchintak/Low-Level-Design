package com.elevator.panel;

import com.elevator.model.ElevatorCar;

public class InternalPanel {

    private ElevatorCar elevator;

    public InternalPanel(
            ElevatorCar elevator) {

        this.elevator = elevator;
    }

    public void selectFloor(
            int floor) {

        elevator.addStop(floor);
    }
}
