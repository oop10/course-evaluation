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
public class Classes extends Subject{
	private String classRoomNum;	//class Room number (ex. 415) or webex url
	private String classID;		//class ID (ex. 09437001)
	/*
	private Evaluation[] evaluation;
	private Professor professor;
	
	public void appendEvaluation(Evaluation[] newEvaluation){
		this.evaluation = newEvaluation;
	}
	*/
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
	public Classes(String title, String code, String classRoomNum, String classID) {
		super(title, code);
		this.classRoomNum = classRoomNum;
		this.classID = classID;
	}
	
	public static void main(String[] args) {
		Classes Class1 = new Classes("Object-Oriented Programming", "09805", "Object-Oriented Programming-1", "09805001");
		System.out.println("Subject Code: " + Class1.getCode() + "\nSubject Title: " + Class1.getTitle() + "\nClass Room Number: " + Class1.getclassRoomNum() + "\nclassID: " + Class1.getclassID());
	}
}
