/** 
 * Classes
 * This class means each classes included in the subject.
 * (ex: Object-Oriented Programming_1, 2, Data Structure_1, 2, Probability and Statistics_1, 2, ...)
 * 
 * This class can append evaluation for each class.
 * and store class room number, class ID, and reference of every evaluations and professors.
 * 
 * @author Han Sunggoo
 * @version 1.0
 * @since 2021-05-20
 */
public class Classes extends Subject {
	private String classRoomNum;	//class Room number (ex. 415) or webex url
	private String classID;		//class ID (ex. 09437001)
	private static int MAX_EVALUATION = 100;
	
	private Evaluation[] evaluation = new Evaluation[MAX_EVALUATION];
	private String professorID;
	private String professorName;
	private int numberOfEvaluations = 0;
	
	public void appendEvaluation(Evaluation obj) {
		this.evaluation[this.numberOfEvaluations] = new Evaluation();
		this.evaluation[this.numberOfEvaluations ++] = obj;
	}
	
	public void setProfessorID(String newprofessor) {
		this.professorID = newprofessor;
	}
	
	public String getProfessorID() {
		return this.professorID;
	}

	public void setProfessorName(String newprofessor) {
		this.professorName = newprofessor;
	}
	
	public String getProfessorName() {
		return this.professorName;
	}
	
	@Override
	public void printAllEvaluation() throws Exception	{
		if(this.numberOfEvaluations == 0)	{
			throw new Exception("No Evaluation.");
		}
		for(Evaluation elem: this.evaluation)	{
			elem.printEvaluation();
		}
	}
	
	@Override
	public void printInformation()	{
		super.printInformation();
		System.out.println("Class Code: " + this.classID + "\nClassroom: " + this.classRoomNum);
	}
	
	@Override
	public double getAverage() throws Exception	{
		if(this.numberOfEvaluations == 0)	{
			throw new Exception("No Evaluation.");
		}
		double average = 0;
		for(int i = 0; i < this.numberOfEvaluations; i++)	{
			average += this.evaluation[i].getEvaluation();
		}
		average /= this.numberOfEvaluations;
		return average;
	}
	
	//Accessor methods
	public String getclassRoomNum() {
		return this.classRoomNum;
	}
	
	public String getclassID() {
		return this.classID;
	}
	 //Mutator methods
	public void setclassRoomNum(String newclassRoomNum) {
		this.classRoomNum = newclassRoomNum;
	}
	
	public void setclassID(String newclassID) {
		this.classID = newclassID;
	}
	//Constructor
	public Classes(String title, String code, String classRoomNum, String classID, String professorID, String professorName) {
		super(title, code);
		this.classRoomNum = classRoomNum;
		this.classID = classID;
		this.professorID = professorID;
		this.professorName = professorName;
		Subject.getSubject(code, title).appendClass(this);		
	}
	
	public static void main(String[] args) {
		Classes Class1 = new Classes("Object-Oriented Programming", "09805", "IT´ëÇÐ-304", "09805001", "123456789", "³ë¿õ±â");
		System.out.println("Subject Code: " + Class1.getCode() + "\nSubject Title: " + Class1.getTitle() + "\nClass Room Number: " + Class1.getclassRoomNum() + "\nclassID: " + Class1.getclassID());
	}
}
