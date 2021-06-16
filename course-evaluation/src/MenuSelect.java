import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSelect extends JFrame{

   private JFrame frame;
   private static final String COURSE_DB_FILE = "db_course.txt";
   private static final String STUDENT_DB_FILE = "db_student.txt";
   
   private static void readCourseDB()   {
        BufferedReader inputStream = null;
        try {
           inputStream = new BufferedReader(new FileReader(COURSE_DB_FILE));
           String line = null;
           line = inputStream.readLine();
           while((line = inputStream.readLine()) != null) {
              String[] ary = line.split(",");
              Classes elem = new Classes(ary[1], ary[0].substring(0, 5), ary[2], ary[0], ary[3], ary[4]);
           }
        } catch (FileNotFoundException e) {
          
        	JOptionPane.showMessageDialog(null,"db_course.txt file doesn't exist!","Error Message",JOptionPane.WARNING_MESSAGE);
        	
           e.printStackTrace();
        } catch (IOException e) {
         
           e.printStackTrace();
        } finally {
           try {
            inputStream.close();
         } catch (IOException e) {
          
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
            	throw new Exception("No exist class!!");
            }
            for (int i = 1; i < ary.length; i++) {
               Student elem = Student.getStudent("LOGIN YET",ary[i]);
               elem.appendClasses(cl);
            }
         }
      } catch (FileNotFoundException e) {
    	  JOptionPane.showMessageDialog(null,"db_student.txt file doesn't exist!","Error Message",JOptionPane.WARNING_MESSAGE);
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
      
      JButton btnShow = new JButton("Show course evaluation");
      btnShow.setFont(new Font("Nirmala UI", Font.BOLD, 12));
      btnShow.setBounds(52, 160, 168, 160);
      btnShow.setBackground(Color.white);
      btnShow.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new ShowEvaluation();

         }
      });
      
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(btnShow);
      
      JButton btnEvaluate = new JButton("Evaluate my course");
      btnEvaluate.setFont(new Font("Nirmala UI", Font.BOLD, 14));
      btnEvaluate.setBounds(259, 160, 168, 160);
      btnEvaluate.setBackground(Color.white);
      btnEvaluate.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	LoginGUI a = new LoginGUI();
     		a.setVisible(true);
        
         }
      });
      
      frame.getContentPane().setLayout(null);
      frame.getContentPane().add(btnEvaluate);
      


   }
}