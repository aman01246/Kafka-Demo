package com.example.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafka.model.Order;

@Service
public class OrderConsumer {

	@KafkaListener(topics = "orders", groupId = "order-group")
	public void consumerOrder(Order order) {
		
		System.out.println("Order "+order.getOrderId() + " received for customer "
	            + order.getCustomerName());
	}
}
