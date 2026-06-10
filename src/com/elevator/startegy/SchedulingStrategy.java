package com.elevator.startegy;

import com.elevator.model.ElevatorCar;
import com.elevator.model.Request;

import java.util.List;

public interface SchedulingStrategy {

    ElevatorCar selectElevator(
            Request request,
            List<ElevatorCar> elevators);
}
