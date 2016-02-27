import java.util.Scanner;


public class Assignment1{
	int entryCount;
	int numberCount;
	float numberSum;

	public static void main(String[] args){
		Assignment1 a = new Assignment1();
		Scanner in = new Scanner(System.in);
		while(true){
			String token = in.next();
			if(token.equals("*")){
				System.out.println("Session stats:");
				System.out.printf("Total Entries : %d\nNumbers : %d\nNumber Average : %.4f\n",
					                                                   a.entryCount,
											   a.numberCount,
											   a.numberSum/a.numberCount);
				return;
			}
			a.entryCount ++;
			try{
				float num = Float.parseFloat(token);
				a.numberCount ++;
				a.numberSum += num;

			}catch (NumberFormatException e){
				System.out.printf("%s is not an acceptable input value\n",token);
			}

		}
	}
}

