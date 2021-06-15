import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener{
	private static final String COURSE_DB_FILE = "db_course.txt";
	private static final String STUDENT_DB_FILE = "db_student.txt";
	   
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private int classCount = 0;
	
	private JLabel lblTitle = new JLabel("course evaluation system");
	private JLabel lblName = new JLabel("이      름 : ");
	private JLabel lblID = new JLabel("학수번호 : ");
	private Font fontTitle = new Font("맑은 고딕",Font.BOLD,35);
	private Font fontName = new Font("맑은 고딕",Font.BOLD,15);
	private Font fontID = new Font("맑은 고딕",Font.BOLD,15);
	private JTextField txtName = new JTextField(15);
	private JTextField txtID = new JTextField(15);
	private JButton loginButton = new JButton("로그인");
	
	public LoginGUI() {
		
		setSize(WIDTH, HEIGHT);
		setTitle("2. 강의 평가 하기 - 로그인");
		
		Container container = getContentPane();
		container.setLayout(null);
		
		lblTitle.setFont(fontTitle);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setBounds(0,100,500,50);
		container.add(lblTitle);
		
		lblName.setFont(fontName);
		lblName.setBounds(100,180,500,30);
		container.add(lblName);
		txtName.setBounds(200,180,200,35);
		container.add(txtName);
		
		lblID.setFont(fontID);
		lblID.setBounds(100,250,500,30);
		container.add(lblID);
		txtID.setBounds(200,250,200,35);
		container.add(txtID);
		
		loginButton.addActionListener(this);
		loginButton.setBounds(45,330,400,35);
		container.add(loginButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = txtName.getText().trim();
		String userId = txtID.getText().trim();
		Student user = new Student(userName,userId);
		
		BufferedReader inputStream_student = null;
		try {
			inputStream_student = new BufferedReader(new FileReader(STUDENT_DB_FILE));
			String line = null;
			line = inputStream_student.readLine(); //첫줄 생략
			int find_Index = 0;
			while((line = inputStream_student.readLine()) != null) {
				String[] ary = line.split(",");
				for(int i = 1; i < ary.length; i++) {
					if(userId.equals(ary[i])) {
						classCount ++;
						BufferedReader inputStream_coursedb = null;
						try {
							inputStream_coursedb = new BufferedReader(new FileReader(COURSE_DB_FILE));
							String lineInCoursedb = null;
							lineInCoursedb = inputStream_coursedb.readLine();//첫줄 생략
							int indexInCoursedb = 0;
							while(find_Index > indexInCoursedb) {
								lineInCoursedb = inputStream_coursedb.readLine();
								indexInCoursedb++;
							}
							lineInCoursedb = inputStream_coursedb.readLine();
							String[] aryForNewClass = lineInCoursedb.split(",");
							Classes elem = new Classes(aryForNewClass[1], aryForNewClass[0].substring(0, 5), aryForNewClass[2], aryForNewClass[0], aryForNewClass[3], aryForNewClass[4]);
							user.appendClasses(elem);
						}catch (FileNotFoundException eIncoursedb) {
				            // TODO Auto-generated catch block
							eIncoursedb.printStackTrace();
				         } catch (IOException eIncoursedb) {
				            // TODO Auto-generated catch block
				        	 eIncoursedb.printStackTrace();
				         }
				        finally {
				        	inputStream_coursedb.close();
				        } 
					}
				}
				find_Index ++;
			}
		}catch (FileNotFoundException eInStudentdb) {
            eInStudentdb.printStackTrace();
         } catch (IOException eInStudentdb) {
        	 eInStudentdb.printStackTrace();
         }
        finally {
        	try {
				inputStream_student.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        } 
		JPanel panel = new JPanel();
		if(userId.length() != 9) {
			//loginerror2
			JOptionPane error2 = new JOptionPane();
			JOptionPane.showMessageDialog(null,"학수번호 길이 오류");
		}
		else if(classCount == 0) {
			//loginerror1
			JOptionPane error1 = new JOptionPane();
			JOptionPane.showMessageDialog(null,"학수번호에 맞는 수강 강의가 없습니다");
		}
		else {
			//go to evaluation page
			SelectClassToEvaluate b = new SelectClassToEvaluate(user, classCount);
			b.setVisible(true);
		}
	}
	
	//Mutator
	public void setClassCount(int count) {
		classCount = count;
	}
	
}

