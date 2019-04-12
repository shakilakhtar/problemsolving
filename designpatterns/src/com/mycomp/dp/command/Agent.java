package com.mycomp.dp.command;

import java.util.LinkedList;
import java.util.List;

//Invoker.
public class Agent {

    private LinkedList ordersQueue = new LinkedList();

    public Agent() {
    }
    
    void placeOrder(Order order) {
        ordersQueue.addLast(order);
        order.execute(ordersQueue.getFirst());
    }   
}
