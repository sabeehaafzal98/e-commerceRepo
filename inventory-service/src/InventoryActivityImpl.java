public class InventoryActivityImpl implements InventoryActivity {
    @Override
    public void reserveInventory(OrderData order) {
        System.out.println("Reserving inventory for product: " + order.productId);
    }
}
