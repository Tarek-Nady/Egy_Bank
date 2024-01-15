package bank_modules;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class representing the Balance Enquiry module in a banking application.
 * This class extends JFrame and implements ActionListener for handling GUI events.
 */
public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back; // Button for returning to the previous screen
    String pinnumber; // User's PIN number

    /**
     * Constructor to create the Balance Enquiry GUI.
     * @param pinnumber The user's PIN number used for identifying the account.
     */
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        
        // Setting the layout to null for absolute positioning
        setLayout(null);

        // Setting up the background image
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel image = new JLabel(l3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        // Creating and setting up the 'Back' button
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        // Database connection to retrieve account balance
        DbConnection c = new DbConnection();
        int balance = 0;
        try {
            // Querying the database for transactions
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                // Calculating the balance based on deposits and withdrawals
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                } 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Displaying the balance
        JLabel text = new JLabel("Your Current Account balance is " + balance + " EGP");
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 30);
        image.add(text);
        
        // Setting frame properties
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    /**
     * Method to handle action events.
     * @param e The ActionEvent object
     */
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    // Main method for launching the balance enquiry screen
    public static void main(String[] args) {
        new BalanceEnquiry(""); 
    }
}
