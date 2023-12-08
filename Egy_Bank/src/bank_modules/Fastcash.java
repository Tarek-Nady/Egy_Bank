package bank_modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fastcash extends JFrame implements ActionListener{
	JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
	
	String pinnumber;
	public Fastcash(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon l3 = new ImageIcon(l2);
		JLabel image = new JLabel(l3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(200,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Courier New",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("100 EGP");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		
		withdrawl = new JButton("500 EGP");
		withdrawl.setBounds(355,415,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("1000 EGP");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		
		ministatement = new JButton("2000 EGP");
		ministatement.setBounds(355,450,150,30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		

		pinchange = new JButton("5000 EGP");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("10000 EGP");
		balanceenquiry.setBounds(355,485,150,30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		
		exit = new JButton("Back");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}else {
			
			String amount = ((JButton)e.getSource()).getText();
			int len = amount.length();
			amount = amount.substring(0,len-4);
			DbConnection conn = new DbConnection();
			try {
				ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					} 
				}
				if(e.getSource()!=exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "insufficent Balance");
					return;
				}
				Date date = new Date();
				String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, amount+" EGP "+" Debited Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} 
		
	}
	
	public static void main(String[] args) {
		new Fastcash("");
	}
	 

}
