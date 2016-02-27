import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment6 implements ActionListener{
	private JButton wrapButton,doNotWrapButton, clearButton;
	private JButton scrollVerticallyButton, scrollHorizontallyButton, scrollBothButton, doNotScrollButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private final String WRAP_TEXT = "Wrap Text";
	private final String DO_NOT_WRAP_TEXT = "Do Not Wrap Text";
	private final String CLEAR_TEXT = "Clear Text";
	private final String SCROLL_V = "Scroll Vertically";
	private final String SCROLL_H = "Scroll Horizontally";
	private final String SCROLL_BOTH = "Scroll Both Ways";
	private final String DO_NOT_SCROLL = "Do Not Scroll";

	//constants for setting scrollbar 
	private final int VERTICAL = 1; //vertical 
	private final int HORIZONTAL = 2; //horizontal
	private final int BOTH = 3; //both
	private final int NEVER = 4; //Never


	public static void main(String[] args){
		new Assignment6().go();
	}

	public void go(){
		JFrame frame = new JFrame("Assignment 6");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		JLabel label = new JLabel("Use the buttons to control the layout of the text you type");
		
		//make the left hand panel and add buttons
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(4,1));

	        wrapButton = new JButton(WRAP_TEXT);
		doNotWrapButton = new JButton(DO_NOT_WRAP_TEXT);
                clearButton = new JButton(CLEAR_TEXT);
		JButton blank = new JButton();

		leftPanel.add(wrapButton);
		leftPanel.add(doNotWrapButton);
		leftPanel.add(blank);
		leftPanel.add(clearButton);
		leftPanel.validate();
		for (Component component : leftPanel.getComponents()){
			((JButton)(component)).addActionListener(this);
		}

		//make the right hand panel and add buttons
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(4,1));

		scrollVerticallyButton = new JButton(SCROLL_V); 
		scrollHorizontallyButton = new JButton(SCROLL_H);
		scrollBothButton = new JButton(SCROLL_BOTH);
		doNotScrollButton = new JButton(DO_NOT_SCROLL);

		rightPanel.add(scrollVerticallyButton);
		rightPanel.add(scrollHorizontallyButton);
		rightPanel.add(scrollBothButton);
		rightPanel.add(doNotScrollButton);
		for (Component component : rightPanel.getComponents()){
			((JButton)(component)).addActionListener(this);
		}

		//make textArea and it's scrollPane
		textArea = new JTextArea(10,25);
		setWrap(false);
		scrollPane = new JScrollPane(textArea);
		setScroll(NEVER);

		//add components to frame
		contentPane.add(label, BorderLayout.NORTH);
		contentPane.add(leftPanel, BorderLayout.WEST);
		contentPane.add(rightPanel, BorderLayout.EAST);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()){
			case WRAP_TEXT : setWrap(true);
					  break;
			case DO_NOT_WRAP_TEXT : setWrap(false);
		                          break;
			case CLEAR_TEXT : clearText();
					  break;
			case SCROLL_V : setScroll(VERTICAL);
					  break;
			case SCROLL_H : setScroll(HORIZONTAL);
					  break;
			case SCROLL_BOTH : setScroll(BOTH);
					  break;
			case DO_NOT_SCROLL : setScroll(NEVER);
					  break;
		}
	}

	public void setWrap(boolean bool){
		textArea.setLineWrap(bool);
	}
	public void clearText(){
		textArea.setText("");
	}
	public void setScroll(int property){
		switch (property){
			case VERTICAL : 
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			break;

			case HORIZONTAL :
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			break;
			
			case BOTH : 
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			break;

			case NEVER : 
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			break;
		}
	}
}
