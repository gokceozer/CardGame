/**
* This class initializes the cards on the table
* It is also used to update the cards on the table
* @author Gokce Ozer
* 
*/
package assignment4v3;
import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

	/**
	 * 
	 */
	//added id to kill a warning
	private static final long serialVersionUID = 1L;
	/*
	 * public void paintComponent(Graphics g) {
	 * 
	 * g.setColor(Color.ORANGE); g.fillRect(20, 50, 100, 70);
	 * 
	 * }
	 */
	String name;
	JPanel panel1;
	JPanel panel2;
	
	JLabel myLabel1;
	JLabel myLabel2;
	JLabel myLabel3;
	JLabel myLabel4;
	JLabel myLabel5;
	JLabel myLabel6;
	
	//constructor to initialize the cards on table
	public MyDrawPanel(JPanel panel1, JPanel panel2) {
		//this.name = name;
		this.panel1 = panel1;
		this.panel2 = panel2;
		
		ImageIcon Image = new ImageIcon("card_back.gif");
		this.myLabel1 = new JLabel(Image);
		
		Image = new ImageIcon("card_back.gif");
		this.myLabel2 = new JLabel(Image);
		
		Image = new ImageIcon("card_back.gif");
		this.myLabel3 = new JLabel(Image);
		
		Image = new ImageIcon("card_back.gif");
		this.myLabel4 = new JLabel(Image);
		
		Image = new ImageIcon("card_back.gif");
		this.myLabel5 = new JLabel(Image);
		
		Image = new ImageIcon("card_back.gif");
		this.myLabel6 = new JLabel(Image);
		
		panel1.add(myLabel1);
		panel1.add(myLabel2);
		panel1.add(myLabel3);
		panel2.add(myLabel4);
		panel2.add(myLabel5);
		panel2.add(myLabel6);
	}

	//Never called
	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("Replacing with card: " + name);
		//Image image = new ImageIcon(name).getImage();
		//g.drawImage(image, 3, 4, this);
	}
	//Following methods update the card images
	public void setJLabel1(ImageIcon image) {
		myLabel1.setIcon(image);
	}
	
	public void setJLabel2(ImageIcon image) {
		myLabel2.setIcon(image);
	}
	
	public void setJLabel3(ImageIcon image) {
		myLabel3.setIcon(image);
	}
	
	public void setJLabel4(ImageIcon image) {
		myLabel4.setIcon(image);
	}
	
	public void setJLabel5(ImageIcon image) {
		myLabel5.setIcon(image);
	}
	
	public void setJLabel6(ImageIcon image) {
		myLabel6.setIcon(image);
	}

	
	

}