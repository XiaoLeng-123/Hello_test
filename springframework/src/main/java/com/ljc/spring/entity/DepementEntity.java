package com.ljc.spring.entity;

import java.util.List;
import java.util.Map;

public class DepementEntity {

	private int id;
	private String lastname;
	private String ment;
	private List<PersonEntity> list;
	private Map<String,Object> map;
	private PersonEntity personEntity;

	public DepementEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepementEntity(int id, String lastname, String ment) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.ment = ment;
	}

	
	public DepementEntity(int id, String lastname, String ment, List<PersonEntity> list, Map<String, Object> map) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.ment = ment;
		this.list = list;
		this.map = map;
	}

	public DepementEntity(int id, String lastname, String ment, List<PersonEntity> list, Map<String, Object> map,
			PersonEntity personEntity) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.ment = ment;
		this.list = list;
		this.map = map;
		this.personEntity = personEntity;
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

	public String getMent() {
		return ment;
	}

	public void setMent(String ment) {
		this.ment = ment;
	}

	
	public List<PersonEntity> getList() {
		return list;
	}

	public void setList(List<PersonEntity> list) {
		this.list = list;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	@Override
	public String toString() {
		return "DepementEntity [id=" + id + ", lastname=" + lastname + ", ment=" + ment + ", list=" + list + ", map="
				+ map + ", personEntity=" + personEntity + "]";
	}

	


}
