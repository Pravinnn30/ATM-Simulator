package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JLabel atmLabel,label1,label2;
    JTextField text1;
    JButton withdraw,back;
    String cardNo,pin,name;
    int balance;
    Withdrawal(String cardNo,String pin,int balance,String name){
        super("Withdraw");
        this.pin = pin;
        this.cardNo = cardNo;
        this.balance = balance;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,820,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmLabel = new JLabel(i3);
        atmLabel.setBounds(0,0,1540,820);

        label1 = new JLabel("<html>MAXIMUM LIMIT IS RS.10000.<br>Enter amount you want to Withdraw.</html>");
        label1.setBounds(400,170,450,80);
        label1.setFont(new Font("Raleway",Font.BOLD,25));
        label1.setForeground(Color.black);


        text1 = new JTextField();
        text1.setBounds(440,300,300,40);
        text1.setBackground(new Color(72, 90, 90, 255));
        text1.setFont(new Font("Raleway",Font.BOLD,20));
        text1.setForeground(Color.white);
        text1.setCaretColor(Color.white);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(670,444,150,29);
        withdraw.setBackground(new Color(72, 90, 90, 255));
        withdraw.setForeground(Color.white);
        withdraw.setFont(new Font("Raleway",Font.BOLD,16));
        withdraw.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(670,478,150,29);
        back.setBackground(new Color(72, 90, 90, 255));
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);

        atmLabel.add(label1);
//        atmLabel.add(label2);
        atmLabel.add(text1);
        atmLabel.add(withdraw);
        atmLabel.add(back);

        this.setBounds(0,0,1540,820);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WITHDRAWAL");
        this.setLayout(null);

        this.add(atmLabel);

        this.getContentPane().setBackground(new Color(222,225,228));
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amount = text1.getText();
            Date date = new Date();
            if(e.getSource() == withdraw){
                if(text1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter Amount.");
                    return;
                } else {
                    Con c = new Con();
//                    String q = "select * from bank where cardNo = '"+cardNo+"'pin'"+pin+"'";
//                    ResultSet resultSet = c.statement.executeQuery(q);
//                    int balance = 0;
//                    while (resultSet.next()){
//                        if(resultSet.getString("type").equals("Deposit")){
//                            balance += Integer.parseInt(resultSet.getString("amount"));
//                        } else {
//                            balance -= Integer.parseInt(resultSet.getString("amount"));
//                        }
//                    }
                    if(Integer.parseInt(amount) > 10000) {
                        JOptionPane.showMessageDialog(null,"MAXIMUM LIMIT IS 10000 RS ONLY.","ERROR",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"INSUFFICIENT BALANCE","ERROR",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('"+cardNo+"','"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"RS."+amount+ " SUCCESSFULLY WITHDRAWAL");
                }
                this.setVisible(false);
                new Main_Class(cardNo,pin,name);
            } else if(e.getSource() == back){
                this.setVisible(false);
                new Main_Class(cardNo,pin,name);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }
//
//    public static void main(String[] args) {
//        Withdrawal w = new Withdrawal("","",10000);
//    }
}
