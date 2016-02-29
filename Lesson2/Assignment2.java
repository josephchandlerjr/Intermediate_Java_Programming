//For your Lesson 2 assignment, I would like you to use an array to figure out which day of the week 
//is the best for a fictional business. Write a program to ask a user for sales information. 
//For each sale, have the user enter the day of the week and the amount of the sale. 
//Store total sales for each day of the week in an array, and after the last sale is entered, 
//list the sales for each day and tell which day had the highest sales.
//
//If you are looking for a tougher challenge, you can also store the number of sales for each day and 
//calculate the average amount of each sale for each day of the week.



import java.util.Scanner;

public class Assignment2{
	private double[] weekdaySums = new double[7]; //total value in sales for each weekday
	private int[] weekdaySales = new int[7]; // total number of sales made per each weekday

	public static void main(String[] args){
		(new Assignment2()).go();
	}

	public Assignment2(){
		//initialize values
		for (int i=0; i < 7; i++){
			weekdaySums[i] = 0;
			weekdaySales[i] = 0;
		}
	}
	public void go(){

		boolean notDone = true;
		Scanner in = new Scanner(System.in);

		while(notDone){
			System.out.print("Sale Information (enter * to quit):\n\n");
			System.out.print("Please enter sale total: $");
			double saleValue = 0;
			if (in.hasNextDouble()){
				saleValue = in.nextDouble();
			}
			else{
				String err = in.next();
				if(err.equals("*")){
					System.out.print("Goodbye");
					return;
				}
				System.out.printf("%s is an invalid entry\n\n\n",err);
				continue;
			}
			System.out.println();

			System.out.print("Please enter day of week sale was made in the following format.\n");
			System.out.print("[mon | tue | wed | thr | fri | sat | sun] : ");
			String weekday = in.next();
			weekday = weekday.toLowerCase();
			System.out.println();
			int ix = weekdayToInteger(weekday); 

			if(ix == -1){
				System.out.printf("%s is an invalid entry\n\n\n",weekday);
				continue;
			}

			weekdaySums[ix] += saleValue; 
			weekdaySales[ix]++;

			System.out.println(this);

		}//end while loop
	}//end main

	public String integerToWeekday(int i){
		return "montuewedthrfrisatsun".substring(i*3,+i*3+3);
	}
	public int weekdayToInteger(String weekday){
		int ix = -1;
		if(weekday.equals("mon")){ix = 0;}
		else if(weekday.equals("tue")){ix = 1;}
		else if(weekday.equals("wed")){ix = 2;}
		else if(weekday.equals("thr")){ix = 3;}
		else if(weekday.equals("fri")){ix = 4;}
		else if(weekday.equals("sat")){ix = 5;}
		else if(weekday.equals("sun")){ix = 6;}

		return ix;
	}

	public double average(int weekdayIndex){
		double sum = weekdaySums[weekdayIndex];
		int sales = weekdaySales[weekdayIndex];
		if (sales < 1){
			return 0;
		}
		return sum / sales;
	}

	public String toString(){
		double maxSale = 0;
		int bestDay = 0;
		for (int i=0;i<weekdaySums.length;i++){
			if(weekdaySums[i] > maxSale){
				bestDay = i;
				maxSale = weekdaySums[i];
			}
		}
		String result = "Stats thus far:\n";
		result += String.format("best day so far is %s\n", integerToWeekday(bestDay));
		result += String.format("%10s %10s %10s\n","day","total","average");
		for(int i = 0; i < 7 ; i++){
			result += String.format("%10s %10.2f %10.2f\n",integerToWeekday(i),
					                        weekdaySums[i],
			                                        average(i));
		}
		return result;

	}
}//end class
