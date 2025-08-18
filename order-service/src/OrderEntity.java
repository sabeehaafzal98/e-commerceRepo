@Entity
public class OrderEntity extends PanacheEntity {
    public String customerId;
    public String productId;
    public int quantity;
    public String status;
}
