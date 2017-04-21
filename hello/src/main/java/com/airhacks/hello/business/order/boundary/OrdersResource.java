package com.airhacks.hello.business.order.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("orders")
public class OrdersResource {

    @Inject
    OrderProcessor orderProcessor;

    @POST
    public void order(JsonObject order) {
        String trackingNumber = order.getString("tracking-number");
        orderProcessor.order(trackingNumber);
    }
}
