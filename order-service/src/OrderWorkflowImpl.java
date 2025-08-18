public class OrderWorkflowImpl implements OrderWorkflow {

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
