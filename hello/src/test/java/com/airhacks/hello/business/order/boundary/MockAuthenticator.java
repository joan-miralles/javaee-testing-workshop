package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;

public class MockAuthenticator extends LegacyAuthenticator {

    @Override
    public boolean authenticate() {
        return false;
    }
}

