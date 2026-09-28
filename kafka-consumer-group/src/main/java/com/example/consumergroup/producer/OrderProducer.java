package com.example.consumergroup.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.consumergroup.model.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducer {

	 private final KafkaTemplate<String, Object> kafkaTemplate;
	 
	  public void sendOrder(Order order) {

	        kafkaTemplate.send( "consumer-test",
	        	    String.valueOf(order.getOrderId()),
	        	    order
	        	    );

	        System.out.println("Order sent to Kafka: " + order);
	    }
}
