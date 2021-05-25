import java.io.*;

public class Student extends Person{

	private String password;
	private String[] Evaluation;
	
	//Constructor
	public Student(String name,String id,String password) {
		super("student",name,id);
		this.password = password;
	}
	
	//Method
	@Override
	public boolean canLogin() throws IOException {
		BufferedReader inputStream = null;
		int j = 0;
		try {
			inputStream = new BufferedReader(new FileReader("information.txt"));
			String line = null;
			line = inputStream.readLine();
			while((line = inputStream.readLine()) != null) {
				String[] ary = line.split(" ");
				for(int i = 3; i < ary.length; i++) {
					if(id.equals(ary[i])) {
						subject[j] = ary[0] + "-" + ary[1];
						j++;
					}
				}
			}
		}
		catch(Exception e) {
			System.out.println("exception!");
			System.exit(0);
		}
		if(inputStream != null) {
			inputStream.close();
		}
		
		if(j == 0) {
			return false;
		}
		else {
			System.out.println("**login success**");
			System.out.println("**subject list you can evaluate**");
			for(int i = 0; subject[i] != null; i++) {
				System.out.println(i + "." + subject[i]);
				subjectLength++;
			}
			return true;
		}
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

}
