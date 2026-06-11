package com.library.observer;

import java.util.ArrayList;
import java.util.List;

public class ReservationNotifier {

    private List<Observer> observers =
            new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void notifyUsers(String msg) {

        for(Observer o : observers) {
            o.update(msg);
        }
    }
}
