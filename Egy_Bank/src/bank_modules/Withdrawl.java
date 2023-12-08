package bank_modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	Withdrawl(String pinnumber) {
		this.pinnumber = pinnumber;
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Courier New",Font.BOLD,15));
		text.setBounds(170,300,350,20);
		image.add(text);
		
		
		amount = new JTextField();
		amount.setFont(new Font("Courier New",Font.BOLD,16));
		amount.setBounds(170,350,320,30);
		image.add(amount);
		
		
		withdraw = new JButton("withdraw");
		withdraw.setBounds(360,490,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw	);
		
		back = new JButton("Back");
		back.setBounds(150,490,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
			String number = amount.getText();
			Date date  = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
			}
			else {
				try {
				   DbConnection conn  = new DbConnection();
				   String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
				   conn.s.executeUpdate(query);
				   JOptionPane.showMessageDialog(null, number+" EGP "+" Withdraw Successfully");
				   setVisible(false);
				   new Transactions(pinnumber).setVisible(true);
				}catch (Exception ex) {
					System.out.println(ex);
				}
			}
			
		}else if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	
	
	public static void main(String[] args) {
		new Withdrawl("");
	}
 

	
	

}
