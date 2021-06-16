//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Demo {
//   
//   private static final String COURSE_DB_FILE = "db_course.txt";   // location of course database file
//   private static final String STUDENT_DB_FILE = "db_student.txt";   // location of student database file
//
//   public static void main(String[] args) throws IOException {
//      final int maxStudentNum = 50;
//      String status,name,id;
//      
//      int i = 0;
//
//      Scanner keyboard = new Scanner(System.in);
//      
//      while(true) {
//         System.out.println("====Menu====");
//         System.out.println("1. ���� �� ����");
//         System.out.println("2. ���� �� �߰� / �����ϱ�");
//         System.out.println("3. ����");
//         i = keyboard.nextInt();
//         
//         //1. ���� �� ����
//         if(i == 1) {
//            BufferedReader inputStream = null;
//            try {
//               inputStream = new BufferedReader(new FileReader(COURSE_DB_FILE));
//               String line = null;
//               line = inputStream.readLine();   // ù�ٻ���
//               while((line = inputStream.readLine()) != null) {
//                  String[] ary = line.split(",");
//                  Classes elem = new Classes(ary[1], ary[0].substring(0, 5), ary[2], ary[0], ary[3], ary[4]);
//                  System.out.println("Import ... " + elem.getCode() + " / " + Subject.getSubject(elem.getCode()).getTitle());
//               }
//            } catch (FileNotFoundException e) {
//               // TODO Auto-generated catch block
//               e.printStackTrace();
//            } catch (IOException e) {
//               // TODO Auto-generated catch block
//               e.printStackTrace();
//            } finally {
//            	inputStream.close();
//            }
//            
//            try {
//            	System.out.println("�򰡸� Ȯ���� �����ȣ�� �Է��ϼ��� (ex. 12345) : ");
//            	String test = keyboard.next();
//            	Subject obj = Subject.getSubject(test);
//
//            	if(obj == null)	{
//            		throw new Exception("�������� �ʴ� �����Դϴ�. �м���ȣ�� Ȯ���ϼ���.");
//            	}
//            	
//            	obj.printInformation();
//            	System.out.println("* ��� ������: " + obj.getAverage());
//            	System.out.println("* ��� ��:");
//            	obj.printAllEvaluation();
//            	System.out.println("* ��� �й�:");
//            	obj.printAllClass();
//            }
//            catch(Exception e){
//            	System.out.println(e.getMessage());
//            	// e.printStackTrace();
//            }
//           
//         }
//         
//         //2. ���� �� �߰� / �����ϱ� - student action
//         else if(i == 2) {
//            System.out.println("**login**");
//            System.out.print("Name : ");
//            name = keyboard.next();
//            System.out.print("ID : ");
//            id = keyboard.next();
//            System.out.print("Enter your own pwd : ");
//            String pwd = keyboard.next();
//            
//            Student user = new Student(name,id);
//            
//            BufferedReader inputStream = null;
//            try {
//                inputStream = new BufferedReader(new FileReader(COURSE_DB_FILE));
//                String line = null;
//                line = inputStream.readLine();   // ù�ٻ���
//                while((line = inputStream.readLine()) != null) {
//                	String[] ary = line.split(",");
//                	for(i = 2; i < ary.length; i++) {
//                		if(id.equals(ary[i])) {
//                			Classes elem = new Classes(ary[1], ary[0].substring(0, 5), ary[2], ary[0], ary[3], ary[4]);
//                        	user.appendClasses(elem);
//                		}
//                	}
//                }
//             } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//             } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//             }
//            finally {
//             	inputStream.close();
//            }
//         	System.out.println("< �� ������ ���� ��� >");
//         	user.printAllClassesName();
//         	System.out.print("Select subject(want to evaluate) : ");
//            int evaluateSubject = keyboard.nextInt();
//            System.out.println("Start evaluate : " + user.getSpecificClassesName(evaluateSubject));
//            user.getEvaluationByClass(evaluateSubject);
//         }
//      }
//   }
//}