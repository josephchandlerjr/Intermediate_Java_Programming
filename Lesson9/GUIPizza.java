import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//We've been working with GUI components for a couple of lessons now. 
//It's time to see how to put them together into a complete, working GUI application. 
//For the next two lessons, we're going to pretend we run a small pizza shop. 
//We want to build a GUI Java application that will allow customers to order a pizza online. 
//When they're done creating the order, we'll allow them to save it so we can make the pizza they ordered.
//
//We're going to simplify the application quite a bit in order to make it something we can do in two lessons, 
//so you'll need to suspend your disbelief long enough to pretend this application does everything a real 
//pizza ordering program would do.
//
//While we're working through this project, we'll also pick up a few more GUI components to add to our inventory. 
//These include radio buttons, check boxes, text fields, borders, and a few more odds and ends.

public class GUIPizza{
	private JFrame frame;
	private JPanel contentPane;
	// radio buttons and button group
	private JRadioButton regularCrustButton;
	private JRadioButton thinCrustButton;
	private JRadioButton handCrustButton;
	private JRadioButton deepCrustButton;
	private ButtonGroup crustButtonGroup;

	// check boxes
	private JCheckBox pepperoniBox;
	private JCheckBox sausageBox;
	private JCheckBox cheeseBox;
	private JCheckBox pepperBox;
	private JCheckBox onionBox;
	private JCheckBox mushroomBox;
	private JCheckBox oliveBox;
	private JCheckBox anchovyBox;

	// text fields
	private JTextField breadSticksText;
	private JTextField buffaloWingsText;
	private JTextField nameText;
	private JTextField addressText;
	private JTextField cityText;

	final String aboutText = "GUI Pizza\n\nVersion 1.0\nBuild B20080226-1746\n\n"+
		                 "(c)Copyright Merrill Hall 2008\nAll rights reserved\n\n"+
				 "Visit http://www.ed2go.com/\nEducation To Go\nIntermediate Java Course";
	
	public static void main(String[] args){
		GUIPizza a = new GUIPizza();
		a.go();
	}

	public void go(){
		frame = new JFrame("GUI Menus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();
		
		makeMenus();
		makeContent();

		frame.pack();
		frame.setVisible(true);
	}

	public void makeContent(){
		contentPane = (JPanel)(frame.getContentPane());
		contentPane.setLayout(new BorderLayout(6,6));
		contentPane.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));

