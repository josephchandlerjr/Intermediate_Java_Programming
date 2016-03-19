import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Maps 
{
	//labels
	private JLabel nameLabel;
	private JLabel numLabel;
	private JLabel positionLabel;
	private JLabel avgPtsLabel;
	private JLabel avgRbndsLabel;
	private JLabel avgAssistsLabel;
	// text fields
	private JTextField playerName;
	private JTextField playerNum;
	private JTextField playerPosition;
	private JTextField playerAvgPts;
	private JTextField playerAvgRbnds;
	private JTextField playerAvgAssists;
	//player tab components
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTabbedPane tabby;

	// window frame
	private JFrame frame;
	private JPanel contentPane;
	private TreeMap<Integer,Player> map;

	public static void main (String[] args) {
		Maps listGUI = new Maps();
		listGUI.start();
	}

	public void start() {
		frame = new JFrame("Maps");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = (JPanel)frame.getContentPane();

		makeMenus();
		makeContent();

		frame.pack();
		frame.setVisible(true);
	}
    
	private void makeMenus(){
		JMenuBar menuBar;

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// set up menus
		menuBar.add(makeFileMenu());
		menuBar.add(makeViewMenu());
		menuBar.add(makeHelpMenu());
	}

	private JMenu makeFileMenu(){
		JMenu menu;
		JMenuItem menuItem;

		// set up the File menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		// add Open menu item
		menuItem = new JMenuItem("Open...");
		menuItem.setMnemonic(KeyEvent.VK_O);
		menuItem.addActionListener(new OpenMenuItemListener());
		menuItem.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_O,
					       Event.CTRL_MASK));
		menu.add(menuItem);
		  
		// add Exit menu item
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_X);
		menuItem.addActionListener(new ExitMenuItemListener());
		menuItem.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_Q,
					       Event.CTRL_MASK));
		menu.add(menuItem);
		  
		return menu;
	}

	private JMenu makeViewMenu(){
		JMenu menu;
		JMenuItem menuItem;

		// set up the View menu
		menu = new JMenu("View");
		menu.setMnemonic(KeyEvent.VK_V);

		// add Next Player menu item
		menuItem = new JMenuItem("Next Player");
		menuItem.addActionListener(new NextMenuItemListener());
		menuItem.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,
				       Event.ALT_MASK));
		menu.add(menuItem);
		  
		// add Previous Player menu item
		menuItem = new JMenuItem("Previous Player");
		menuItem.addActionListener(new PrevMenuItemListener());
		menuItem.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_UP,
					Event.ALT_MASK));
		menu.add(menuItem);

		//add Search 
		menuItem = new JMenuItem("Search");
		menuItem.addActionListener(new SearchMenuItemListener());
		menuItem.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_S,
				        Event.CTRL_MASK));
		menu.add(menuItem);
		  
		// add Team View
		menu.addSeparator();
		menuItem = new JMenuItem("Team View");
		menuItem.addActionListener(new TeamMenuItemListener());
		menu.add(menuItem);
		  
		// add Player View
		menuItem = new JMenuItem("Player View");
		menuItem.addActionListener(new PlayMenuItemListener());
		menu.add(menuItem);
		  
		return menu;
	}

	private JMenu makeHelpMenu(){
		JMenu menu;
		JMenuItem menuItem;

		// set up the Help menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		// add About menu item
		menuItem = new JMenuItem("About Maps");
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.addActionListener(new AboutMenuItemListener());
		menu.add(menuItem);
		  
		return menu;
	}

	private void makeContent(){
		tabby = new JTabbedPane();
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
		nameLabel = new JLabel("Player Name:");
		nameLabel.setFont(new Font("Trebuchet MS",Font.BOLD + Font.ITALIC,14));
		panel.add(nameLabel);
		playerName = new JTextField();
		playerName.setFont(new Font("Trebuchet MS",Font.PLAIN,14));
		playerName.setForeground(Color.BLUE);
		panel.add(playerName);

		numLabel = new JLabel("Player Number:");
		numLabel.setFont(new Font("Trebuchet MS",Font.BOLD + Font.ITALIC, 14));
		panel.add(numLabel);
		playerNum = new JTextField();
		playerNum.setFont(new Font("Trebuchet MS",Font.PLAIN, 14));
		playerNum.setForeground(Color.BLUE);
		panel.add(playerNum);

		positionLabel = new JLabel("Position:");
		positionLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		panel.add(positionLabel);
		playerPosition = new JTextField();
		playerPosition.setFont(new Font("Trebuchet MS",Font.PLAIN,14));
		playerPosition.setForeground(Color.BLUE);
		panel.add(playerPosition);


		avgPtsLabel = new JLabel("Average Points Per Game:");
		avgPtsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		panel.add(avgPtsLabel);
		playerAvgPts = new JTextField();
		playerAvgPts.setFont(new Font("Trebuchet MS",Font.PLAIN,14));
		playerAvgPts.setForeground(Color.BLUE);
		panel.add(playerAvgPts);

		avgRbndsLabel = new JLabel("Average Rebounds Per Game:");
		avgRbndsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		panel.add(avgRbndsLabel);
		playerAvgRbnds = new JTextField();
		playerAvgRbnds.setFont(new Font("Trebuchet MS",Font.PLAIN,14));
		playerAvgRbnds.setForeground(Color.BLUE);
		panel.add(playerAvgRbnds);

		avgAssistsLabel = new JLabel("Average Assists Per Game:");
		avgAssistsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		panel.add(avgAssistsLabel);
		playerAvgAssists = new JTextField();
		playerAvgAssists.setFont(new Font("Trebuchet MS",Font.PLAIN,14));
		playerAvgAssists.setForeground(Color.BLUE);
		panel.add(playerAvgAssists);

		tabby.add("Player View", panel);
		tabby.setMnemonicAt(0,KeyEvent.VK_P);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));

		textArea = new JTextArea(15,25);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scrollPane);
		tabby.addTab("Team View", panel);
		tabby.setMnemonicAt(1, KeyEvent.VK_T);
		contentPane.add(tabby);
	}

	private class AboutMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame, 
				        "Maps\n\nVersion 1.0\nBuild B200803275-1720\n\n" +
					"(c) Copyright Merrill Hall 2008\nAll rights reserved\n\n" +
					"Visit /\nEducation To Go\n" +
					"Intermediate Java Course", 
				        "About Maps", 
			JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class OpenMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(frame);
			File playerFile = fc.getSelectedFile();
			if (playerFile == null)
				return;
			try{
			    Scanner scan = new Scanner(playerFile);
			    map = new TreeMap<Integer, Player>();
			    while (scan.hasNext()){
				String name = scan.next() + " " + scan.next();
				int nbr = scan.nextInt();
				char position = scan.next().charAt(0);
				double avgPoints = scan.nextDouble();
				double avgRebounds = scan.nextDouble();
				double avgAssists = scan.nextDouble();
				map.put(new Integer(nbr),
					new Player(name, nbr, position, avgPoints, avgRebounds, avgAssists));
			    }
			    scan.close();
			}catch(IOException e){
			    JOptionPane.showMessageDialog(  frame, 
							    "I/O error in file\n\n     " +
							    playerFile.getName() +
							    "\n\nThis program will close", 
							    "I/O Error", 
							    JOptionPane.ERROR_MESSAGE);
			    System.exit(1);
			}
			findPlayer();

			textArea.setText("");
			for( Player player : map.values())
				textArea.append(player.toString() + "\n\n");
		}
	}
	private void findPlayer(){
		boolean isGoodNumber = false;
		Integer playerNum = new Integer(0);
		while(!isGoodNumber){	
			try{
				playerNum = new Integer(Integer.parseInt(JOptionPane.showInputDialog(frame,
							    "Enter a Player's Number",
							    "Player Entry",
							    JOptionPane.QUESTION_MESSAGE)));
				isGoodNumber = true;
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(frame,
							      "That is not a valid number",
							      "Player number error",
							      JOptionPane.ERROR_MESSAGE);
			}
			Player p = map.get(playerNum);
			if(p == null){
				JOptionPane.showMessageDialog(frame,
						              "Player Number "+playerNum.intValue()+" not found",
							      "Player number error",
							      JOptionPane.ERROR_MESSAGE);
			}
			else{
				getPlayer(p);
			}
		}
	}
	private void getPlayer(Player p){
	    playerName.setText(p.getName());
	    playerNum.setText("" + p.getNum());
	    playerPosition.setText(p.getPosition());
	    playerAvgPts.setText("" + p.getAvgPoints());
	    playerAvgRbnds.setText("" + p.getAvgRebounds());
	    playerAvgAssists.setText("" + p.getAvgAssists());
	}

	private class ExitMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			    System.exit(0);
		}
	}

	private class NextMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(map == null || map.size() == 0)
				return;

			Map.Entry<Integer,Player> entry = map.higherEntry(
					                     Integer.parseInt(playerNum.getText()));
			if(entry == null){
				JOptionPane.showMessageDialog(frame,
						"There are no more players.\nYou have reached the end of the list",
						"End of List",
						JOptionPane.WARNING_MESSAGE);
			}
			else{
				Player p = entry.getValue();
				getPlayer(p);
			}
		}
	}    

	private class PrevMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(map == null || map.size() == 0)
				return;

			Map.Entry<Integer,Player> entry = map.lowerEntry(
					                     Integer.parseInt(playerNum.getText()));
			if(entry == null){
				JOptionPane.showMessageDialog(frame,
						"No more players\nYou have reached the start of the list",
						"End of List",
						JOptionPane.WARNING_MESSAGE);
			}
			else{
				Player p = entry.getValue();
				getPlayer(p);
			}
		}
	}

	private class PlayMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			tabby.setSelectedIndex(0);
		}
	}

	private class TeamMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			tabby.setSelectedIndex(1);
		}
	}
	private class SearchMenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(map == null || map.size() == 0){
				JOptionPane.showMessageDialog(frame,
							      "No Players to search",
							      "Empty Roster",
							      JOptionPane.WARNING_MESSAGE);
			}
			else{
				findPlayer();
			}
		}
	}

}
