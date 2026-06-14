package com.wms.strategy;

import com.wms.model.Order;
import com.wms.model.Warehouse;

import java.util.List;

public interface InventoryAllocationStrategy {

    Warehouse allocate(
            Order order,
            List<Warehouse> warehouses);
}