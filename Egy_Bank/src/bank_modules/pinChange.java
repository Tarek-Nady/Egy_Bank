package bank_modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class pinChange extends JFrame implements ActionListener{
	JPasswordField pin,repin;
	JButton change,back;
	
	String pinnumber;
	pinChange(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Courier New",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pintext = new JLabel("NEW PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("Courier New",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Courier New",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("Courier New",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		image.add(repintext);
		
		
		repin = new JPasswordField();
		repin.setFont(new Font("Courier New",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		

		back = new JButton("BACK");
		back.setBounds(160,485,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();

				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered PIN not match");
					return;
				}
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter PIN ");
					return;
				}
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-enter new PIN ");
					return;
				}
				DbConnection c = new DbConnection();
				String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'"; 
				String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'"; 
				String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'"; 
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				
				JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
				setVisible(false);
				new Transactions(rpin).setVisible(true);
				
			} catch (SQLException e2) {
		        JOptionPane.showMessageDialog(null, "An error occurred: " + e2.getMessage());
		        e2.printStackTrace();
		    }
		} else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	
	public static void main(String[] args) {
		new pinChange("");
	}

	
}








