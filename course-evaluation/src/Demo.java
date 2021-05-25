import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		final int maxStudentNum = 50;
		
		String status,name,id;
		
		System.out.println("**login**");
		//Status input
		Scanner input = new Scanner(System.in);
		System.out.print("Student / Professor ? ");
		status = input.next();
		status = status.toLowerCase();//대소관계 X
		//Name input
		System.out.print("Name : ");
		name = input.next();
		//ID input
		System.out.print("ID : ");
		id = input.next();
		
		try
		{
			if(id.length() != 9)//ex) 2020/000/00 -> 9
				throw new Exception("Exception : id length wrong");
			//student
			if(status.equals("student") || status.equals("s")) {
				System.out.print("Enter your own pwd : ");
				String pwd = input.next();
				Student user = new Student(name,id,pwd);
				if(user.canLogin()) {
					System.out.print("Selecte subject(want to evaluate) : ");
					int evaluateSubject = input.nextInt();
					if(evaluateSubject < user.getSubjectLength()) {
						System.out.println("SUBJECT : " + user.subject[evaluateSubject]);
						System.out.println("Start evaluate");
					}
					else {
						throw new Exception("Exception : select wrong subject number");
					}
				}
				else {//no id in information.txt file
					System.out.println("there is no subject to evaluate");
				}
			}
			
			//professor
			else if(status.equals("professor") || status.equals("p")){
				Professor user = new Professor(name,id);
				if(user.canLogin()) {
					
				}
				else {
					System.out.println("there is no subject you educate");
				}
				System.out.println("If you want to add new subject, enter -1");
				System.out.print("Selecte subject(want to show result) : ");
				int selectSubject = input.nextInt();
				if(selectSubject < user.getSubjectLength()) {
					if(selectSubject == -1) {
						//addSubject
						
					}
					else {
						System.out.println("SUBJECT : " + user.subject[selectSubject]);
						System.out.println("Show result");
					}
				}
			}
			else//status input wrong
				throw new Exception("Exception : status input wrong");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
