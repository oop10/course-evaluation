import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
   
   private static final String DB_FILE = "information.txt";   // location of database file

   public static void main(String[] args) {
      final int maxStudentNum = 50;
      String status,name,id;
      
      int i = 0;

      Scanner keyboard = new Scanner(System.in);
      
      while(true) {
         System.out.println("====Menu====");
         System.out.println("1. 강의 평가 보기");
         System.out.println("2. 강의 평가 / 수정하기");
         System.out.println("3. 종료");
         i = keyboard.nextInt();
         if(i == 1) {
            // Read Subjects and Classes.
            BufferedReader inputStream;
            try {
               inputStream = new BufferedReader(new FileReader(DB_FILE));
               String line = null;
               line = inputStream.readLine();   // 첫줄생략
               while((line = inputStream.readLine()) != null) {
                  String[] ary = line.split(",");
                  Classes elem = new Classes(ary[0], ary[1].substring(0, 5), "NO CLASSROOM", ary[1]);
                  System.out.println(Subject.getSubject(elem.getCode()).getTitle());
               }
            } catch (FileNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
         
         else if(i == 2) {
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
            	
               if(id.length() != 9){//ex) 2020/000/00 -> 9

            	   throw new Exception("Exception : id length wrong");
               }
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
                        user.getEvaluationByClass(evaluateSubject);
                     }
                     else {
                        throw new Exception("Exception : select wrong subject number");
                     }
                  }
                  else {//no id in information.txt file
                     System.out.println("there is no subject to evaluate");
                  }
               }
               
               else//status input wrong
                  throw new Exception("Exception : status input wrong");
            }
            catch(Exception e)
            {
               
            	System.out.println(e.getMessage());
               //System.exit(0);
            }
         }
         else if(i == 3) {
            System.exit(0);
         }
         else {
            System.out.println("Enter the menu number(1~3)!");
         }
      }

   }
}