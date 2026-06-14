package com.wms.strategy;

import com.wms.model.Inventory;
import com.wms.model.Order;
import com.wms.model.OrderItem;
import com.wms.model.Warehouse;

import java.util.List;

public class MaxInventoryStrategy
        implements InventoryAllocationStrategy {

    @Override
    public Warehouse allocate(
            Order order,
            List<Warehouse> warehouses) {

        OrderItem item = order.getItems().get(0);

        Warehouse selectedWarehouse = null;
        int maxStock = -1;

        for (Warehouse warehouse : warehouses) {

            Inventory inventory =
                    warehouse.getInventoryMap()
                            .get(item.getProduct()
                                    .getProductId());

            if (inventory == null) {
                continue;
            }

            if (inventory.getQuantity() > maxStock) {
                maxStock = inventory.getQuantity();
                selectedWarehouse = warehouse;
            }
        }

        return selectedWarehouse;
    }
}