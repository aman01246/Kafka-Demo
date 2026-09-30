package com.example.partition.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.partition.model.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProducer {

	  private final KafkaTemplate<String, Object> kafkaTemplate;
	  
	  public void sendOrder(Order order) {

//		  int partition = order.getOrderId() % 3;
		  
	        kafkaTemplate.send(
	                "orders",
//	                partition, // this is for manual partition mapping in kafka 
	                order.getCustomerId(), //-> Key == Kafka uses the key to determine the partition.
	                order
	        );

	        System.out.println(  "Order sent: " + order +
	                " → Key: " + order.getCustomerId());
	    }
}
