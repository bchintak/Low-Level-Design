package com.elevator.controller;

import com.elevator.model.ElevatorCar;
import com.elevator.model.Request;
import com.elevator.startegy.SchedulingStrategy;

import java.util.List;

public class ElevatorDispatcher {

    private SchedulingStrategy strategy;

    private List<ElevatorCar> elevators;

    public ElevatorDispatcher(
            SchedulingStrategy strategy,
            List<ElevatorCar> elevators) {

        this.strategy = strategy;
        this.elevators = elevators;
    }

    public void submitRequest(
            Request request) {

        ElevatorCar elevator =
                strategy.selectElevator(
                        request,
                        elevators);

        elevator.addStop(
                request.getSourceFloor());

        elevator.addStop(
                request.getDestinationFloor());

        elevator.setDirection(
                request.getDirection());

        elevator.move();
    }
}
