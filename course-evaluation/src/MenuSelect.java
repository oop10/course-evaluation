import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSelect{

   private JFrame frame;
   private static final String COURSE_DB_FILE = "db_course.txt";
   private static final String STUDENT_DB_FILE = "db_student.txt";
   
   private static void readCourseDB()   {
        BufferedReader inputStream = null;
        try {
           inputStream = new BufferedReader(new FileReader(COURSE_DB_FILE));
           String line = null;
           line = inputStream.readLine();   // 첫줄생략
           while((line = inputStream.readLine()) != null) {
              String[] ary = line.split(",");
              Classes elem = new Classes(ary[1], ary[0].substring(0, 5), ary[2], ary[0], ary[3], ary[4]);
           }
        } catch (FileNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
        } finally {
           try {
            inputStream.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
        }
    }
   
   private static void readStudentDB() throws Exception {
      BufferedReader inputStream_student = null;
      try {
         inputStream_student = new BufferedReader(new FileReader(STUDENT_DB_FILE));
         String line = null;
         line = inputStream_student.readLine(); // 첫줄 생략
         int find_Index = 0;
         while ((line = inputStream_student.readLine()) != null) {
            String[] ary = line.split(",");
            Classes cl = Subject.getSubject(ary[0].substring(0, 5)).getClass(ary[0]);
            if (cl == null) {
            	throw new Exception("존재하지 않는 분반입니다");
            }
            for (int i = 1; i < ary.length; i++) {
               Student elem = Student.getStudent("LOGIN YET",ary[i]);
               elem.appendClasses(cl);
            }
         }
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            inputStream_student.close();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
   

   public static void main(String[] args) throws Exception {      
      MenuSelect.readCourseDB();
      MenuSelect.readStudentDB();
      
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MenuSelect window = new MenuSelect();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   
   public MenuSelect() {
      initialize();
   }


   private void initialize() {
      
      frame = new JFrame();
      frame.getContentPane().setFont(new Font("Nirmala UI", Font.BOLD, 12));
      frame.setBounds(100, 100, 500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Course Evaluation System");
   
      JLabel lblNewLabel = new JLabel("Course Evaluation System");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 22));
      lblNewLabel.setBounds(76, 47, 324, 34);
      frame.getContentPane().add(lblNewLabel);
      //frame.getContentPane().setBackground(Color.lightGray);
      
      JButton btnNewButton = new JButton("Show course evaluation");
      btnNewButton.setFont(new Font("Nirmala UI", Font.BOLD, 12));
      btnNewButton.setBounds(52, 160, 168, 160);
      btnNewButton.setBackground(Color.white);
      btnNewButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new ShowEvaluation();
            frame.setVisible(false);
            
         }
      });
      
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("Evaluate my course");
      btnNewButton_1.setFont(new Font("Nirmala UI", Font.BOLD, 14));
      btnNewButton_1.setBounds(259, 160, 168, 160);
      btnNewButton_1.setBackground(Color.white);
      btnNewButton_1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	LoginGUI a = new LoginGUI();
     		a.setVisible(true);
        	//new DoEvaluation();
            //frame.setVisible(false);
         }
      });
      
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(btnNewButton_1);
      

   }
}