package com.ecommerce.order;

import com.ecommerce.shared.OrderData;
import io.temporal.workflow.WorkflowInterface;

@WorkflowInterface
public interface OrderWorkflow {
    void fulfillOrder(OrderData order);

}
