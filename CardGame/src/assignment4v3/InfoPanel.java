/**
* The class initializes and updates the information panel, how much the player bet and how much is left in total
* @author Gokce Ozer
* 
*/
package assignment4v3;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel {
	JPanel panel;
	int currentBet = 0;
	int currentTotal = 100;
	JLabel label;
	
	//creates label to keep the bet and total
	public InfoPanel(JPanel panel) {
		this.panel = panel;
		
		label = new JLabel("Your current bet is: $" + currentBet + ". Amount of money you have: $" + currentTotal);
		
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
		
		c.gridx = 1; // 3rd column
		c.gridy = 14; // 3rd row
		c.gridwidth = 30; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		panel.add(label, c);
	}
	
	//update the current bet
	public void setCurrentBet(int bet) {
		label.setText("Your current bet is: $" + bet + ". Amount of money you have: $" + currentTotal);
		currentBet=bet;
	}
	//update the current total
	public void setCurrentTotal(int total) {
		label.setText("Your current bet is: $" + currentBet + ". Amount of money you have: $" + total);
		currentTotal=total;
	}

}
