package com.course.kafka.consumer.consume;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.course.kafka.consumer.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentKafkaConsumer {
	
	ObjectMapper objMapper = new ObjectMapper();
	
	@KafkaListener(topics = "t_student", groupId = "c-id-less", containerFactory = "lessAgeContainerFactory")
	public void readLessMessage(String message) throws Exception {
		var student = objMapper.readValue(message, Student.class);
		System.out.println("Reading from Less Filter: " +student.toString());
	}
	
	@KafkaListener(topics = "t_student", groupId = "c-id-more", containerFactory = "moreAgeContainerFactory")
	public void readMoreMessage(String message) throws Exception {
		var student = objMapper.readValue(message, Student.class);
		System.out.println("Reading from More Filter: " +student.toString());
	}


}
