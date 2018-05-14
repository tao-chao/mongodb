package com.znsd.mongodb.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="student") /*跟hibernate相似 指定表名*/
public class StudentBean {
	@Id
	private String uuid;
	private String studentName;
	private int age;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "StudentBean [uuid=" + uuid + ", studentName=" + studentName + ", age=" + age + "]";
	}
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentBean(String uuid, String studentName, int age) {
		super();
		this.uuid = uuid;
		this.studentName = studentName;
		this.age = age;
	}
	
}
