package com.course.kafka.producer.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.kafka.producer.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentKafkaProducer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	public void sendMessage(Student student) throws JsonProcessingException {
		
		kafkaTemplate.send("t_student", objectMapper.writeValueAsString(student));
		
	}

}
