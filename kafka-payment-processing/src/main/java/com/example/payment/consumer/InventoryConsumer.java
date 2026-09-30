package com.example.payment.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment.model.InventoryUpdated;
import com.example.payment.model.Payment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryConsumer {

	 private final KafkaTemplate<String, Object> kafkaTemplate;
	 
	@KafkaListener(
	        topics = "payments",
	        groupId = "inventory-group"
	    )
	    public void updateInventory(Payment payment) {

	        System.out.println(
	            "Inventory Service → Updating inventory for Order "
	            + payment.getOrderId()
	            + " | Payment Status: "
	            + payment.getStatus()
	        );

	        // Simulate inventory update
	        InventoryUpdated inventoryUpdated =
	                new InventoryUpdated(
	                    payment.getOrderId(),
	                    payment.getCustomerId(),
	                    "INVENTORY_UPDATED"
	                );

	        // Publish inventory event
	        kafkaTemplate.send(
	            "inventory",
	            payment.getCustomerId(),
	            inventoryUpdated
	        );

	        System.out.println(
	            "Inventory updated → " + inventoryUpdated
	        );
	    }
}
