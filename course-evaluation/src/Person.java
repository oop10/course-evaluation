abstract public class Person {

	public static int maxsubject = 10;
	
	private String status;
	private String name;
	private String id;
	
	//Constructor
	public Person(String status, String name, String id) {
		this.status = status;
		this.name = name;
		this.id = id;
	}
	
	//Mutator
	public void setStatus(String status) {
		this.status = status;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//Accesor
	public String getStatus() {
		return status;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
}
