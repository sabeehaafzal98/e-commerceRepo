package com.ecommerce.order;

import com.ecommerce.shared.OrderData;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderWorkflowClient {

    private final WorkflowClient client;

    public OrderWorkflowClient() {
        WorkflowServiceStubs workflowServiceStub = WorkflowServiceStubs.newInstance();
        this.client = WorkflowClient.newInstance(workflowServiceStub); // Temporal server address "localhost:7233"
    }

    public void startWorkflow(OrderData order) {
        OrderWorkflow workflow = client.newWorkflowStub(
                OrderWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("ORDER_TASK_QUEUE")
                        .build()
        );

        WorkflowClient.start(workflow::fulfillOrder, order);
    }
}
