package com.course.kafka.consumer.consume;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldKafkaConsumer {
	
	@KafkaListener(topics = "t_hello")
	public void consumeMessage(String message) {
		System.out.println(message);
	}

}