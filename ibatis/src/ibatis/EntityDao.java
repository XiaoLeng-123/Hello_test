package ibatis;

import org.apache.ibatis.annotations.Select;

public interface EntityDao {

	
	//@Select(value = { "" })
	public EntityPojo selectBlog(int id);
	
}
