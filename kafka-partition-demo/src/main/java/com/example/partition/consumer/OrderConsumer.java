package com.example.partition.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.partition.model.Order;

@Service
public class OrderConsumer {

	 @KafkaListener(
		        topics = "orders",
		        groupId = "partition-group"
		    )
		    public void consumeOrder(ConsumerRecord<String, Order> record) {

		        System.out.println(
		            "Order " + record.value().getOrderId()
		            + " → Partition " + record.partition()
		            + " → Offset " + record.offset()
		            + " → Key " + record.key()
		            + " → Value " + record.value()
		        );
		    }
}
