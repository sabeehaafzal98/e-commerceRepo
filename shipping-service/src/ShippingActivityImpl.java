public class ShippingActivityImpl implements ShippingActivity {
    @Override
    public void shipOrder(OrderData order) {
        System.out.println("Shipping order to customer: " + order.customerId);
    }
}
