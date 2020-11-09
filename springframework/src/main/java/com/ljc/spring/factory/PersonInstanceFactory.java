package com.ljc.spring.factory;

import com.ljc.spring.entity.PersonEntity;

/**
 * 实例工厂
 * @author JD-DZ612
 *
 */
public class PersonInstanceFactory {

	public PersonEntity getPerson() {	
		System.out.println("PersonInstanceFactory");
		return new PersonEntity();	
	}
}
