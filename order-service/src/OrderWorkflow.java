@WorkflowInterface
public interface OrderWorkflow {
    @WorkflowMethod
    void fulfillOrder(OrderData order);
}
