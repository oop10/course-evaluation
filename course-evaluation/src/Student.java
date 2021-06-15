
public class Student extends Person{

	public static final int maxStudent = 100;
	public static final int maxClass = 100;
	private int classCount = 0;
	private static int numberOfStudent = 0;
	
	private static Student[] student = new Student[maxStudent];
	private static String[] studentID = new String[maxStudent];
	private Evaluation[] evaluate = new Evaluation[maxClass];
	public Classes[] classes = new Classes[maxClass];
	
	public static Student getStudent(String name,String studentId){
		int i;
		
		for(i = 0; i < Student.numberOfStudent; i++){
			if(studentID[i].equals(studentId)){
				student[i].setName(name);
				return student[i];
			}
		}
		
		if(i == Student.numberOfStudent) {
			// Could not found given student instance
			return new Student(name,studentId);
		}
		
		return null;
	}
	
	//Overloading
	public static Student getStudent(String name,String studentId,String classId){
		int i;
		
		for(i = 0; i < Student.numberOfStudent; i++){
			if(studentID[i].equals(studentId)){
				student[i].setName(name);
				return student[i];
			}
		}
		
		if(i == Student.numberOfStudent) {
			// Could not found given student instance
			return new Student(name,studentId);
		}
		
		return null;
	}
	
	//Constructor
	public Student(String name,String id) {
		super("student",name,id);
		Student.studentID[numberOfStudent] = id;
		Student.student[numberOfStudent] = this;
		numberOfStudent++;
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
	public static String[] getAllStudentId() {
		return studentID;
	}
	
	public static int getNumberOfStudent() {
		return numberOfStudent;
	}
	
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
