package com.example.multiconsumer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.multiconsumer.model.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducer {

	  private final KafkaTemplate<String, Object> kafkaTemplate;
	  
	  public void sendOrder(Order order) {

	        kafkaTemplate.send("orders", order);

	        System.out.println("Order sent to Kafka: " + order);
	    }
}
