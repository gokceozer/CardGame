/**
* The class creates the menu which includes a controller and a help sub-menu. Controller lets you quit
* and help menu display the rules for the game
* @author Gokce Ozer
* 
*/

package assignment4v3;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JTextArea;

public class Menu implements ActionListener {
	JTextArea text;
	
	//empty constructor, unnecessary but I like it
	public Menu() {
		
	}
	
	//create a menubar and add it to the frame. It also contains two sub menus: control and help
	public void menuBar(Frame frame) {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Control");
		JMenuItem menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(new ControllerListener(frame));
		menu.add(menuItem);
		menuBar.add(menu);

		JMenu menu1 = new JMenu("Help");
		JMenuItem menuItem1 = new JMenuItem("Rules");
		menuItem1.addActionListener(new HelpListener(frame));
		menu1.add(menuItem1);
		menuBar.add(menu1);

		frame.frame.setJMenuBar(menuBar);

	}
	//the control button exits the game
	public class ControllerListener implements ActionListener {
		Frame frame;

		public ControllerListener(Frame frame) {
			this.frame = frame;
		}
		//exits the game
		public void actionPerformed(ActionEvent event) {
			frame.frame.dispatchEvent(new WindowEvent(frame.frame, WindowEvent.WINDOW_CLOSING));
		}

	}
	//the help button shows the rules in a pop up box
	public class HelpListener implements ActionListener {
		JTextArea text;
		Frame frame;
		
		public HelpListener(Frame frame) {
			this.frame = frame;
			
		}
		
		//the pop up for rules
		public void actionPerformed(ActionEvent event) {
			//panel.setVisible(false);
			//text = new JTextArea();
			//text.setLineWrap(true);
			//text.append("Rules to determine who has better cards:\n" + "J, Q, K are regarded as special cards.\n"
			//		+ "Rule 1: The one with more special cards wins.\n"
			//		+ "Rule 2: If both have the same number of special cards, add the face values of the other\n"
			//		+ "card(s) and take the remainder after dividing the sum by 10. The one with a bigger\n"
			//		+ "remainder wins. (Note: Ace = 1).\n"
			//		+ "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.\n");
			//text.setEditable(false);
			//JScrollPane scroller = new JScrollPane(text);
			
			
			/*JButton button = new JButton("Close Rules");
			//button.addActionListener(new actionPerformed1);
			button.setPreferredSize(new Dimension(10, 50));
			// System.out.println("HELLO");
			button.setVisible(true);
			frame.frame.add(text);
			frame.frame.add(button, BorderLayout.SOUTH);
			frame.frame.add(scroller, BorderLayout.NORTH);
			frame.frame.setSize(600, 225);
			// frame.frame.setVisible(true);*/
			
			JFrame DialogFrame = new JFrame();
			JOptionPane.showMessageDialog(DialogFrame, "Rules to determine who has better cards:\n" + "J, Q, K are regarded as special cards.\n"
							+ "Rule 1: The one with more special cards wins.\n"
							+ "Rule 2: If both have the same number of special cards, add the face values of the other\n"
							+ "card(s) and take the remainder after dividing the sum by 10. The one with a bigger\n"
							+ "remainder wins. (Note: Ace = 1).\n"
							+ "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.\n", "Game Rules", JOptionPane.PLAIN_MESSAGE);
			

			}
			
		

		
	}	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
