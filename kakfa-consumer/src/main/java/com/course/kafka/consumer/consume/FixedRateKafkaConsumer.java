package com.course.kafka.consumer.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateKafkaConsumer {
	
	Logger logger = LoggerFactory.getLogger(FixedRateKafkaConsumer.class);
	
	@KafkaListener(topics = "t_fixedrate")
	public void readMessage(String message) {
		logger.info(message);
	}

}
