package com.ecommerce.shipping;

import com.ecommerce.shared.OrderData;

public class ShippingActivityImpl implements ShippingActivity {
    @Override
    public void shipOrder(OrderData order) {
        System.out.println("Shipping order to customer: " + order.getCustomerId());
    }
}
