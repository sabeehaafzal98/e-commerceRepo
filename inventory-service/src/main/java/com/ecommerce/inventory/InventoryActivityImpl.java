package com.ecommerce.inventory;

import com.ecommerce.shared.OrderData;

public class InventoryActivityImpl implements InventoryActivity {
    @Override
    public void reserveInventory(OrderData order) {
        System.out.println("Reserving inventory for product: " + order.getProductId());
    }
}
