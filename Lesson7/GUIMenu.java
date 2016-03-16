import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUIMenu{
	JFrame frame;
	
	public static void main(String[] args){
		GUIMenu gm = new GUIMenu();
		gm.go();
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

		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem mi;
		mi = makeMenuItem(file, "New", new NewListener());
		mi.setMnemonic(KeyEvent.VK_N);
		mi = makeMenuItem(file, "Open", new OpenListener());
		mi.setMnemonic(KeyEvent.VK_O);
		mi = makeMenuItem(file, "Save", new SaveListener());
		mi.setMnemonic(KeyEvent.VK_S);
		mi.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S,
					               Event.CTRL_MASK)
				);
		mi = makeMenuItem(file, "Save As", new SaveAsListener());
		mi.setMnemonic(KeyEvent.VK_A);
		mi.setDisplayedMnemonicIndex(5);
		file.addSeparator();
		mi = makeMenuItem(file, "Exit", new ExitListener());
		mi.setMnemonic(KeyEvent.VK_E);

	}

	public JMenuItem makeMenuItem(JMenu menu, String title, ActionListener listener){
		JMenuItem mi = new JMenuItem(title);
		mi.addActionListener(listener);
		menu.add(mi);
		return mi;
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
}
