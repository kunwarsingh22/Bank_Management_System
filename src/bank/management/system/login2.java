package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login2 extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField Jtextfield1;
    JPasswordField pass;
    JButton b1, b2, b3;

    login2() {
        super("MY TEST");

        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);*/

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 38));
        label1.setBounds(230, 50, 450, 40);
        add(label1);

        label2 = new JLabel("Name: ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 28));
        label2.setBounds(230, 120, 200, 40);
        add(label2);

        Jtextfield1 = new JTextField();
        Jtextfield1.setBounds(400, 120, 250, 40);
        add(Jtextfield1);

        label3 = new JLabel("Password: ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("System", Font.BOLD, 28));
        label3.setBounds(230, 190, 200, 40);
        add(label3);

        pass = new JPasswordField();
        pass.setBounds(400, 190, 250, 40);
        add(pass);

        b1 = new JButton("SIGN IN");
        b1.setBounds(300, 260, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CLEAR");
        b2.setBounds(420, 260, 100, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("SIGN UP");
        b3.setBounds(300, 310, 220, 30);
        b3.addActionListener(this);
        add(b3);

        setSize(900, 500);
        setLocation(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                Con c = new Con();

                String cardno = Jtextfield1.getText();   // Name / Card Number
                String pin = pass.getText();             // Password

                String q = "select * from login where card_number='" + cardno + "' and pin='" + pin + "'";
                ResultSet rs = c.statement.executeQuery(q);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    setVisible(false);
                    //new main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Credential");
                }



            } else if (e.getSource() == b2) {
                setVisible(false);

            } else if (e.getSource() == b3) {
                //new Signup();
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new login2();
    }
}
