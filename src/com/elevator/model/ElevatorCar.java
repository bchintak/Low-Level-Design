package com.elevator.model;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorCar {

    private int id;

    private int currentFloor;

    private Direction direction;

    private ElevatorState state;

    private PriorityQueue<Integer> upStops;

    private PriorityQueue<Integer> downStops;

    public ElevatorCar(int id) {

        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;

        this.upStops =
                new PriorityQueue<>();

        this.downStops =
                new PriorityQueue<>(Collections.reverseOrder());
    }

    public synchronized void addStop(int floor) {

        if (floor > currentFloor) {
            upStops.offer(floor);
        } else {
            downStops.offer(floor);
        }
    }

    public synchronized void move() {

        if(direction == Direction.UP) {

            while(!upStops.isEmpty()) {

                int floor = upStops.poll();

                currentFloor = floor;

                System.out.println(
                        "Elevator " + id +
                                " reached floor " + floor);
            }
        }

        if(direction == Direction.DOWN) {

            while(!downStops.isEmpty()) {

                int floor = downStops.poll();

                currentFloor = floor;

                System.out.println(
                        "Elevator " + id +
                                " reached floor " + floor);
            }
        }

        state = ElevatorState.IDLE;
        direction = Direction.IDLE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }
}
