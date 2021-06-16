import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EvaluationGUI extends JFrame{

	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private int[] scores = new int[5];
	public EvaluationGUI(Student user, int selectSubject) {
		
		setSize(WIDTH,HEIGHT);
		setTitle("Evaluate course - Evaluation");
		
		Container container = getContentPane();
		container.setLayout(null);
				
		JLabel lblHead = new JLabel("  Question number : Evaluation content                                                     Score Evalutation");
		lblHead.setBounds(3, 10,500,30);
		container.add(lblHead);
		
		//Q1
		JLabel lblQ1 = new JLabel("Question 1 : The lecture was conducted according to the syllabus.");
		lblQ1.setBounds(10,40,390,50);
		container.add(lblQ1);
		Choice choice1 = new Choice();
		choice1.add("1");choice1.add("2");choice1.add("3");choice1.add("4");choice1.add("5");
		choice1.select(2);
		choice1.setBounds(400,55,50,50);
		container.add(choice1);
		
		//Q2
		JLabel lblQ2 = new JLabel("Question 2 : The education media is a proper for course ready.");
		lblQ2.setBounds(10,90,390,50);
		container.add(lblQ2);
		Choice choice2 = new Choice();
		choice2.add("1");choice2.add("2");choice2.add("3");choice2.add("4");choice2.add("5");
		choice2.select(2);
		choice2.setBounds(400,100,50,50);
		container.add(choice2);
		
		//Q3
		JLabel lblQ3 = new JLabel("Question 3 : The progress of the course was systematic.");
		lblQ3.setBounds(10,140,390,50);
		container.add(lblQ3);
		Choice choice3 = new Choice();
		choice3.add("1");choice3.add("2");choice3.add("3");choice3.add("4");choice3.add("5");
		choice3.select(2);
		choice3.setBounds(400,145,50,50);
		container.add(choice3);
		
		//Q4
		JLabel lblQ4 = new JLabel("Question 4 : I gained a lot of knowledge through this course.");
		lblQ4.setBounds(10,190,390,50);
		container.add(lblQ4);
		Choice choice4 = new Choice();
		choice4.add("1");choice4.add("2");choice4.add("3");choice4.add("4");choice4.add("5");
		choice4.select(2);
		choice4.setBounds(400,195,50,50);
		container.add(choice4);
		
		//Q5
		JLabel lblQ5 = new JLabel("Question 5 : I want to recommend this course to other students.");
		lblQ5.setBounds(10,240,390,50);
		container.add(lblQ5);
		Choice choice5 = new Choice();
		choice5.add("1");choice5.add("2");choice5.add("3");choice5.add("4");choice5.add("5");
		choice5.select(2);
		choice5.setBounds(400,250,50,50);
		container.add(choice5);
		
		//submit button
		JButton submitButton = new JButton("Submit Evalution");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//score·Î return ¿ä¸Á
				String Q1Result = choice1.getSelectedItem();
				String Q2Result = choice2.getSelectedItem();
				String Q3Result = choice3.getSelectedItem();
				String Q4Result = choice4.getSelectedItem();
				String Q5Result = choice5.getSelectedItem();
				
				scores[0] = Integer.parseInt(Q1Result);
				scores[1] = Integer.parseInt(Q2Result);
				scores[2] = Integer.parseInt(Q3Result);
				scores[3] = Integer.parseInt(Q4Result);
				scores[4] = Integer.parseInt(Q5Result);
				
				user.getEvaluationByClass(selectSubject, scores);
				
				JOptionPane error = new JOptionPane();
				JOptionPane.showMessageDialog(null,"Complete submit your evaluation!");
			}
		});
		submitButton.setBounds(45,330,400,35);
		submitButton.setBackground(Color.white);
		container.add(submitButton);
		container.setVisible(true);
	}
	
	public int[] getScores() {
		return scores;
	}
}

