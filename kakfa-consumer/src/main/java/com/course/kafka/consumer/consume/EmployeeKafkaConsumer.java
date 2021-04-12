package com.course.kafka.consumer.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.course.kafka.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class EmployeeKafkaConsumer {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	Logger logger = LoggerFactory.getLogger(EmployeeKafkaConsumer.class);
	
	@KafkaListener(topics = "t_employee")
	public void readEmployee(String message) throws JsonMappingException, JsonProcessingException {
		Employee employee = mapper.readValue(message, Employee.class);
		System.out.println(employee);
	}

}
