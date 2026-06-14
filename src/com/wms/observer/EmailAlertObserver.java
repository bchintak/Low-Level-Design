package com.wms.observer;

public class EmailAlertObserver
        implements InventoryObserver {

    @Override
    public void update(
            String productId,
            int stock) {

        System.out.println(
                "Email Alert : "
                        + productId
                        + " stock="
                        + stock);
    }
}