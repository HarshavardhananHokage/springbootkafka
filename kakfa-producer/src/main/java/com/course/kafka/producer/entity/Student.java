package com.course.kafka.producer.entity;

public class Student {

	String name;

	int age;

	long dateOfBirth;

	public Student() {

	}

	public Student(String name, int age, long dateOfBirth) {
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
