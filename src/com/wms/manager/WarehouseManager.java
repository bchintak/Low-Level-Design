package com.wms.manager;

import com.wms.model.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseManager {

    private static final WarehouseManager INSTANCE =
            new WarehouseManager();

    private WarehouseManager() {
    }

    public static WarehouseManager getInstance() {
        return INSTANCE;
    }

    private List<Warehouse> warehouses =
            new ArrayList<>();

    public void addWarehouse(
            Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }
}