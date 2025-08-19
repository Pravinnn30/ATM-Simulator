package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pin extends JFrame implements ActionListener {
    JLabel atmLabel,label1,label2,label3;
    JPasswordField text1,text2;
    JButton changePin,back;
    String cardNo,pin,name;

    Pin(String cardNo,String pin,String name){
        super("Change PIN");
        this.pin = pin;
        this.cardNo = cardNo;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,820,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmLabel = new JLabel(i3);
        atmLabel.setBounds(0,0,1540,820);

        label1 = new JLabel("Change PIN");
        label1.setBounds(500,170,150,80);
        label1.setFont(new Font("Raleway",Font.BOLD,25));
        label1.setForeground(Color.black);

        label2 = new JLabel("Enter New PIN:");
        label2.setBounds(380,340,150,30);
        label2.setFont(new Font("Raleway",Font.BOLD,16));
        label2.setForeground(Color.black);

        label3 = new JLabel("Re-Enter New PIN:");
        label3.setBounds(380,380,150,30);
        label3.setFont(new Font("Raleway",Font.BOLD,16));
        label3.setForeground(Color.black);

        text1 = new JPasswordField();
        text1.setBounds(550,340,150,30);
        text1.setBackground(new Color(0xb58));
        text1.setFont(new Font("Raleway",Font.BOLD,20));
        text1.setForeground(Color.white);
        text1.setCaretColor(Color.white);

        text2 = new JPasswordField();
        text2.setBounds(550,380,150,30);
        text2.setBackground(new Color(0xb58));
        text2.setFont(new Font("Raleway",Font.BOLD,20));
        text2.setForeground(Color.white);
        text2.setCaretColor(Color.white);


        changePin = new JButton("CHANGE PIN");
        changePin.setBounds(670,444,150,29);
        changePin.setBackground(new Color(72, 90, 90, 255));
        changePin.setForeground(Color.white);
        changePin.setFont(new Font("Raleway",Font.BOLD,16));
        changePin.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(670,478,150,29);
        back.setBackground(new Color(72, 90, 90, 255));
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);

        atmLabel.add(label1);
        atmLabel.add(label2);
        atmLabel.add(label3);
        atmLabel.add(text1);
        atmLabel.add(text2);
        atmLabel.add(changePin);
        atmLabel.add(back);

        this.setBounds(0,0,1540,820);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Change PIN");
        this.setLayout(null);

        this.add(atmLabel);

        this.getContentPane().setBackground(new Color(222,225,228));
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            char[] pass1 = text1.getPassword();
            String newPin = new String(pass1);
            char[] pass2 = text2.getPassword();
            String str2 = new String(pass2);

            if (!newPin.equals(str2)) {
                JOptionPane.showMessageDialog(null, "ENTERED PINS DO NOT MATCH.");
                return;
            }

            if (e.getSource() == changePin) {

                if (newPin.isEmpty() || str2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLEASE FILL BOTH PIN FIELDS.");
                    return;
                }

                try {
                    Con c = new Con();
                    System.out.println(pin);
                    System.out.println(newPin);
//                     Check if current PIN exists
                    String q = "SELECT * FROM bank WHERE cardNo = '" + cardNo + "' AND pin = '" + pin + "'";

                    ResultSet resultSet = c.statement.executeQuery(q);

                    if(resultSet.next()) {
                        String q1 = "UPDATE bank SET pin = '" + newPin + "' WHERE cardNo = '" + cardNo + "' AND pin = '" + pin + "'";
                        String q2 = "UPDATE login SET pin = '" + newPin + "' WHERE cardNo = '" + cardNo + "' AND pin = '" + pin + "'";
                        String q3 = "UPDATE signupthree SET pin = '" + newPin + "' WHERE cardNo = '" + cardNo + "' AND pin = '" + pin + "'";

                        c.statement.executeUpdate(q1);
                        c.statement.executeUpdate(q2);
                        c.statement.executeUpdate(q3);

                        JOptionPane.showMessageDialog(null, "PIN changed successfully");
                        new Main_Class(cardNo,newPin,name);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            } else {
                new Main_Class(cardNo,pin,name);
                this.setVisible(false);

            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }


//    public static void main(String[] args) {
//        Pin p = new Pin("");
//    }
}
