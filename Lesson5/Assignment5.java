//Your assignment for this lesson is to write a GUI program that will use a button to count down from 
//five to zero. When it reaches zero, it should display a label indicating the end of the count. 
//Each click should decrease the number by one. For example, when the program starts the button 
//will say "Five" or "5." After the first click, it will say "Four" or "4," and so on. 
//When it gets to zero, the button should be replaced by a label with a message in it. 
//The text in the label can say anything you like.
//
//There are two things you will need to use that we did not discuss in the lesson. 
//You will need to be able to find out what text was on the button when it was clicked. 
//You can do that with the button's getText() method.
//
//You will also need to know how to make a button disappear so you can see the label. 
//A button has a setVisible() method just like a frame does. To make the button disappear, 
//call its setVisible() method with an argument of false.
//
//If you would like a little more of a challenge, investigate JOptionPane's other dialog formats and 
//see if you can make them work. The challenging part is determining which button was clicked if there 
//is more than one button. 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * creates a frame and puts a button in the frame that will count down
 * from 5 to 0; at 0 two more count down buttons will be produced, the original
 * button will be removed three seconds later
 */
public class Assignment5{
	JFrame frame;
	Container contentPane;
	String START_TEXT = "Five";
	int offspring = 2; // the number buttons a button finished counting down will create

	public static void main(String[] args){
		Assignment5 a = new Assignment5();
	}

	/**
	 * constructor
	 * creates frame, adds first button 
	 */
	public Assignment5(){
		frame = new JFrame("Count Down Button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		addCountDownButtons(1);
	}	
	/**
	 * adds count down buttons to frame
	 * @param n number of new buttons to create and add to frame
	 */
	public void addCountDownButtons(int n){
		for (int i=0; i < n; i++){
			JButton button = new JButton(START_TEXT);
			button.addActionListener(new CountDownListener());
			contentPane.add(button);
		}
		frame.pack();
	}

	/**
	 * @param word one of the following Strings {Five, Four, Three, Two, One}
	 * @return  
	 */
	public int wordToNumber(String word){
		String searchString = String.format("X%10s%5s%5s%5s%5s","One","Two","Three","Four","Five");
		return searchString.indexOf(word)/5;
	}

	/**
	 * @param num an integer in set {1,2,3,4,5}
	 * @return String representation of argument given
	 */
	public String numberToWord(int num){
	        String[] words = {"One","Two","Three","Four","Five"};
		return words[num-1];
	}

	/**
	 * inner class that is instantiated to act as ActionListener for each button
	 * inner class has access to outer class's instance variables and methods
	 */
	class CountDownListener implements ActionListener{
		/**
		 * decrement text of button if not at 0 yet else remove it in another thread 
		 */
		public void actionPerformed(ActionEvent e){
			JButton button = (JButton)(e.getSource());
			int currentCount = wordToNumber(button.getText());
			currentCount--;
			if(currentCount > 0){ // if not done yet decrement count
				button.setText(numberToWord(currentCount));
			}
			else if (currentCount == 0){ //if done counting down change text and start
				                     //thread to remove the button
				button.setForeground(Color.red);
				button.setText("BAM!");
				addCountDownButtons(offspring);
				Thread goodbye = new Thread(new RemoveButton(button));
				goodbye.start();
			}
		}
	}//end inner class CountDownListener
	/**
	 * Runnable to remove a button from it's container after a set period of time
	 */
	class RemoveButton implements Runnable{
		JButton button;
		/**
		 * constructor 
		 * @param button button to be removed
		 */
		public RemoveButton(JButton button){
			this.button = button;
		}
		/**
		 * waits two seconds and then changes text on button
		 * waits one second longer and then removes button entirely
		 */
		public void run(){
			try{
			Thread.sleep(2000);
			}catch(Exception e){}
			SwingUtilities.invokeLater(new Runnable() {
				public void run(){
					button.setForeground(Color.blue);
					button.setText("BYE :(");
					}
				});
			try{
			Thread.sleep(1000);
			}catch(Exception e){}
			SwingUtilities.invokeLater(new Runnable() {
				public void run(){
					contentPane.remove(button);
					contentPane.validate();
					frame.pack();
				}
			});
		}
	}//end inner class RemoveButton
}//end class Assignment5

