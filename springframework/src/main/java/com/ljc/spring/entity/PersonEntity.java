package com.ljc.spring.entity;

public class PersonEntity {

	
	//基本属性直接使用property标签即可
	private int id;
	private String lastname;
	private String age;
	public PersonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonEntity(int id, String lastname, String age) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonEntity [id=" + id + ", lastname=" + lastname + ", age=" + age + "]";
	}
	
	
}
