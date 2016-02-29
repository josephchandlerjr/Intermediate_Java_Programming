//Write a short Java program that does some input, some output, and some calculations. 
//Think of it as a Java refresher problem in case it has been awhile since you've done any Java programming.
//
//This program should set up a loop and keep requesting input until the user enters an asterisk (*). 
//Each line you enter that has data should contain a floating-point number.
//
//Once the user ends the input with an asterisk, display three items: a count of the number of entries, 
//the total of all the numbers, and the average of all the numbers.

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

