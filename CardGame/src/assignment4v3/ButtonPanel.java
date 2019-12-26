/**
* Implementation of the sub-panel ButtonPanel
* Consists of creating the Start and Result buttons
* 
* Includes the actions when pressed to Start and Result buttons
* @author Gokce Ozer
* 
*/


package assignment4v3;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ButtonPanel {
	JPanel panel;
	ReplaceCardButtons replaceButtons;
	MyDrawPanel drawPanel;
	ArrayList<Integer> cardsOnTableComputer = new ArrayList<>(3);
	InfoPanel info;
	JTextArea text;
	
	//Constructor to create and add the 2 buttons and 1 label to the panel
	public ButtonPanel(JPanel panel, ReplaceCardButtons replaceButtons, MyDrawPanel drawPanel, InfoPanel info){
		this.panel = panel;
		this.replaceButtons = replaceButtons;
		this.drawPanel = drawPanel;
		this.info = info;
		
		cardsOnTableComputer.add(0, 0);
		cardsOnTableComputer.add(1, 0);
		cardsOnTableComputer.add(2, 0);
		
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
		
		JLabel label = new JLabel("Bet: $ ");
		c.gridx = 1; // 3rd column
		c.gridy = 1; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		panel.add(label, c);
		
		text = new JTextArea();
		text.setLineWrap(true);
		text.append("");
		text.setEditable(true);
		c.gridx = 3; // 3rd column
		c.gridy = 1; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		panel.add(text, c);
		
		JButton buttonS = new JButton("START");
		c.gridx = 11; // 2nd column
		c.gridy = 1; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		
		panel.add(buttonS, c);
		
		
		JButton buttonR = new JButton("RESULT");
		c.gridx = 13; // 3rd column
		c.gridy = 1; // 3rd row
		c.gridwidth = 2; // spans 2 columns
		c.weighty = 1.0; // takes up extra vertical space
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.ipady = 0;
		buttonR.setEnabled(false);
		buttonR.addActionListener(new resultButtonListener(drawPanel, buttonR, buttonS));
		panel.add(buttonR, c);
		
		buttonS.addActionListener(new startButtonListener(drawPanel, buttonR, buttonS));
		
		
	}
	
	//ActionListener class for the start button
	class startButtonListener implements ActionListener{
		MyDrawPanel drawPanel;
		JButton buttonR;
		JButton buttonS;
		public startButtonListener(MyDrawPanel drawPanel, JButton buttonR, JButton buttonS) {
			this.drawPanel = drawPanel;
			this.buttonR = buttonR;
			this.buttonS = buttonS;
		}
		//The unacceptable input warnings
		//The cards are distributed to the player
		@Override
		public void actionPerformed(ActionEvent e) {
			
				replaceButtons.button1.setEnabled(true);
				replaceButtons.button2.setEnabled(true);
				replaceButtons.button3.setEnabled(true);
				
				buttonR.setEnabled(true);
			
				if( text.getText().length() == 0) {
					JFrame DialogFrame = new JFrame();
					JOptionPane.showMessageDialog(DialogFrame, "You need to enter a value to bet");
					replaceButtons.button1.setEnabled(false);
					replaceButtons.button2.setEnabled(false);
					replaceButtons.button3.setEnabled(false);
					buttonR.setEnabled(false);
					return;
				}
				else if(Integer.parseInt(text.getText()) < 0  ){
					JFrame DialogFrame = new JFrame();
					JOptionPane.showMessageDialog(DialogFrame, "You can't bet less than 0");
					replaceButtons.button1.setEnabled(false);
					replaceButtons.button2.setEnabled(false);
					replaceButtons.button3.setEnabled(false);
					buttonR.setEnabled(false);
					return;
				}
				
				else if(info.currentTotal-Integer.parseInt(text.getText()) < 0){
					JFrame DialogFrame = new JFrame();
					JOptionPane.showMessageDialog(DialogFrame, "You don't have enough to bet this much");
					replaceButtons.button1.setEnabled(false);
					replaceButtons.button2.setEnabled(false);
					replaceButtons.button3.setEnabled(false);
					buttonR.setEnabled(false);
					return;
				}
				
				
			
			info.setCurrentBet(Integer.parseInt(text.getText()));
			
			
			ImageIcon Image = new ImageIcon("card_back.gif");
			drawPanel.myLabel1.setIcon(Image);
			drawPanel.myLabel2.setIcon(Image);
			drawPanel.myLabel3.setIcon(Image);
			
			
			int result=-1;
			do {
				
				
				
				
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10)
					result = (int) ((Math.random()*((49-11)))+11);
				else
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				
				/*int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+ 1))+min);
				if(decimals == 2) {
					
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}*/
				
			}while(replaceButtons.cardsOnTable.contains(result)  || result == 10 || result == 20 || result == 30 || result == 40 || result < 0  );
			replaceButtons.cardsOnTable.set(0, result);
			
			String cardName = "card_" + Integer.toString(result) + ".gif";
			Image = new ImageIcon(cardName);
			drawPanel.setJLabel4(Image);
			
		
			do {
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10)
					result = (int) ((Math.random()*((49-11)))+11);
				else
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				
				/*int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+ 1))+min);
				if(decimals == 2) {
					
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}*/
				
			}while(replaceButtons.cardsOnTable.contains(result)  || result == 10 || result == 20 || result == 30 || result == 40 || result < 0 );
			replaceButtons.cardsOnTable.set(1, result);
			
			cardName = "card_" + Integer.toString(result) + ".gif";
			Image = new ImageIcon(cardName);
			drawPanel.setJLabel5(Image);
			
			do {
				

				
				
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10)
					result = (int) ((Math.random()*((49-11)))+11);
				else
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				/*
				int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min + 1)))+min);
				if(decimals == 2) {
					
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}
				
				cardName = "card_" + Integer.toString(result) + ".gif";
				Image = new ImageIcon(cardName);
				drawPanel.setJLabel6(Image);*/
				
			}while(replaceButtons.cardsOnTable.contains(result)  || result == 10 || result == 20 || result == 30 || result == 40 || result < 0);
			replaceButtons.cardsOnTable.set(2, result);
			cardName = "card_" + Integer.toString(result) + ".gif";
			Image = new ImageIcon(cardName);
			drawPanel.setJLabel6(Image);
			
			
			
			
			
			buttonS.setEnabled(false);
		}
		
	}
	//Calculations of who wins the round
	//Also checks whether the player has enough money to keep playing
	class resultButtonListener implements ActionListener{
		MyDrawPanel drawPanel;
		JButton buttonR;
		JButton buttonS;
		public resultButtonListener(MyDrawPanel drawPanel, JButton buttonR, JButton buttonS) {
			 this.buttonR = buttonR;
			 this.drawPanel = drawPanel;
			 this.buttonS = buttonS;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			replaceButtons.button1.setEnabled(true);
			replaceButtons.button2.setEnabled(true);
			replaceButtons.button3.setEnabled(true);
			
			
			boolean faceCard = false;
			int numFaceCardsComputer = 0;
			
			int result=-1;
			do {
				

				
				
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10) {
					faceCard = false;
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					faceCard = true;
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}	
				/*int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+ 1))+min);
				System.out.println(decimals);
				if(decimals == 2) {
					faceCard = false;
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					faceCard = true;
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}*/
				
			}while(replaceButtons.cardsOnTable.contains(result)  || result == 10 || result == 20 || result == 30 || result == 40 || result < 0 || cardsOnTableComputer.contains(result) || result<0);
			cardsOnTableComputer.set(0, result);
			//System.out.println(result);
			if(faceCard == true && result%10 != 0)
				numFaceCardsComputer++;
			
			String cardName = "card_" + Integer.toString(result) + ".gif";
			ImageIcon Image = new ImageIcon(cardName);
			drawPanel.setJLabel1(Image);
		
			do {

				
				
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10) {
					faceCard = false;
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					faceCard = true;
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}	
				
				/*
				
				int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+ 1))+min);
				System.out.println(decimals);
				if(decimals == 2) {
					faceCard = false;
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					faceCard = true;
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}*/
				
			}while(replaceButtons.cardsOnTable.contains(result)  || result == 10 || result == 20 || result == 30 || result == 40 || result < 0 || cardsOnTableComputer.contains(result));
			//System.out.println(result);
			cardsOnTableComputer.set(1, result);
			if(faceCard == true && result%10 != 0)
				numFaceCardsComputer++;
			
			cardName = "card_" + Integer.toString(result) + ".gif";
			Image = new ImageIcon(cardName);
			drawPanel.setJLabel2(Image);
			
			do {
				

				
				
				int random = (int) ((Math.random()*((13-1)+ 1))+1);
				if(random <= 10) {
					faceCard = false;
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					faceCard = true;
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}	
				/*
				int max=3;
				int min=2;
				int decimals = (int) ((Math.random()*((max-min)+ 1))+min);
				System.out.println(decimals);
				if(decimals == 2) {
					faceCard = false;
					result = (int) ((Math.random()*((49-11)))+11);
				}else {
					faceCard = true;
					result = replaceButtons.digit3Cards[(int) (Math.random()*15)];
				}*/
				
			}while(replaceButtons.cardsOnTable.contains(result)  || result == 10 || result == 20 || result == 30 || result == 40 || result < 0  || cardsOnTableComputer.contains(result));
			cardsOnTableComputer.set(2, result);
			//System.out.println(result);
			if(faceCard == true && result%10 != 0)
				numFaceCardsComputer++;
			
			cardName = "card_" + Integer.toString(result) + ".gif";
			Image = new ImageIcon(cardName);
			drawPanel.setJLabel3(Image);
			
			
			int numFaceCardsPlayer = 0;
			
			for(int i=0; i<3; i++) {
				if(replaceButtons.cardsOnTable.get(i)>100 && replaceButtons.cardsOnTable.get(i)%10 != 0)
					numFaceCardsPlayer++;
			}
			//System.out.println("numFaceCardsPlayer " + numFaceCardsPlayer); 
			//System.out.println("numFaceCardsComputer" + numFaceCardsComputer);  
			if(numFaceCardsPlayer > numFaceCardsComputer) {
				JFrame DialogFrame = new JFrame();
				JOptionPane.showMessageDialog(DialogFrame, "Congradulations! You win this round.");
				info.currentTotal += Integer.parseInt(text.getText());
				text.setText("");
				info.setCurrentTotal(info.currentTotal);
				//System.out.println("numFaceCardsPlayer > numFaceCardsComputer  " + numFaceCardsPlayer + " > "+ numFaceCardsComputer);
			}else if(numFaceCardsPlayer < numFaceCardsComputer) {
				JFrame DialogFrame = new JFrame();
				JOptionPane.showMessageDialog(DialogFrame, "Dealer wins this round.");
				info.currentTotal -= Integer.parseInt(text.getText());
				text.setText("");
				info.setCurrentTotal(info.currentTotal);
				//System.out.println("numFaceCardsPlayer < numFaceCardsComputer  " + numFaceCardsPlayer + " < "+ numFaceCardsComputer);
			}else {
				int dealerSum=0;
				int playerSum=0;
				
				for(int i=0; i<3; i++) {
					if(replaceButtons.cardsOnTable.get(i)<100 || replaceButtons.cardsOnTable.get(i)%10 == 0) {
						if( replaceButtons.cardsOnTable.get(i)%10 == 0) {
							//System.out.println(replaceButtons.cardsOnTable.get(i));
							playerSum += 10;
					}else {
							playerSum += replaceButtons.cardsOnTable.get(i)%10;
						}
						//System.out.println(replaceButtons.cardsOnTable.get(i) + " --> " + replaceButtons.cardsOnTable.get(i)%10);
					}
				}	
				for(int i=0;i<3;i++) {
					if(cardsOnTableComputer.get(i)<100 || cardsOnTableComputer.get(i)%10 == 0) {
						if(cardsOnTableComputer.get(i)%10 == 0)
							dealerSum += 10;
						else {
							dealerSum += (cardsOnTableComputer.get(i)%10);
						}
						
						//System.out.println(cardsOnTableComputer.get(i) + " --> " + cardsOnTableComputer.get(i)%10);
					}
				
					
				}
				if(playerSum > dealerSum) {
					JFrame DialogFrame = new JFrame();
					JOptionPane.showMessageDialog(DialogFrame, "Congradulations! You win this round.");
					info.currentTotal += Integer.parseInt(text.getText());
					text.setText("");
					info.setCurrentTotal(info.currentTotal);
					//System.out.println("playerSum > dealerSum " + playerSum + " > "+ dealerSum);
				}else {
					JFrame DialogFrame = new JFrame();
					JOptionPane.showMessageDialog(DialogFrame, "Dealer wins this round.");
					info.currentTotal -= Integer.parseInt(text.getText());
					text.setText("");
					info.setCurrentTotal(info.currentTotal);
					//System.out.println("playerSum < dealerSum " + playerSum + " < "+ dealerSum);
				}
				
				
			}
			
			buttonR.setEnabled(false);
			buttonS.setEnabled(true);
			
			replaceButtons.replacements = 0;
			
			replaceButtons.button1.setEnabled(false);
			replaceButtons.button2.setEnabled(false);
			replaceButtons.button3.setEnabled(false);
			
			cardsOnTableComputer.set(0, 0);
			cardsOnTableComputer.set(1, 0);
			cardsOnTableComputer.set(2, 0);
			
			replaceButtons.cardsOnTable.set(0, 0);
			replaceButtons.cardsOnTable.set(1, 0);
			replaceButtons.cardsOnTable.set(2, 0);
			
			if((info.currentTotal)==0) {
				JFrame DialogFrame = new JFrame();
				JOptionPane.showMessageDialog(DialogFrame, " Game Over!\n You have no money left!\n Please start to a new game!");
				return;
			}
		}		
		
		
	}
	
	//To kill the warning
	public void killWarning() {
		
	}
	
}	
