package com.fooddelivery;

import com.fooddelivery.enums.PaymentType;
import com.fooddelivery.model.*;
import com.fooddelivery.observer.CustomerNotification;
import com.fooddelivery.observer.DeliveryPartnerNotification;
import com.fooddelivery.observer.RestaurantNotification;
import com.fooddelivery.repository.DeliveryPartnerRepository;
import com.fooddelivery.repository.OrderRepository;
import com.fooddelivery.repository.RestaurantRepository;
import com.fooddelivery.service.*;
import com.fooddelivery.strategy.NearestPartnerStrategy;

public class Main {

    public static void main(String[] args) {

        /*
         * Repositories
         */
        RestaurantRepository restaurantRepository =
                new RestaurantRepository();

        OrderRepository orderRepository =
                new OrderRepository();

        DeliveryPartnerRepository partnerRepository =
                new DeliveryPartnerRepository();

        /*
         * Services
         */
        CartService cartService =
                new CartService();

        PaymentService paymentService =
                new PaymentService();

        OrderService orderService =
                new OrderService(
                        paymentService,
                        orderRepository
                );

        DeliveryService deliveryService =
                new DeliveryService(
                        partnerRepository,
                        new NearestPartnerStrategy()
                );

        /*
         * Customer
         */
        Customer bhanu =
                new Customer(
                        "C1",
                        "Bhanu",
                        "9999999999"
                );

        /*
         * Address
         */
        Address address =
                new Address(
                        "Hyderabad",
                        "Madhapur"
                );

        /*
         * Restaurant
         */
        Restaurant paradise =
                new Restaurant(
                        "R1",
                        "Paradise"
                );

        MenuItem biryani =
                new MenuItem(
                        "M1",
                        "Chicken Biryani",
                        250
                );

        MenuItem kebab =
                new MenuItem(
                        "M2",
                        "Chicken Kebab",
                        180
                );

        paradise.addMenuItem(biryani);
        paradise.addMenuItem(kebab);

        restaurantRepository.addRestaurant(
                paradise
        );

        /*
         * Delivery Partners
         */
        DeliveryPartner ravi =
                new DeliveryPartner(
                        "D1",
                        "Ravi",
                        "8888888888"
                );

        DeliveryPartner krishna =
                new DeliveryPartner(
                        "D2",
                        "Krishna",
                        "7777777777"
                );

        partnerRepository.addPartner(ravi);
        partnerRepository.addPartner(krishna);

        /*
         * Cart
         */
        Cart cart = new Cart();

        cartService.addItem(
                cart,
                biryani,
                2
        );

        cartService.addItem(
                cart,
                kebab,
                1
        );

        System.out.println(
                "Cart Amount : "
                        + cart.getTotalAmount()
        );

        /*
         * Place Order
         */
        Order order =
                orderService.placeOrder(
                        bhanu,
                        paradise,
                        cart,
                        address,
                        PaymentType.UPI
                );

        /*
         * Register Observers
         */
        order.addObserver(
                new CustomerNotification()
        );

        order.addObserver(
                new RestaurantNotification()
        );

        order.addObserver(
                new DeliveryPartnerNotification()
        );

        /*
         * Assign Delivery Partner
         */
        deliveryService.assignPartner(
                order
        );

        /*
         * Track Order
         */
        System.out.println(
                "Current Status : "
                        + order.getStatus()
        );

        /*
         * Restaurant starts preparing
         */
        order.prepare();

        System.out.println(
                "Current Status : "
                        + order.getStatus()
        );

        /*
         * Food Ready
         */
        order.readyForPickup();

        System.out.println(
                "Current Status : "
                        + order.getStatus()
        );

        /*
         * Delivery Partner Pickup
         */
        order.pickup();

        System.out.println(
                "Current Status : "
                        + order.getStatus()
        );

        /*
         * Delivered
         */
        order.deliver();

        System.out.println(
                "Current Status : "
                        + order.getStatus()
        );

        /*
         * Track Order
         */
        Order trackedOrder =
                orderService.trackOrder(
                        order.getOrderId()
                );

        System.out.println(
                "Tracked Order Status : "
                        + trackedOrder.getStatus()
        );
    }
}