package com.fooddelivery.repository;

import com.fooddelivery.model.Restaurant;

import java.util.*;

public class RestaurantRepository {

    private final Map<String, Restaurant>
            restaurantMap = new HashMap<>();

    public void addRestaurant(
            Restaurant restaurant) {

        restaurantMap.put(
                restaurant.getId(),
                restaurant
        );
    }

    public Restaurant getRestaurant(
            String restaurantId) {

        return restaurantMap.get(
                restaurantId
        );
    }

    public List<Restaurant> getAllRestaurants() {

        return new ArrayList<>(
                restaurantMap.values()
        );
    }

    public List<Restaurant> searchByName(
            String keyword) {

        return restaurantMap
                .values()
                .stream()
                .filter(
                        restaurant ->
                                restaurant.getName()
                                        .toLowerCase()
                                        .contains(
                                                keyword.toLowerCase()
                                        )
                )
                .toList();
    }
}