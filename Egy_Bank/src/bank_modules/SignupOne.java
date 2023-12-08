package bank_modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.*;

public class SignupOne extends JFrame implements ActionListener{
	long rand;
	JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
	JButton next;
	JRadioButton male,female,unmarried,married,other;
	JDateChooser dateChooser;
	public SignupOne() {
		setLayout(null);
		Random r = new Random();
		rand  = Math.abs((r.nextLong()%9000L)+1000L);
		
		//add form number label
		JLabel formNumber = new JLabel("APPLICATION FORM NUMBER. "+rand);
		formNumber.setFont(new Font("Courier New",Font.BOLD,25));
		formNumber.setBounds(190,20,600,40);
		add(formNumber);
		
		
		//add personal details
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
	    personalDetails.setFont(new Font("Courier New",Font.BOLD,22));
		personalDetails.setBounds(250,80,500,30);
		add(personalDetails);
		
		//add first name
		JLabel firstName = new JLabel("Name:");
	    firstName.setFont(new Font("Courier New",Font.BOLD,20));
		firstName.setBounds(100,140,100,30);
		add(firstName);
		
		//text field for name
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Courier New",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		//add father name
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Courier New",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		
		// text field for father name
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Courier New", Font.BOLD, 14));
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		
		
		//add birth date
		JLabel birthDate = new JLabel("Date of Birth:");
		birthDate.setFont(new Font("Courier New",Font.BOLD,20));
		birthDate.setBounds(100,240,200,30);
		add(birthDate);
		
		//add choose date
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105,105,105));
		add(dateChooser);
		
		//add gender
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Courier New",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		//add radio button for male
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		//add radio button for female
		female = new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		//add two button for button group to relate to each other
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(female);
		genderGroup.add(male);
		
		
		//add email
		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Courier New",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		//add email address text field
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Courier New", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		
		//add status
		JLabel martial = new JLabel("Martial Status:");
		martial.setFont(new Font("Courier New",Font.BOLD,20));
		martial.setBounds(100,390,200,30);
		add(martial);
		
		//add married button
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		//add unmarried button
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		//add other button
		other = new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		
		//add three status buttons
		ButtonGroup martialGroup = new ButtonGroup();
		martialGroup.add(married);
		martialGroup.add(unmarried);
		martialGroup.add(other);
		
		//add address
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Courier New",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		// add  address text field
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Courier New", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		
		//add city
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Courier New",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		//add city text field
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Courier New", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		
		//add state
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Courier New",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		//add state text field
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Courier New", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		//add pin code
		JLabel pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Courier New",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		//add pin code text field
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Courier New", Font.BOLD, 14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);
		
		
		
		//add next button
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Courier New",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setVisible(true);
		setLocation(350,10);
	}
	public void actionPerformed(ActionEvent e) {
		String formno = ""+rand;
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dateofbirth = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender ="Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}
		else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}
		else if(other.isSelected()) {
			marital = "Other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else {
				DbConnection c = new DbConnection();
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dateofbirth+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new SignupOne();
	}
}



























