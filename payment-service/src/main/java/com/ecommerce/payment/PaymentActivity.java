package com.ecommerce.payment;

import com.ecommerce.shared.OrderData;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface PaymentActivity {
    void processPayment(OrderData order);
}
