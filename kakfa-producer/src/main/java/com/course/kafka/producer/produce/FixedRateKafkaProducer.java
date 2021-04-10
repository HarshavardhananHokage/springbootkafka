package com.course.kafka.producer.produce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FixedRateKafkaProducer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	Logger logger = LoggerFactory.getLogger(FixedRateKafkaProducer.class);
	
	private int i = 0;
	
	@Scheduled(fixedRate = 2000)
	public void sendMessage() {
		i++;
		
		kafkaTemplate.send("t_fixedrate", "This is message " +i);
		logger.info("This is message " +i);
	}

}
