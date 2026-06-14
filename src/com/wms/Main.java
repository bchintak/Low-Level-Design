package com.wms;

import com.wms.model.Address;
import com.wms.model.Order;
import com.wms.model.OrderItem;
import com.wms.model.Product;
import com.wms.model.Warehouse;
import com.wms.notification.NotificationService;
import com.wms.enums.NotificationType;
import com.wms.factory.NotificationFactory;
import com.wms.service.InventoryService;
import com.wms.service.OrderService;
import com.wms.strategy.MaxInventoryStrategy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Create Product
        Product laptop =
                new Product(
                        "P101",
                        "Laptop",
                        65000
                );

        // Create Warehouse
        Warehouse warehouse =
                new Warehouse(
                        "WH1",
                        new Address(
                                "Hyderabad",
                                "Telangana",
                                "500001"
                        )
                );

        // Add Inventory
        warehouse.addInventory(
                laptop,
                50
        );

        System.out.println(
                "Current Stock : "
                        + warehouse.getInventoryMap()
                        .get(laptop.getProductId())
                        .getQuantity()
        );

        // Create Order Item
        OrderItem orderItem =
                new OrderItem(
                        laptop,
                        2
                );

        // Create Order
        Order order =
                new Order(
                        "ORD-101",
                        List.of(orderItem)
                );

        // Create Services
        InventoryService inventoryService =
                new InventoryService();

        OrderService orderService =
                new OrderService(
                        inventoryService,
                        new MaxInventoryStrategy()
                );

        // Place Order
        orderService.placeOrder(
                order,
                warehouse
        );

        System.out.println(
                "Stock After Reservation : "
                        + warehouse.getInventoryMap()
                        .get(laptop.getProductId())
                        .getQuantity()
        );

        // Ship Order
        order.ship();

        // Send Notification
        NotificationService notificationService =
                NotificationFactory.create(
                        NotificationType.EMAIL
                );

        notificationService.send(
                "bhanu@gmail.com",
                "Order Shipped Successfully"
        );
    }
}