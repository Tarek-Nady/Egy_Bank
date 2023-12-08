package bank_modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
	JTextField pan,aadhar;
	JButton next;
	JRadioButton cyes, cno, syes, sno;
	JDateChooser dateChooser;
	JComboBox religionbtn,categorybtn,occupationbtn,educationbtn,incomebtn;
	String formno;
	public SignupTwo(String formno){
		this.formno = formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		//add additional details
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Courier New",Font.BOLD,22));
		additionalDetails.setBounds(250,80,500,30);
		add(additionalDetails);
		
		//add religion
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Courier New",Font.BOLD,19));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		//choose your religion
		String valreligion[]  = {"Muslim","Christian","sikh","other"};
		religionbtn = new JComboBox(valreligion);
		religionbtn.setBounds(300,140,400,30);
		add(religionbtn);
		
		
		//add category
		JLabel category = new JLabel("Category:");
		category .setFont(new Font("Courier New",Font.BOLD,20));
		category .setBounds(100,190,200,30);
		add(category);
		
		
		//choose your category
		
		String valcategory[] = {"General","OBC","SC","ST","Other"};
		categorybtn = new JComboBox(valcategory);
		categorybtn.setBounds(300,190,400,30);
		categorybtn.setBackground(Color.WHITE);
		add(categorybtn);
		
		
		
		//add birth date
		JLabel income = new JLabel("Income:");
		income.setFont(new Font("Courier New",Font.BOLD,20));
		income.setBounds(100,240,200,30);
		add(income);
		
		
		//choose income
		String incomecategory[] = {"Null","< 1,50,000","< 2,50,000","5,00,0000","Upto 10,00,000"};
		incomebtn = new JComboBox(incomecategory);
		incomebtn.setBounds(300,240,400,30);
		incomebtn.setBackground(Color.WHITE);
		add(incomebtn);
		
		
		//add education
		JLabel education = new JLabel("Educational ");
		education.setFont(new Font("Courier New",Font.BOLD,20));
		education.setBounds(100,290,200,30);
		add(education);	
		
		//add qualification
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Courier New",Font.BOLD,20));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		//add your qualification
		String educatiovalues[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        educationbtn = new JComboBox(educatiovalues);
		educationbtn.setBounds(300,315,400,30);
		educationbtn.setBackground(Color.WHITE);
		add(educationbtn);
		
		
		//add Occupation
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Courier New",Font.BOLD,20));
		occupation.setBounds(100,390,200,30);
		add(occupation);
		
		//choose occupation
		String occupationvalues[] = {"Salaried","Self-Employed","Bussines","Student","Retired","Others"};
		occupationbtn = new JComboBox(occupationvalues);
		occupationbtn.setBounds(300,390,400,30);
		occupationbtn.setBackground(Color.WHITE);
		add(occupationbtn);
		
		//add panNumber
		JLabel panNumber = new JLabel("PAN Number:");
		panNumber.setFont(new Font("Courier New",Font.BOLD,20));
		panNumber.setBounds(100,440,200,30);
		add(panNumber);
		
		// add  address text field
		pan = new JTextField();
		pan.setFont(new Font("Courier New", Font.BOLD, 14));
		pan.setBounds(300, 440, 400, 30);
		add(pan);
		
		
		//add adharnumber
		JLabel adharnumber = new JLabel("Aadhar NUmber:");
		adharnumber.setFont(new Font("Courier New",Font.BOLD,20));
		adharnumber.setBounds(100,490,200,30);
		add(adharnumber);
		
		//add aadhar text field
		aadhar = new JTextField();
		aadhar.setFont(new Font("Courier New", Font.BOLD, 14));
		aadhar.setBounds(300, 490, 400, 30);
		add(aadhar);
		
		
		//add senior
		JLabel senior = new JLabel("Senior Citizen:");
		senior.setFont(new Font("Courier New",Font.BOLD,20));
		senior.setBounds(100,540,200,30);
		add(senior);
		
		 
		syes = new JRadioButton("Yes");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		
		ButtonGroup seniorgroup = new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		
		//add exsitAccount
		JLabel exsitAccount = new JLabel("Exsiting Account:");
		exsitAccount.setFont(new Font("Courier New",Font.BOLD,19));
		exsitAccount.setBounds(100,590,200,30);
		add(exsitAccount);
		
		
		cyes = new JRadioButton("Yes");
		cyes.setBounds(300,590,100,30);
		cyes.setBackground(Color.WHITE);
		add(cyes);
		
		cno = new JRadioButton("No");
		cno.setBounds(450,590,100,30);
		cno.setBackground(Color.WHITE);
		add(cno);
		
		
		ButtonGroup exsitgroup = new ButtonGroup();
		exsitgroup.add(cyes);
		exsitgroup.add(cno);
		
		
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
		String religion   = (String)religionbtn.getSelectedItem();
		String category   = (String)categorybtn.getSelectedItem();
		String income     = (String)incomebtn.getSelectedItem();
		String education  = (String)educationbtn.getSelectedItem();
		String occupation = (String)occupationbtn.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "Yes";
		} else if (sno.isSelected()) {
			seniorcitizen = "No";
		}
 
		
		String exsitaccount = null;
		if (cyes.isSelected()) {
			exsitaccount = "Yes";
		} else if (cno.isSelected()) {
			exsitaccount = "No";
		}

		String span = pan.getText();
		String saadhar = aadhar.getText();

		try {
			 
		DbConnection c = new DbConnection();
		String query = "insert into signuptwo values('"+formno+"','" + religion + "','" + category + "','"
						+ income + "','" + education + "','" + occupation + "','" + span + "','" + saadhar + "','"
						+ seniorcitizen + "','" + exsitaccount + "')";
		c.s.executeUpdate(query);
		setVisible(false);
		new SignupThree(formno).setVisible(true);
		}
		catch (Exception e1) {
			System.out.println(e1.getMessage());
		}

	}

	public static void main(String[] args) {
		new SignupTwo("");
	}
}