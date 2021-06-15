import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener{
	private static final String COURSE_DB_FILE = "db_course.txt";
	private static final String STUDENT_DB_FILE = "db_student.txt";
	   
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
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
		String[] allStudentId = Student.getAllStudentId();
		Student user = null;
		for(int i = 0; i < Student.getNumberOfStudent(); i++) {
			if(allStudentId[i].equals(userId)) {
				user = Student.getStudent(userName, userId);
			}
		}
		JPanel panel = new JPanel();
		if(userId.length() != 9) {
			//loginerror2
			JOptionPane error2 = new JOptionPane();
			JOptionPane.showMessageDialog(null,"학수번호 길이 오류");
		}
		else if(user.getClassCount() == 0) {
			//loginerror1
			JOptionPane error1 = new JOptionPane();
			JOptionPane.showMessageDialog(null,"학수번호에 맞는 수강 강의가 없습니다");
		}
		else {
			//go to evaluation page
			SelectClassToEvaluate b = new SelectClassToEvaluate(user, user.getClassCount());
			b.setVisible(true);
		}
	}
}

