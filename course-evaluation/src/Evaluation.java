import java.util.Scanner;

public class Evaluation {
	
	private int[] scores = new int[5];
	
	public void setScores(int[] newScore) {
		for(int i = 0; i < 5; i++) {
			scores[i] = newScore[i];
		}
	}
	
	/*// CLI -> GUI
	public void setEvalution() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program is to evalute the your course.\n");
		
		
		System.out.printf("Question 1 : ���� ������ ���� ��ȹ����� ����Ǿ��� (1~5) ");
		scores[0]=keyboard.nextInt();
		while(scores[0] <= 0 || scores[0] > 5) {
			System.out.printf("Question 1 : ���� ������ ���� ��ȹ����� ����Ǿ��� (1~5) ");
			scores[0]=keyboard.nextInt();
		}
		
		System.out.printf("Question 2 : ������ ���� ������ ������ü�� �غ�Ǿ��� (1~5) ");
		scores[1]=keyboard.nextInt();
		while(scores[1] <= 0 || scores[1] > 5) {
			System.out.printf("Question 2 : ������ ���� ������ ������ü�� �غ�Ǿ��� (1~5) ");
			scores[1]=keyboard.nextInt();
		}
		
		System.out.printf("Question 3 : ���� ������ ü�����̾���. (1~5) ");
		scores[2]=keyboard.nextInt();
		while(scores[2] <= 0 || scores[2] > 5) {
			System.out.printf("Question 3 : ���� ������ ü�����̾���. (1~5) ");
			scores[2]=keyboard.nextInt();
		}
		
		System.out.printf("Question 4 : ���� �� ������ ���Ͽ� ���� ������ ����� (1~5) ");
		scores[3]=keyboard.nextInt();
		while(scores[3] <= 0 || scores[3] > 5) {
			System.out.printf("Question 4 : ���� �� ������ ���Ͽ� ���� ������ ����� (1~5) ");
			scores[3]=keyboard.nextInt();
		}
		
		System.out.printf("Question 5 : ���� �� ������ �ٸ� �л����� ��õ�ϰ� �ʹ� (1~5) ");
		scores[4]=keyboard.nextInt();
		while(scores[4] <= 0 || scores[4] > 5) {
			System.out.printf("Question 5 : ���� �� ������ �ٸ� �л����� ��õ�ϰ� �ʹ� (1~5) ");
			scores[4]=keyboard.nextInt();
		
		}
		
	}*/
	
	public void printEvaluation() {
		
		System.out.println("Check your evaluation score : " + scores[0] +" " + scores[1] + " " + scores[2] + " " + scores[3] + " " + scores[4]);
		
	}
	
	public int getEvaluation()   {
	      int score = 0;
	      for(int i = 0; i < 5; i ++) {
	         score = score + scores[i];
	      }
	      /*
	      for(int elem: scores) {
	         score += elem;
	      }*/
	      return score;
	   }
	

}	
