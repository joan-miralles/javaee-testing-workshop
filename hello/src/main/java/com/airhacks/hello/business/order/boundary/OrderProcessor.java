package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.OrderHistory;
import com.airhacks.hello.business.order.control.PaymentProcessor;
import com.airhacks.hello.business.order.entity.Order;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrderProcessor {

    @Inject
    LegacyAuthenticator authenticator;

    @Inject
    PaymentProcessor paymentProcessor;

    @Inject
    OrderHistory orderHistory;

    public void order(String orderId) {
        if (!this.authenticator.authenticate()) {
            throw new IllegalStateException("Not authenticated!");
        }
        Order order = new Order(orderId);
        this.paymentProcessor.pay();
        this.orderHistory.save(order);
    }
}
