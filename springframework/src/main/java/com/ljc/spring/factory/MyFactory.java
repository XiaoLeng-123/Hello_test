package com.ljc.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.ljc.spring.entity.PersonEntity;


/**
 *在bean中注册该工厂
 * @author JD-DZ612
 *
 */

public class MyFactory implements FactoryBean<Object>{

	
	//返回创建的对象
	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return new PersonEntity();
	}

	
	//返回创建对象的类型
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return PersonEntity.class;
	}

	
	//默认创建的bean是单实例的
	@Override
	public boolean isSingleton() {
		return true;
	}

}
