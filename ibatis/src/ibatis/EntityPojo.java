package ibatis;

public class EntityPojo {

	
	private int id;
	private String name;
	private String age;
	public EntityPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EntityPojo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public EntityPojo(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EntityPojo [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
