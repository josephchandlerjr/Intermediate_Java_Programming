//For this lesson, I'd like you to read a text file I've included with this assignment. 
//The text file contains some simple program code and comments. (You could also use a file of your own creation.)
//
//For this exercise, we'll assume that all comments begin with two slashes (//) and 
//that the slashes are in the first two positions of the line. Write a program to read the input file, 
//find all the lines with comments, and write the comments to an output file. 
//The net result will be a file containing just the comment lines from the input file.
//
//To do this exercise, use the Scanner class nextLine() method to read a complete line at a time. 
//Put the line into a String variable, and check the first two characters to decide whether to write 
//the line to the comment file. The method indexOf() in the String class gives you an easy way to 
//check for one string in another string and find its location.
//
//Once you've completed the assignment, click the link below to see a sample solution:
//
//If you want to go a step further, have your program create two output files. 
//The first should be the same as above, containing all the comment lines from the input file. 
//The second should contain all the other lines—the ones that are not comments.
//
//If you want another challenge, try finding the comments that do not start in the first column 
//using the String class indexOf() method and write them to the comment file, too.


import java.io.*;
import java.util.*;

/**
 * reads a java source file given to the constructor and writes two files
 * one containing the comments and one containing everything else
 */
public class Assignment3{

	public static void main(String[] args){
		Assignment3 a = new Assignment3("L03_assign_1.html");
	}// main
	public Assignment3(String inputFile){
		String comments = ""; 
		String code = "";
		//intially io readers/writers to null to make compiler happy
		Scanner in = null;
		PrintStream commentsOut = null;
		PrintStream codeOut = null;
		try{
			in = new Scanner(new File(inputFile));
			commentsOut = new PrintStream("comments.html");
			codeOut = new PrintStream("code.html");

			while(in.hasNextLine()){
				String line = in.nextLine();
				int beginComment = line.indexOf("//");
				if(beginComment < 0){
					beginComment = line.length();
				}
				comments += line.substring(beginComment) + "\n";
				code += line.substring(0,beginComment) + "\n";
			}
			commentsOut.println(comments);
			codeOut.println(code);
		}catch(IOException e){
			System.err.println("*****IO EXCEPTION CAUGHT*****");
		}finally{
			in.close();
			commentsOut.close();
			codeOut.close();
		}//end try catch finally blocks
	}// end constructor
}// end class
