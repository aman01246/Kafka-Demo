package com.example.payment.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.payment.model.InventoryUpdated;

@Service
public class NotificationConsumer {

	 @KafkaListener(
		        topics = "inventory",
		        groupId = "notification-group"
		    )
		    public void sendNotification(InventoryUpdated inventoryUpdated) {

		        System.out.println(
		            "Notification Service → Order "
		            + inventoryUpdated.getOrderId()
		            + " inventory updated successfully"
		        );
		    }
}
