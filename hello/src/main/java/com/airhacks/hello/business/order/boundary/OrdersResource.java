package com.airhacks.hello.business.order.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("orders")
public class OrdersResource {

    @Inject
    OrderProcessor orderProcessor;

    @POST
    public void order() {
        orderProcessor.order();
    }
}
