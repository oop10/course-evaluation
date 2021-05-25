
import java.io.IOException;

abstract public class Person {

	public static int maxsubject = 10;
	
	public String id;
	public String[] subject = new String[maxsubject];
	public int subjectLength = 0;
	
	private String status;
	private String name;
	
	//Constructor
	public Person(String status, String name, String id) {
		this.status = status;
		this.name = name;
		this.id = id;
	}
	
	//Method
	abstract public boolean canLogin() throws IOException;
	
	public void setStatus(String status) {
		this.status = status;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public int getSubjectLength() {
		return subjectLength;
	}
	
	
}
