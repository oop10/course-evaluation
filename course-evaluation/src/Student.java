
public class Student extends Person{

	public static final int maxClass = 100;
	private int classCount = 0;
	private Evaluation[] evaluate = new Evaluation[maxClass];
	public Classes[] classes = new Classes[maxClass];
	
	//Constructor
	public Student(String name,String id) {
		super("student",name,id);
	}
	
	//Method
	public void appendClasses(Classes newClass) {
		classes[classCount] = newClass;
		classCount++;
	}
	
	public void getEvaluationByClass(int selectSubject,int[] scores) {
		evaluate[selectSubject] = new Evaluation();
		evaluate[selectSubject].setScores(scores);
		classes[selectSubject].appendEvaluation(evaluate[selectSubject]);
	}
	
	public String getSpecificClassesName(int index) {
		return classes[index].getTitle();
	}

	//Accessor
	public int getClassCount() {
		return classCount;
	}
	
	public Classes[] getClasses() {
		return classes;
	}
	/* CLI -> GUI
	public void printAllClassesName() {
		for(int i = 0; i < classCount; i++) {
			System.out.println(i + ":" + classes[i].getTitle());
		}		
	}
	*/
}
