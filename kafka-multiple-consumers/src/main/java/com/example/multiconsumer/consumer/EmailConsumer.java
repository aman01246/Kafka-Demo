package com.example.multiconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.multiconsumer.model.Order;

@Service
public class EmailConsumer {

	@KafkaListener(topics = "orders", groupId = "email-group")
	public void consumeOrder(Order order) {

		System.out.println(
				"📧 Email Consumer: Order " + 
		order.getOrderId() + " received for customer " + 
						order.getCustomerName());
	}
}
