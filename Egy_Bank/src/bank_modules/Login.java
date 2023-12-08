package bank_modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
	JButton login,clear,signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login()
	{
		setTitle("Atm machine");
		setLayout(null);
		ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logitem.png"));
		Image image2 = image1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon image3 = new ImageIcon(image2);
		JLabel label = new JLabel(image3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome to Egyptian ATM");
		text.setFont(new Font("Courier New",Font.BOLD,20));
		text.setBounds(200,40,400,40);
		add(text);
		
		
		//card number label
		JLabel cardnumber = new JLabel("Card Number: ");
		cardnumber.setFont(new Font("Courier New",Font.BOLD,20));
		cardnumber.setBounds(200,100,400,40);
		add(cardnumber);
		
		//card text field
		cardTextField = new JTextField();
		cardTextField.setBounds(350,100,250,30);
		cardTextField.setFont(new Font("Courier New",Font.BOLD,20));
		add(cardTextField);
		
		
		//pin number label
		JLabel pinNumber = new JLabel("Pin Number : ");
		pinNumber.setFont(new Font("Courier New",Font.BOLD,20));
		pinNumber.setBounds(200,150,400,40);
		add(pinNumber);
	
		//pin text field
		pinTextField = new JPasswordField();
		pinTextField.setBounds(350,150,250,30);
		pinTextField.setFont(new Font("Courier New",Font.BOLD,20));
		add(pinTextField);
	
		
		//add login button
		login = new JButton("Sign In");
		login.setBounds(350,200,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		//add clear button
		clear = new JButton("Clear");
		clear.setBounds(500,200,100,30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		//add signup button
		signup = new JButton("Sign Up");
		signup.setBounds(350,250,250,30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		getContentPane().setBackground(Color.WHITE);
		setSize(800,450);
		setVisible(true);
		setLocation(500,300);
	}
	
	 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(e.getSource()==login) {
			DbConnection c = new DbConnection();
			String Cardnumber = cardTextField.getText();
			String pinnumber  = pinTextField.getText();
			String query = "select * from login where cardnumber = '"+Cardnumber+"' and pin = '"+pinnumber+"'";
			
			try {
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
	
}



























