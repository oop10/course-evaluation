
public class Student extends Person{

	private int maxClasses = 10;
	private int classCount = 0;
	private String password;
	private Evaluation[] evaluate = new Evaluation[maxClasses];
	private Classes[] classes = new Classes[maxClasses];
	
	//Constructor
	public Student(String name,String id,String password) {
		super("student",name,id);
		this.password = password;
	}
	
	//Method
	public void appendClasses(Classes newClass) {
		classes[classCount] = newClass;
		classCount++;
	}
	public void getEvaluationByClass(int selectSubject) {
		evaluate[selectSubject] = new Evaluation();
		evaluate[selectSubject].setEvalution();
		evaluate[selectSubject].getEvalution();
		classes[selectSubject].appendEvaluation(evaluate[selectSubject]);
	}
	
	public void printAllClassesName() {
		for(int i = 0; i < classCount; i++) {
			System.out.println(i + ":" + classes[i].getTitle());
		}		
	}

	//Mutator
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Accessor
	public String getPassword() {
		return password;
	}
	public String getSpecificClassesName(int index) {
		return classes[index].getTitle();
	}

}
