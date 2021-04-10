package com.course.kafka.producer.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.course.kafka.producer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeJSONKafkaProducer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public void sendMessage(Employee employee) throws JsonProcessingException{
		String message = objectMapper.writeValueAsString(employee);
		kafkaTemplate.send("t_employee", message);
	}

}
