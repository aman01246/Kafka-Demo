package com.example.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.model.Order;
import com.example.payment.producer.OrderProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderProducer orderProducer;

	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@RequestBody Order order) {

		orderProducer.sendOrder(order);

		return ResponseEntity.accepted()
				.body("Order created and sent to Kafka");
	}

}
