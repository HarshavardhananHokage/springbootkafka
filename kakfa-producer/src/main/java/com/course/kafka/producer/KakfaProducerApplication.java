package com.course.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.kafka.producer.produce.HelloWorldKafkaProducer;

@SpringBootApplication
public class KakfaProducerApplication implements CommandLineRunner{
	
	@Autowired
	private HelloWorldKafkaProducer helloWorldKafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KakfaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloWorldKafkaProducer.sendMessage("Harshavardhanan " + Math.random());
		
	}

}