package com.ecommerce.order;

import com.ecommerce.shared.OrderData;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderWorkflowClient workflowClient;

    @POST
    public Response placeOrder(OrderData order) {
        OrderEntity.persist(order);
        workflowClient.startWorkflow(order);
        return Response.ok("Order placed").build();
    }
}
