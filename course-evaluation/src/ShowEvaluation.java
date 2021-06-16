import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class ShowEvaluation extends JFrame{
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
		
			e.printStackTrace();
		}
	}

	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Show evaluation");
		
		JLabel lblNewLabel = new JLabel("<Show course evaluation>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblNewLabel.setBounds(107, 42, 253, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel evaluationlabel = new JLabel("  Subject / Subject Id / Average evaluation score");
		evaluationlabel.setHorizontalAlignment(SwingConstants.CENTER);
		evaluationlabel.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		evaluationlabel.setBounds(-16, 78, 500, 40);
		frame.getContentPane().add(evaluationlabel);
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
				output += "No evaluation";
			} finally {
				label = new JLabel(output);
				label.setFont(new Font("±¼¸²", Font.BOLD, 15));
	        	label.setHorizontalAlignment(SwingConstants.CENTER);
	            label.setBounds(-23, 150 + i, WIDTH, 16);
	        	frame.getContentPane().add(label);
	        	i = i + 30;
			}
        }
		
		frame.setVisible(true);
	}

	
}
