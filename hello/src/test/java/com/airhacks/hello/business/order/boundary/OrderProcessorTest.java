package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.PaymentProcessor;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OrderProcessorTest {
    OrderProcessor cut;

    @Before
    public void init() {
        this.cut = new OrderProcessor();
        this.cut.paymentProcessor = mock(PaymentProcessor.class);
    }

    @Test
    public void successfulOrder() {
        this.cut.order();
        verify(this.cut.paymentProcessor, times(1)).pay();
    }

    @Test(expected = IllegalStateException.class)
    public void invalidUser() {
        this.cut.authenticator = mock(LegacyAuthenticator.class);
        when(this.cut.authenticator.authenticate()).thenReturn(false);
        this.cut.order();
    }
}
