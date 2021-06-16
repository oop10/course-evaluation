import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SelectClassToEvaluate extends JFrame{

	public static final int maxClass = 100;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	private JButton[] classButton = new JButton[maxClass];
	
	private int selectClass;
	private int[] scores = new int[5];
	private int i;
	
	public SelectClassToEvaluate(Student user, int classCount) {
		setSize(WIDTH, HEIGHT);
		setTitle("Evaluate course - Select evaluation course");
		
		Container container = getContentPane();
		container.setLayout(null);
		
		for(i = 0; i < classCount; i++) {
			String title = user.classes[i].getTitle();
			classButton[i] = new JButton(title);
			classButton[i].setBackground(Color.white);
			classButton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int j = 0; j < classCount; j++) {
						if(user.classes[j].getTitle().equals(e.getActionCommand())) {
							selectClass = j;
							break;
						}
					}
					EvaluationGUI b = new EvaluationGUI(user,selectClass);
					b.setVisible(true);
					scores = b.getScores();
				}
			});
			classButton[i].setBounds(70,100*i + 30,350,50);
			container.add(classButton[i]);
		}
	}
	

}
