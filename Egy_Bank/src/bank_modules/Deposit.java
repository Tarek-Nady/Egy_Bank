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

/**
 * Class representing the Deposit module in a banking application.
 * This class extends JFrame and implements ActionListener for handling GUI events.
 */
public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount; // Text field for inputting deposit amount
    JButton deposit, back; // Buttons for deposit and back actions
    String pinnumber; // User's PIN number

    /**
     * Constructor to create the Deposit GUI.
     * @param pinnumber The user's PIN number used for identifying the account.
     */
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        // Setting up the background image
        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel image = new JLabel(l3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        // Label for deposit instructions
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Courier New", Font.BOLD, 15));
        text.setBounds(170, 300, 350, 20);
        image.add(text);
        
        // Text field for entering deposit amount
        amount = new JTextField();
        amount.setFont(new Font("Courier New", Font.BOLD, 16));
        amount.setBounds(170, 350, 320, 30);
        image.add(amount);
        
        // Creating and setting up the 'Deposit' button
        deposit = new JButton("Deposit");
        deposit.setBounds(360, 490, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        // Creating and setting up the 'Back' button
        back = new JButton("Back");
        back.setBounds(150, 490, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        // Setting frame properties
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    /**
     * Method to handle action events.
     * @param e The ActionEvent object
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            // Handling deposit action
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            } else {
                // Database operation for deposit
                try {
                   DbConnection conn = new DbConnection();
                   String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Deposit', '" + number + "')";
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, number + " EGP " + " Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == back) {
            // Handling back action
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
// Main method for launching the depositscreen
public static void main(String[] args) {
new Deposit("");
}
}
