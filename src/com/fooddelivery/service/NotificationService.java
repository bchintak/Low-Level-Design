package com.fooddelivery.service;

import com.fooddelivery.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<Observer>
            observers = new ArrayList<>();

    public void addObserver(
            Observer observer) {

        observers.add(observer);
    }

    public void notifyObservers(
            String message) {

        observers.forEach(
                observer ->
                        observer.update(message)
        );
    }
}