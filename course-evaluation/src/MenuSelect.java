import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSelect{

	private JFrame frame;

	public static void main(String[] args) {
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
				new DoEvaluation();
				frame.setVisible(false);
			}
		});
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_1);
		

	}
}
