package com.example.multiconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.multiconsumer.model.Order;

@Service
public class SmsConsumer {

	  @KafkaListener(
		        topics = "orders",
		        groupId = "sms-group"
		    )
		    public void consumeOrder(Order order) {

		        System.out.println(
		            "📱 SMS Consumer: Order "
		            + order.getOrderId()
		            + " received for customer "
		            + order.getCustomerName()
		        );
		    }
}
