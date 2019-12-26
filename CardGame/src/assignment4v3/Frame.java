/**

* Frame class where I created the frame, main panel and the sub-panels
* @author Gokce Ozer
* 
*/

package assignment4v3;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Frame {
	
	JFrame frame;
	
	//Method to initialize the setup
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Create the MainPanel and the SubPanels
		JPanel MainPanel = new JPanel();
		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		
		//Set Background of the panels
		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green);
		ButtonPanel.setBackground(Color.DARK_GRAY);
		InfoPanel.setBackground(Color.DARK_GRAY);
		
		//Add the SubPanel into MainPanel
		MainPanel.setLayout(new GridLayout(5,1));
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		
		
		
		
		
		//InfoPanel create Information
		InfoPanel info = new InfoPanel(InfoPanel);
		
		//Initialize cards
		MyDrawPanel drawPanel = new MyDrawPanel(DealerPanel, PlayerPanel);
		
		//RpCardBtnPanel create Buttons
		ReplaceCardButtons replaceButtons = new ReplaceCardButtons(RpCardBtnPanel, drawPanel);
		
		
		//ButtonPanel create Buttons and JText
		ButtonPanel buttonPanelCreate = new ButtonPanel(ButtonPanel, replaceButtons, drawPanel, info);
		buttonPanelCreate.killWarning();
		
		//Create the menu
		Menu menu = new Menu();
		menu.menuBar(this);
		
		
		//Finalize the frame
		frame.getContentPane().add(MainPanel);
		frame.setTitle("A Simple Card Game");
		frame.setSize(400, 700);
		frame.setVisible(true);
	}

}
