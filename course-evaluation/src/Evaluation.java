import java.util.Scanner;

public class Evaluation {
	
	static int[] scores = new int[5];
	
//	public int setEvalution() {
//		
//	}
//	
//	public int getEvalution() {
//		
//	}
	
	

	public static void main(String[] args) {
		
	//	Student student = new Student();
		
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
		System.out.println("Check your evaluation score : " + scores[0] +" " + scores[1] + " " + scores[2] + " " + scores[3] + " " + scores[4]);
	}
}	
