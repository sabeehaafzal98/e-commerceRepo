package com.ecommerce.order;

import com.ecommerce.inventory.InventoryActivity;
import com.ecommerce.payment.PaymentActivity;
import com.ecommerce.shared.OrderData;
import com.ecommerce.shipping.ShippingActivity;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class OrderWorkflowImpl implements OrderWorkflow {


    private final ActivityOptions activityOptions = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofMinutes(5)) // adjust as needed
            .setRetryOptions(RetryOptions.newBuilder()
                    .setMaximumAttempts(3)
                    .build())
            .build();


    private final PaymentActivity paymentActivity = Workflow.newActivityStub(PaymentActivity.class, activityOptions);
    private final InventoryActivity inventoryActivity = Workflow.newActivityStub(InventoryActivity.class, activityOptions);
    private final ShippingActivity shippingActivity = Workflow.newActivityStub(ShippingActivity.class, activityOptions);

    @Override
    public void fulfillOrder(OrderData order) {
        paymentActivity.processPayment(order);
        inventoryActivity.reserveInventory(order);
        Workflow.sleep(Duration.ofHours(2)); // simulate shipping delay
        shippingActivity.shipOrder(order);
    }
}
