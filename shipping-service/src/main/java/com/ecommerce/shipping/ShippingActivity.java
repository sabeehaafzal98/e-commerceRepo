package com.ecommerce.shipping;

import com.ecommerce.shared.OrderData;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface ShippingActivity {
    void shipOrder( OrderData order);
}
