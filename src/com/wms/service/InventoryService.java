package com.wms.service;

import com.wms.model.Inventory;
import com.wms.model.Product;
import com.wms.model.Warehouse;

public class InventoryService {

    public void addStock(
            Warehouse warehouse,
            Product product,
            int qty) {

        warehouse.addInventory(
                product,
                qty
        );
    }

    public boolean reserveStock(
            Warehouse warehouse,
            Product product,
            int qty) {

        Inventory inventory =
                warehouse.getInventoryMap()
                        .get(product.getProductId());

        if (inventory == null ||
                inventory.getQuantity() < qty) {
            return false;
        }

        inventory.removeStock(qty);

        return true;
    }
}