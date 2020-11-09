package com.ljc.spring.factory;

import com.ljc.spring.entity.PersonEntity;

/**
 * 静态工厂
 * @author JD-DZ612
 *
 */
public class PersonStaticFactory {
	
	public static PersonEntity getPerson() {	
		System.out.println("PersonStaticFactory");
		return new PersonEntity();	
	}

}
