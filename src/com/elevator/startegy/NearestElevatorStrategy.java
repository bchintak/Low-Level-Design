package com.elevator.startegy;

import com.elevator.model.ElevatorCar;
import com.elevator.model.Request;

import java.util.List;

public class NearestElevatorStrategy
        implements SchedulingStrategy {

    @Override
    public ElevatorCar selectElevator(
            Request request,
            List<ElevatorCar> elevators) {

        ElevatorCar best = null;

        int minDistance = Integer.MAX_VALUE;

        for(ElevatorCar elevator : elevators) {

            int distance =
                    Math.abs(
                            elevator.getCurrentFloor()
                                    - request.getSourceFloor());

            if(distance < minDistance) {

                minDistance = distance;
                best = elevator;
            }
        }

        return best;
    }
}