		makeNorthRegion();
		makeWestRegion();
		makeSouthRegion();
		makeEastRegion();
		makeCenterRegion();
	}

	public void makeNorthRegion(){
		JLabel pizzaImg = new JLabel( new ImageIcon("PizzaPicture.jpg") );
		contentPane.add(pizzaImg, BorderLayout.NORTH);
	}
	public void makeWestRegion(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
		crustButtonGroup = new ButtonGroup();

		regularCrustButton = new JRadioButton("Regular Crust",true);
		crustButtonGroup.add(regularCrustButton);
		panel.add(regularCrustButton);
		
		thinCrustButton = new JRadioButton("Thin Crust",false);
		crustButtonGroup.add(thinCrustButton);
		panel.add(thinCrustButton);

		handCrustButton = new JRadioButton("Hand-Tossed Crust",false);
		crustButtonGroup.add(handCrustButton);
		panel.add(handCrustButton);

		deepCrustButton = new JRadioButton("Deep-Dish Crust",false);
		crustButtonGroup.add(deepCrustButton);
		panel.add(deepCrustButton);

		contentPane.add(panel, BorderLayout.WEST);
		
		

	}
	public void makeCenterRegion(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Select Toppings"));
		pepperoniBox = new JCheckBox("Pepperoni",false);
		panel.add(pepperoniBox);
		sausageBox = new JCheckBox("Sausage",false);
		panel.add(sausageBox);
		cheeseBox = new JCheckBox("Extra Cheese",false);
		panel.add(cheeseBox);
		pepperBox = new JCheckBox("Bell Peppers",false);
		panel.add(pepperBox);
		onionBox = new JCheckBox("Onions",false);
		panel.add(onionBox);
		mushroomBox = new JCheckBox("Mushrooms",false);
		panel.add(mushroomBox);
		oliveBox = new JCheckBox("Olives",false);
		panel.add(oliveBox);
		anchovyBox = new JCheckBox("Anchovies",false);
		panel.add(anchovyBox);

		contentPane.add(panel, BorderLayout.CENTER);
	}
	public void makeSouthRegion(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Deliver To:"));

		JPanel smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
		smallPanel.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
		smallPanel.add(new JLabel("Name:"));
		smallPanel.add(new JLabel("Address:"));
		smallPanel.add(new JLabel("City,St,Zip:"));
		panel.add(smallPanel);
		
		smallPanel = new JPanel();
		smallPanel.setLayout(new GridLayout(0,1));
		smallPanel.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
		nameText = new JTextField();
		addressText = new JTextField();
		cityText = new JTextField();
		smallPanel.add(nameText);
		smallPanel.add(addressText);
		smallPanel.add(cityText);

		panel.add(smallPanel);


		contentPane.add(panel, BorderLayout.SOUTH);
	}
	public void makeEastRegion(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Sides (Enter Quantity)"));
		panel.setPreferredSize(new Dimension(150,0));

		JPanel smallPanel1 = new JPanel();
		smallPanel1.setLayout(new BoxLayout(smallPanel1,BoxLayout.X_AXIS));
		smallPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);

		breadSticksText = new JTextField("",2);
		breadSticksText.setMaximumSize(new Dimension(20,24));
		smallPanel1.add(breadSticksText);
		smallPanel1.add(new JLabel("Bread Sticks"));
		panel.add(smallPanel1);

		JPanel smallPanel2 = new JPanel();
		smallPanel2.setLayout(new BoxLayout(smallPanel2,BoxLayout.X_AXIS));
		smallPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);

		buffaloWingsText = new JTextField("",2);
		buffaloWingsText.setMaximumSize(new Dimension(20,24));
		smallPanel2.add(buffaloWingsText);
		smallPanel2.add(new JLabel("Buffalo Wings"));
		panel.add(smallPanel2);

		contentPane.add(panel, BorderLayout.EAST);

	}

	/**
	 * creates menu bar, menus, and menu items
	 */
	public void makeMenus(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu file = makeFileMenu();
		menuBar.add(file);

		JMenu help = makeHelpMenu();
		menuBar.add(help);
	}

	/**
	 * creates File menu and subsequent menu items
	 * @return File menu
	 */
	public JMenu makeFileMenu(){
		//File > New Order menu item
		JMenu file = new JMenu("File");
		JMenuItem newOrder = new JMenuItem("New Order");
		newOrder.setMnemonic(KeyEvent.VK_N);
		newOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, 
					                       Event.CTRL_MASK)
				);
		newOrder.addActionListener(new NewOrderListener());
		file.add(newOrder);

		//File > Save Order menu item
		JMenuItem saveOrder = new JMenuItem("Save Order");
		saveOrder.setMnemonic(KeyEvent.VK_S);
		saveOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					                        Event.CTRL_MASK)
				);
		saveOrder.addActionListener(new SaveOrderListener());
		file.add(saveOrder);

		file.addSeparator();

		//File > Exit menu Item
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_X);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					                   Event.CTRL_MASK));
		exit.setDisplayedMnemonicIndex(1);
		exit.addActionListener(new ExitListener());
		file.add(exit);
		
		return file;
	}

	/**
	 * creates Help menu and subsequent menu items
	 * @return Help menu
	 */
	public JMenu makeHelpMenu(){
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About GUI Pizza");
		about.setMnemonic(KeyEvent.VK_A);
		about.addActionListener(new AboutListener());
		help.add(about);

		return help;
	}

	//inner classes
	private class SaveOrderListener implements ActionListener{
		public void actionPerformed(ActionEvent e){}
	}//end inner class SaveOrderListener
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}//end inner class ExitListener
	private class AboutListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame,
					              aboutText,
						      "About GUI Pizza",
						      JOptionPane.INFORMATION_MESSAGE);
		}
	}//end inner Class AboutListener
	private class NewOrderListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			regularCrustButton.setSelected(true);

			pepperoniBox.setSelected(false);
			sausageBox.setSelected(false);
			cheeseBox.setSelected(false);
			pepperBox.setSelected(false);
			onionBox.setSelected(false);
			mushroomBox.setSelected(false);
			oliveBox.setSelected(false);
			anchovyBox.setSelected(false);	

			breadSticksText.setText("");
			buffaloWingsText.setText("");
			nameText.setText("");
			addressText.setText("");
			cityText.setText("");
		}
	}//end inner class NewOrderListener
}

