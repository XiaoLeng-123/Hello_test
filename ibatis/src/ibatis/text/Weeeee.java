package ibatis.text;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import ibatis.EntityDao;
import ibatis.EntityPojo;

public class Weeeee {

	@Test
	public void www() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//openSession(true)：该方法里面写一个true，表示自动提交
			try (SqlSession session = sqlSessionFactory.openSession(true)) {
				EntityDao mapper = session.getMapper(EntityDao.class);
				EntityPojo blog = mapper.selectBlog(1);
				System.out.println(blog);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
