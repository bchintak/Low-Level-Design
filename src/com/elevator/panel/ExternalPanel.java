package com.elevator.panel;

import com.elevator.controller.ElevatorDispatcher;
import com.elevator.model.Direction;
import com.elevator.model.Request;

public class ExternalPanel {

    private ElevatorDispatcher dispatcher;

    public ExternalPanel(
            ElevatorDispatcher dispatcher) {

        this.dispatcher = dispatcher;
    }

    public void pressButton(
            int sourceFloor,
            Direction direction,
            int destinationFloor) {

        Request request =
                new Request(
                        sourceFloor,
                        destinationFloor,
                        direction);

        dispatcher.submitRequest(request);
    }
}
