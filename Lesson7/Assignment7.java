import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Assignment7{
	JFrame frame;
	
	public static void main(String[] args){
		Assignment7 a = new Assignment7();
		a.go();
	}

	public void go(){
		frame = new JFrame("GUI Menus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();
		
		makeMenus();

		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void makeMenus(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// File menu
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem menuItem;
		makeMenuItem(file, "New", new NewListener(),KeyEvent.VK_N, true);
		makeMenuItem(file, "Open", new OpenListener(),KeyEvent.VK_O,true);
		makeMenuItem(file, "Save", new SaveListener(),KeyEvent.VK_S,true);
		menuItem = makeMenuItem(file, "Save As", new SaveAsListener(),KeyEvent.VK_A,true);
		menuItem.setDisplayedMnemonicIndex(5);
		file.addSeparator();
		makeMenuItem(file, "Exit", new ExitListener(),KeyEvent.VK_E,false);

		// Edit Menu
		JMenu edit = new JMenu("Edit");
		menuBar.add(edit);

		makeMenuItem(edit,"Copy", new CopyListener(), KeyEvent.VK_C,true);



	}

	/**
	 * makes a menu item, adds an Actionlistener, a mnemonic, and if desired
	 * an accelerator masked by crtl
	 * @param parent parent component to add menu item to
	 * @param title String to set as text of menu item
	 * @param listener ActionListener to be added to menu item
	 * @param keyEvent key to be used to set Mnemonic
	 * @param setAccel if true use keyEvent to set accelerator else don't set accelerator at all
	 */

	public JMenuItem makeMenuItem(JMenu parent, String title, ActionListener listener,
			              int keyEvent, boolean setAccel){
		JMenuItem menuItem = new JMenuItem(title);
		menuItem.addActionListener(listener);
		menuItem.setMnemonic(keyEvent);
		if(setAccel){
			menuItem.setAccelerator(
					KeyStroke.getKeyStroke(keyEvent,
							       Event.CTRL_MASK)
					);
		}
		parent.add(menuItem);
		return menuItem;
	}

	private class NewListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame,
					"The File > New menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class OpenListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame,
					"The File > Open menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame,
					"The File > Save menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class SaveAsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame,
					"The File > Save As menu option was clicked",
					"Menu Item Click",
					JOptionPane.INFORMATION_MESSAGE);
		}
	} 
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	} 
	private class CopyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(frame,
					              "The Edit > Copy menu option was clicked",
						      "Menu Item Click",
						      JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

