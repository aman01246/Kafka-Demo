package com.example.payment.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.model.Order;
import com.example.payment.model.Payment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentConsumer { 

	 private final KafkaTemplate<String, Object> kafkaTemplate;
	 
	 @KafkaListener(
		        topics = "orders",
		        groupId = "payment-group"
		    )
		    public void processPayment(Order order) {

		        System.out.println(
		            "Payment Service → Processing payment for Order "
		            + order.getOrderId()
		            + " | Amount: "
		            + order.getAmount()
		        );
		        
		     // Simulate successful payment
		        Payment payment = new Payment(
		            order.getOrderId(),
		            order.getCustomerId(),
		            order.getAmount(),
		            "SUCCESS"
		        );
		        
		        // Publish payment event
		        kafkaTemplate.send(
		            "payments",
		            order.getCustomerId(),
		            payment
		        );

		        System.out.println(
		            "Payment processed → " + payment
		        );
		    }
}
