package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String cardNo,pin;

    JLabel atmLabel,label1,label2;
    JButton back;
    int balance;

    String name;
    BalanceEnquiry(String cardNo,String pin,String name){
        super("Balance Enquiry");
        this.pin = pin;
        this.cardNo = cardNo;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,820,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmLabel = new JLabel(i3);
        atmLabel.setBounds(0,0,1540,820);

        label1 = new JLabel("BALANCE");
        label1.setBounds(370,295,150,40);
        label1.setForeground(new Color(0xF5F5F5));
        label1.setFont(new Font("Raleway",Font.BOLD,30));

        try {
            Con c = new Con();
            String q1 = "select * from bank where cardNo = '"+cardNo+"'";
            ResultSet resultSet1 = c.statement.executeQuery(q1);

            balance = 0;
            while (resultSet1.next()){
                if(resultSet1.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet1.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet1.getString("amount"));
                }
            }

        } catch (Exception E){
            E.printStackTrace();
        }

        label2 = new JLabel(" "+balance+" RS ONLY.");
        label2.setBounds(400,370,400,40);
        label2.setForeground(new Color(0x3b5ba5));
        label2.setFont(new Font("Raleway",Font.BOLD,30));

        back = new JButton("BACK");
        back.setBounds(670,478,150,29);
        back.setBackground(new Color(72, 90, 90, 255));
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);

        atmLabel.add(label1);
        atmLabel.add(label2);

        this.setBounds(0,0,1540,820);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Balance Enquiry");
        this.setLayout(null);

        this.add(atmLabel);
        this.add(back);
        this.getContentPane().setBackground(new Color(222,225,228));
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Main_Class(cardNo,pin,name);
        this.setVisible(false);
    }

//    public static void main(String[] args) {
//        BalanceEnquiry b = new BalanceEnquiry("","");
//
//    }
}
