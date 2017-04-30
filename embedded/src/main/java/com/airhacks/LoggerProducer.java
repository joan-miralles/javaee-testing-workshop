package com.airhacks;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class LoggerProducer {

    @Produces
    public Logger expose(InjectionPoint ip) {
        Class<?> clazz = ip.getMember().getDeclaringClass();
        return Logger.getLogger(clazz.getName());
    }
}
