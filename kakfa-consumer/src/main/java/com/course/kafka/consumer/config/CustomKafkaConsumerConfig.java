package com.course.kafka.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import com.course.kafka.consumer.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class CustomKafkaConsumerConfig {
	
	@Autowired
	KafkaProperties kafkaProperties;
	
	@Bean
	public ConsumerFactory<Object, Object> consumerFactory() {
		var properties = kafkaProperties.buildConsumerProperties();
		
		properties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG, "120000");
		
		return new DefaultKafkaConsumerFactory<>(properties);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<Object, Object> lessAgeContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		var factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, consumerFactory());
		
		factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {
			
			ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
				// TODO Auto-generated method stub
				//Student student;
				try {
					var student = objectMapper.readValue(consumerRecord.value().toString(), Student.class);
					return student.getAge() > 16;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return false;
				}
			}
		});
		
		return factory;
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<Object, Object> moreAgeContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer) {
		var factory = new ConcurrentKafkaListenerContainerFactory<>();
		configurer.configure(factory, consumerFactory());
		
		factory.setRecordFilterStrategy(new RecordFilterStrategy<Object, Object>() {
			
			ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public boolean filter(ConsumerRecord<Object, Object> consumerRecord) {
				// TODO Auto-generated method stub
				//Student student;
				try {
					var student = objectMapper.readValue(consumerRecord.value().toString(), Student.class);
					return student.getAge() <= 16;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					return false;
				}
			}
		});
		
		return factory;
	}

}
