import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoEvaluation {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoEvaluation window = new DoEvaluation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DoEvaluation() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("\uAC15\uC758 \uD3C9\uAC00\uD558\uAE30");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 35, 241, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uBA54\uC778\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btnNewButton.setBounds(362, 416, 97, 23);
		frame.getContentPane().add(btnNewButton);
	
	}
}
