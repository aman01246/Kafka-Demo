package com.example.consumergroup.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumergroup.model.Order;

@Service
public class ConsumerB {

	 @KafkaListener(
		        topics = "consumer-test",
		        groupId = "notification-group"
		    )
		    public void consumeOrder(Order order) {

		        System.out.println(
		            "Consumer B → Order "
		            + order.getOrderId()
		            + " received by Payment Service"
		        );
		    }
}
