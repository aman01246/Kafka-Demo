package com.example.payment.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.model.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void sendOrder(Order order) {

		kafkaTemplate.send(
				"orders", 
				order.getCustomerId(), 
				order
		);

		System.out.println("Order sent to orders topic: " + order);
	}
}
