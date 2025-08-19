package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Main_Class extends JFrame implements ActionListener {
    JLabel atmLabel,label1;

    JButton b1,b2,b3,b4,b5,b6,b7;
    String cardNo,pin,name;
    int balance = 0;
    Main_Class(String cardNo,String pin,String name){
        super("Transaction");
        this.cardNo = cardNo;
        this.pin = pin;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,820,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmLabel = new JLabel(i3);
        atmLabel.setBounds(0,0,1540,820);

        label1 = new JLabel("Please Select Your Transaction.");
        label1.setBounds(380,170,480,80);
        label1.setFont(new Font("Raleway",Font.BOLD,30));
        label1.setForeground(new Color(0x333333));

        b1 = new JButton("DEPOSIT");
        b1.setBounds(362,380,150,28);
        b1.setBackground(new Color(72, 90, 90, 255));
        b1.setForeground(Color.white);
        b1.setFont(new Font("Raleway",Font.BOLD,12));
        b1.addActionListener(this);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setBounds(670,380,150,28);
        b2.setBackground(new Color(72, 90, 90, 255));
        b2.setForeground(Color.white);
        b2.setFont(new Font("Raleway",Font.BOLD,12));
        b2.addActionListener(this);

        b3 = new JButton("FAST CASH");
        b3.setBounds(362,413,150,28);
        b3.setBackground(new Color(72, 90, 90, 255));
        b3.setForeground(Color.white);
        b3.setFont(new Font("Raleway",Font.BOLD,12));
        b3.addActionListener(this);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(670,413,150,28);
        b4.setBackground(new Color(72, 90, 90, 255));
        b4.setForeground(Color.white);
        b4.setFont(new Font("Raleway",Font.BOLD,12));
        b4.addActionListener(this);

        b5 = new JButton("CHANGE PIN");
        b5.setBounds(362,446,150,28);
        b5.setBackground(new Color(72, 90, 90, 255));
        b5.setForeground(Color.white);
        b5.setFont(new Font("Raleway",Font.BOLD,12));
        b5.addActionListener(this);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(670,446,150,28);
        b6.setBackground(new Color(72, 90, 90, 255));
        b6.setForeground(Color.white);
        b6.setFont(new Font("Raleway",Font.BOLD,12));
        b6.addActionListener(this);

        b7 = new JButton("EXIT");
        b7.setBounds(670,480,150,28);
        b7.setBackground(new Color(72, 90, 90, 255));
        b7.setForeground(Color.white);
        b7.setFont(new Font("Raleway",Font.BOLD,16));
        b7.addActionListener(this);

        atmLabel.add(label1);

        this.setBounds(0,0,1540,820);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(atmLabel);

        this.getContentPane().setBackground(new Color(222,225,228));
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        try {
//            Con c = new Con();
//            String q = "select * from cardNo where pin = '"+cardNo+"'";
//            ResultSet resultSet = c.statement.executeQuery(q);
//
//        } catch (Exception E){
//            E.printStackTrace();
//        }
        try {
            Con c = new Con();
            String q = "select * from bank where cardNo = '"+cardNo+"'";
            ResultSet resultSet = c.statement.executeQuery(q);
            while (resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception E){
            E.printStackTrace();
        }

        if(e.getSource() == b1){
            new Deposit(cardNo,pin,name);
            this.setVisible(false);
        } else if(e.getSource() == b2){
            new Withdrawal(cardNo,pin,balance,name);
            this.setVisible(false);
        } else if(e.getSource() == b3){
            new FastCash(cardNo,pin,balance,name);
            this.setVisible(false);
        } else if(e.getSource() == b4){
            new MiniStatement(cardNo,pin,balance,name);
            //this.setVisible(false);
        } else if(e.getSource() == b5){
            new Pin(cardNo,pin,name);
            this.setVisible(false);
        } else if(e.getSource() == b6){
//            System.out.println(balance);
            new BalanceEnquiry(cardNo,pin,name);
            this.setVisible(false);
        } else if(e.getSource() == b7){
            System.exit(0);
        }
    }

//    public static void main(String[] args) {
//        Main_Class m = new Main_Class("","");
//    }

}