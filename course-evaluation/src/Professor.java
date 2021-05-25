import java.io.*;

public class Professor extends Person{

	//Constructor
	public Professor(String name,String id) {
		super("professor",name,id);
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
					if(id.equals(ary[2])) {
						subject[j] = ary[0] + "-" + ary[1];
						j++;
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
			System.out.println("**subject list you can show result**");
			for(int i = 0; subject[i] != null; i++) {
				System.out.println(i + "." + subject[i]);
				subjectLength++;
			}
			return true;
		}
	}
	
}
