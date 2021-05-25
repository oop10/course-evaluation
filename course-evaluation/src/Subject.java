import java.util.Scanner;

/** 
 * Subject
 * This class means each subject.
 * (ex: Object-Oriented Programming, Data Structure, Probability and Statistics, ...)
 * 
 * This class can get average evaluation score, print every evaluation, print all class,
 * and store subject code, subject title, and reference of every classes.
 * 
 * @author Lee Jaehoon
 * @version 1.0
 * @since 2021-05-19
 */

public class Subject {
	
	private static int MAX_SUBJECT = 100;
	private static int MAX_CLASSES = 100;
	
	private static Subject[] subjects = new Subject[Subject.MAX_SUBJECT];
	private static String[] subjectCodes = new String[Subject.MAX_SUBJECT];
	private static int numberOfSubjects = 0;
	
	private String code;	// Subject code (ex. 09805)
	private String title;	// Subject title (ex. Object-Oriented Programming)
	
	// class class 생성 후 사용할 부분
	private Classes[] classes = new Classes[Subject.MAX_CLASSES];
	private int numberOfClasses = 0;
	
	public void appendClass(Classes obj) {
		this.classes[this.numberOfClasses++] = obj;		
	}
	
	/*
	public double getAverage() {
		double score = 0;
		
		// Get sum of every class's average evaluation score.
		for(Classes elem: this.classes) {
			score += elem.getAverage();
		}
		score /= this.classes.length;
		
		return score;
	}
	
	public void printAllEvaluation()	{
		// Print every evaluation in classes.
		for(Classes elem: this.classes) {
			// Print every evaluation in given class.
			elem.printAllEvalution();
		}
	}
	
	public void printAllClass()	{
		// Print information about every class.
		for(Classes elem: this.classes) {
			// Print information about given class.
			elem.printInformation();
		}
	}
	*/
	
	
	// Accessor methods
	public String getCode() {
		return this.code;
	}
	
	public String getTitle()	{
		return this.title;
	}
	
	// Mutator methods
	public void setCode(String code)	{
		this.code = code;
	}
	
	public void setTitle(String title)	{
		this.title = title;
	}
	
	// get Instance
	public static Subject getSubject(String code, String title) {
		int i;
		
		for(i = 0; i < Subject.numberOfSubjects; i++)	{
			if(subjectCodes[i].equals(code))	{
				return subjects[i]; 
			}
		}
		
		if(i == Subject.numberOfSubjects) {
			// Could not found given subject instance
			return new Subject(title, code);
		}
		
		return null;
	}
	
	public static Subject getSubject(String code) {
		int i;
		
		for(i = 0; i < Subject.numberOfSubjects; i++)	{
			if(subjectCodes[i].equals(code))	{
				return subjects[i]; 
			}
		}
	
		return null;
	}

	
	// Constructor
	
	public Subject(String title, String code)	{
		this.code = code;
		this.title = title;
		
		Subject.subjectCodes[Subject.numberOfSubjects] = code;
		Subject.subjects[Subject.numberOfSubjects] = this;
		Subject.numberOfSubjects++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject oop = new Subject("Object-Oriented Programming", "09805");
		System.out.println("Subject Code: " + oop.getCode() + "\nSubject Title: " + oop.getTitle());
	}

}
