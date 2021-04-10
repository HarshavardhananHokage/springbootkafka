package com.course.kafka.producer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.kafka.producer.entity.Employee;
import com.course.kafka.producer.produce.EmployeeJSONKafkaProducer;
import com.course.kafka.producer.produce.HelloWorldKafkaProducer;

@SpringBootApplication
//@EnableScheduling
public class KakfaProducerApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeJSONKafkaProducer employeeJSONKafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KakfaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeJSONKafkaProducer.sendMessage(new Employee("employee 1", "Employee Name", LocalDate.now()));
		
	}

}