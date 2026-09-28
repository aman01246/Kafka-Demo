package com.example.consumergroup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumergroup.model.Order;
import com.example.consumergroup.producer.OrderProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderProducer producer;

	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@RequestBody Order order) {

		producer.sendOrder(order);

		return ResponseEntity.accepted().body("Order sent to Kafka");
	}
}
