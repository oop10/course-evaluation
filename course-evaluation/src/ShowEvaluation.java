import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class ShowEvaluation {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowEvaluation window = new ShowEvaluation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowEvaluation() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC15\uC758\uD3C9\uAC00 \uD655\uC778\uD558\uAE30");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(100, 35, WIDTH, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel evaluationlabel = new JLabel("학수번호/과목/평가평균점수");
		evaluationlabel.setHorizontalAlignment(SwingConstants.CENTER);
		evaluationlabel.setFont(new Font("굴림", Font.BOLD, 20));
		evaluationlabel.setBounds(119, 90, WIDTH, 21);
		frame.add(evaluationlabel);
		Subject[] s = Subject.getAllSubject();
        int i = 30;
        int j;
        

        for(j = 0; j < Subject.getnumberofSubjects(); j++) {
        	JLabel label;
        	String output = s[j].getTitle() + " / " + s[j].getCode() + " / ";
			try {
				output += s[j].getAverage();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				// JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
				System.out.println(e.getMessage());
				output += "평가정보없음";
			} finally {
				label = new JLabel(output);
				label.setFont(new Font("굴림", Font.BOLD, 15));
	        	label.setHorizontalAlignment(SwingConstants.CENTER);
	        	label.setBounds(119, 150 + i, WIDTH, 16);
	        	frame.add(label);
	        	i = i + 30;
			}
        }
		frame.setVisible(true);
		
		
		JButton btnNewButton = new JButton("\uBA54\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btnNewButton.setBounds(400, 400, 97, 23);
//		btnNewButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerforemed(ActionEvent e) {
//				new MenuSelect();
//				frame.setVisible(false);
//			}
//			});

		frame.getContentPane().add(btnNewButton);
	}
}
