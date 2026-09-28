package com.example.consumergroup.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumergroup.model.Order;

@Service
public class ConsumerA {

	 @KafkaListener(
		        topics = "consumer-test",
		        groupId = "payment-group"
		    )
		    public void consumeOrder(Order order) {

		        System.out.println(
		            "Consumer A → Order "
		            + order.getOrderId()
		            + " received by Payment Service"
		        );
		    }
}
