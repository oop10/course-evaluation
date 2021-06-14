import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
   
   private static final String COURSE_DB_FILE = "db_course.txt";   // location of course database file
   private static final String STUDENT_DB_FILE = "db_student.txt";   // location of student database file

   public static void main(String[] args) throws IOException {
      final int maxStudentNum = 50;
      String status,name,id;
      
      int i = 0;

      Scanner keyboard = new Scanner(System.in);
      
      while(true) {
         System.out.println("====Menu====");
         System.out.println("1. 강의 평가 보기");
         System.out.println("2. 강의 평가 추가 / 수정하기");
         System.out.println("3. 종료");
         i = keyboard.nextInt();
         
         //1. 강의 평가 보기
         if(i == 1) {
            BufferedReader inputStream = null;
            try {
               inputStream = new BufferedReader(new FileReader(COURSE_DB_FILE));
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
            } finally {
            	inputStream.close();
            }
         }
         
         //2. 강의 평가 추가 / 수정하기 - student action
         else if(i == 2) {
            System.out.println("**login**");
            System.out.print("Name : ");
            name = keyboard.next();
            System.out.print("ID : ");
            id = keyboard.next();
            System.out.print("Enter your own pwd : ");
            String pwd = keyboard.next();
            
            Student user = new Student(name,id,pwd);
            
            BufferedReader inputStream = null;
            try {
                inputStream = new BufferedReader(new FileReader(COURSE_DB_FILE));
                String line = null;
                line = inputStream.readLine();   // 첫줄생략
                while((line = inputStream.readLine()) != null) {
                	String[] ary = line.split(",");
                	for(i = 2; i < ary.length; i++) {
                		if(id.equals(ary[i])) {
                			Classes elem = new Classes(ary[0], ary[1].substring(0, 5), "NO CLASSROOM", ary[1]);
                        	user.appendClasses(elem);
                		}
                	}
                }
             } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             }
            finally {
             	inputStream.close();
            }
         	System.out.println("< 평가 가능한 과목 목록 >");
         	user.printAllClassesName();
         	System.out.print("Select subject(want to evaluate) : ");
            int evaluateSubject = keyboard.nextInt();
            System.out.println("Start evaluate : " + user.getSpecificClassesName(evaluateSubject));
            user.getEvaluationByClass(evaluateSubject);
         }
      }
   }
}