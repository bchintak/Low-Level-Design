package com.elevator;

import com.elevator.controller.ElevatorDispatcher;
import com.elevator.model.Direction;
import com.elevator.model.ElevatorCar;
import com.elevator.panel.ExternalPanel;
import com.elevator.startegy.NearestElevatorStrategy;
import com.elevator.startegy.SchedulingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<ElevatorCar> elevators =
                new ArrayList<>();

        elevators.add(
                new ElevatorCar(1));

        elevators.add(
                new ElevatorCar(2));

        SchedulingStrategy strategy =
                new NearestElevatorStrategy();

        ElevatorDispatcher dispatcher =
                new ElevatorDispatcher(
                        strategy,
                        elevators);

        ExternalPanel panel =
                new ExternalPanel(dispatcher);

        panel.pressButton(
                2,
                Direction.UP,
                8);

        panel.pressButton(
                1,
                Direction.UP,
                6);
    }
}
