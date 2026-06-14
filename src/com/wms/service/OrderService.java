package com.wms.service;

import com.wms.model.Order;
import com.wms.model.OrderItem;
import com.wms.model.Warehouse;
import com.wms.strategy.InventoryAllocationStrategy;

public class OrderService {

    private InventoryService inventoryService;

    private InventoryAllocationStrategy strategy;

    public OrderService(
            InventoryService inventoryService,
            InventoryAllocationStrategy strategy) {

        this.inventoryService = inventoryService;
        this.strategy = strategy;
    }

    public void placeOrder(
            Order order,
            Warehouse warehouse) {

        for (OrderItem item :
                order.getItems()) {

            inventoryService.reserveStock(
                    warehouse,
                    item.getProduct(),
                    item.getQuantity()
            );
        }

        order.reserve();
    }
}