package com.ecommerce.payment;

import com.ecommerce.shared.OrderData;

public class PaymentActivityImpl implements PaymentActivity {
    @Override
    public void processPayment(OrderData order) {
        System.out.println("Processing payment for order: " + order.getOrderId());
    }
}
