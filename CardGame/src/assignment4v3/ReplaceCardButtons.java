/**
* The class creates the buttons to replace the cards on the table if the user wishes to
* @author Gokce Ozer
* 
*/

package assignment4v3;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;




public class ReplaceCardButtons {
	JPanel panel;
	ArrayList<Integer> cardsOnTable = new ArrayList<>(3);
	MyDrawPanel drawPanel;
	int replacements = 0;
	JButton button1;
	JButton button2;
	JButton button3;
	

	int[] digit3Cards = new int[] {110, 111, 112, 113, 210, 211, 212, 213, 310, 311, 312, 313, 410, 411, 412, 413};
	//constructor to create the replacement buttons
	public ReplaceCardButtons(JPanel panel, MyDrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		
		this.panel = panel;
		
		cardsOnTable.add(0);
		cardsOnTable.add(0);
		cardsOnTable.add(0);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1; // default value
		c.gridheight = 1; // default value
		c.weightx = 0.0; // default value
		c.weighty = 0.0; // default value
		c.anchor = GridBagConstraints.CENTER; // default value
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0); // default value
		c.ipadx = 0; // default value
		c.ipady = 0; // default value
		
		button1 = new JButton("Replace Card 1");
		button1.setPreferredSize(new Dimension(120, 40));
		c.gridx = 1; // 2nd column
		c.gridy = 10; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		button1.setEnabled(false);
		button1.addActionListener(new replaceCard1Listener(drawPanel));
		panel.add(button1, c);
		
		button2 = new JButton("Replace Card 2");
		button2.setPreferredSize(new Dimension(120, 40));
		c.gridx = 3; // 2nd column
		c.gridy = 10; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		button2.addActionListener(new replaceCard2Listener(drawPanel));
		button2.setEnabled(false);
		panel.add(button2, c);
		
		button3 = new JButton("Replace Card 3");
		button3.setPreferredSize(new Dimension(120, 40));
		c.gridx = 6; // 2nd column
		c.gridy = 10; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		button3.addActionListener(new replaceCard3Listener(drawPanel));
		button3.setEnabled(false);
		panel.add(button3, c);
	}
	
	//updates the card1 if user wishes to
	class replaceCard1Listener implements ActionListener{
		MyDrawPanel drawPanel;
		
		public replaceCard1Listener(MyDrawPanel drawPanel) {
			this.drawPanel = drawPanel;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result;
			do {
				/*int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+1))+min);
				if(decimals == 2) {
					
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					
					result = digit3Cards[(int) (Math.random()*15)];
				}*/

				
				
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10)
					result = (int) ((Math.random()*((49-11)))+11);
				else
					result = digit3Cards[(int) (Math.random()*15)];
				
			}while(cardsOnTable.contains(result) || result == 10 || result == 20 || result == 30 || result == 40 );
			cardsOnTable.set(0, result);
			
			String cardName = "card_" + Integer.toString(result) + ".gif";
			ImageIcon Image = new ImageIcon(cardName);
			drawPanel.setJLabel4(Image);
			replacements++;
			button1.setEnabled(false);
			if(replacements==2) {
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
			}
			
		}
		
	}
	//updates the card2 if user wishes to
	class replaceCard2Listener implements ActionListener{
		MyDrawPanel drawPanel;
		
		public replaceCard2Listener(MyDrawPanel drawPanel) {
			this.drawPanel = drawPanel;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result;
			do {
				/*int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+1))+min);
				if(decimals == 2) {
					
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					
					result = digit3Cards[(int) (Math.random()*15)];
				}*/
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10)
					result = (int) ((Math.random()*((49-11)))+11);
				else
					result = digit3Cards[(int) (Math.random()*15)];
				
			}while(cardsOnTable.contains(result) || result == 10 || result == 20 || result == 30 || result == 40 );
			cardsOnTable.set(1, result);
			
			String cardName = "card_" + Integer.toString(result) + ".gif";
			ImageIcon Image = new ImageIcon(cardName);
			drawPanel.setJLabel5(Image);
			replacements++;
			button2.setEnabled(false);
			if(replacements==2) {
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
			}
			
		}
		
	}
	//updates the card3 if user wishes to
	class replaceCard3Listener implements ActionListener{
		MyDrawPanel drawPanel;
		
		public replaceCard3Listener(MyDrawPanel drawPanel) {
			this.drawPanel = drawPanel;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result;
			do {
				/*int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+ 1))+min);
				if(decimals == 2) {
					
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					
					result = digit3Cards[(int) (Math.random()*15)];
				}*/
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10)
					result = (int) ((Math.random()*((49-11)))+11);
				else
					result = digit3Cards[(int) (Math.random()*15)];
				
			}while(cardsOnTable.contains(result) || result == 10 || result == 20 || result == 30 || result == 40 );
			cardsOnTable.set(2, result);
			
			String cardName = "card_" + Integer.toString(result) + ".gif";
			ImageIcon Image = new ImageIcon(cardName);
			drawPanel.setJLabel6(Image);
			replacements++;
			button3.setEnabled(false);
			if(replacements==2) {
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
			}
			
		}
		
	}

}
