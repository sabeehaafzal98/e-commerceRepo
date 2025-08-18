@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderWorkflowClient workflowClient;

    @POST
    public Response placeOrder(OrderData order) {
        OrderEntity.persist(order.toEntity());
        workflowClient.startWorkflow(order);
        return Response.ok("Order placed").build();
    }
}
