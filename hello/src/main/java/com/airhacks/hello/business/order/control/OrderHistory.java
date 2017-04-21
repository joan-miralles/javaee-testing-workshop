package com.airhacks.hello.business.order.control;


import com.airhacks.hello.business.order.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OrderHistory {

    @PersistenceContext
    EntityManager em;

    public void save(Order order) {
        this.em.merge(order);
    }
}
