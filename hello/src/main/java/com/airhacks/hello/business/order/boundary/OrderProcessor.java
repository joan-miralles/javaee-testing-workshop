package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.PaymentProcessor;

public class OrderProcessor {

    private LegacyAuthenticator authenticator;
    private PaymentProcessor paymentProcessor;

    public OrderProcessor() {
        this.authenticator = new LegacyAuthenticator();
        this.paymentProcessor = new PaymentProcessor();
    }

    public void order() {
        if (!this.authenticator.authenticate()) {
            throw new IllegalStateException("Not authenticated!");
        }
        this.paymentProcessor.pay();
    }
}
