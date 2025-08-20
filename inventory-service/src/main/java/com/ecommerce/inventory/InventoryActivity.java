package com.ecommerce.inventory;

import com.ecommerce.shared.OrderData;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface InventoryActivity {
    void reserveInventory(OrderData order);
}
