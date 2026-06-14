package com.wms.observer;

public interface InventoryObserver {

    void update(String productId,
                int stock);
}