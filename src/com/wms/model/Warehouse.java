package com.wms.model;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private String warehouseId;
    private Address address;

    private Map<String, Inventory> inventoryMap =
            new HashMap<>();

    public Warehouse(String warehouseId,
                     Address address) {
        this.warehouseId = warehouseId;
        this.address = address;
    }

    public void addInventory(Product product,
                             int quantity) {

        inventoryMap.putIfAbsent(
                product.getProductId(),
                new Inventory(product, 0)
        );

        inventoryMap
                .get(product.getProductId())
                .addStock(quantity);
    }

    public Map<String, Inventory> getInventoryMap() {
        return inventoryMap;
    }

    public String getWarehouseId() {
        return warehouseId;
    }
}