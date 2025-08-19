package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel atmLabel,label1;

    JButton b1,b2,b3,b4,b5,b6,b7;
    String cardNo,pin,name;
    int balance;
    FastCash(String cardNo,String pin, int balance,String name){
        super("Transaction");
        this.pin = pin;
        this.cardNo = cardNo;
        this.balance = balance;
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

        b1 = new JButton("RS. 100");
        b1.setBounds(362,380,150,28);
        b1.setBackground(new Color(72, 90, 90, 255));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setFont(new Font("Raleway",Font.BOLD,18));

        b2 = new JButton("RS. 500");
        b2.setBounds(670,380,150,28);
        b2.setBackground(new Color(72, 90, 90, 255));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setFont(new Font("Raleway",Font.BOLD,18));

        b3 = new JButton("RS. 1000");
        b3.setBounds(362,413,150,28);
        b3.setBackground(new Color(72, 90, 90, 255));
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        b3.setFont(new Font("Raleway",Font.BOLD,18));

        b4 = new JButton("RS. 2000");
        b4.setBounds(670,413,150,28);
        b4.setBackground(new Color(72, 90, 90, 255));
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        b4.setFont(new Font("Raleway",Font.BOLD,18));

        b5 = new JButton("RS. 5000");
        b5.setBounds(362,446,150,28);
        b5.setBackground(new Color(72, 90, 90, 255));
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        b5.setFont(new Font("Raleway",Font.BOLD,18));

        b6 = new JButton("RS. 10000");
        b6.setBounds(670,446,150,28);
        b6.setBackground(new Color(72, 90, 90, 255));
        b6.setForeground(Color.white);
        b6.addActionListener(this);
        b6.setFont(new Font("Raleway",Font.BOLD,18));

        b7 = new JButton("EXIT");
        b7.setBounds(670,480,150,28);
        b7.setBackground(new Color(72, 90, 90, 255));
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        b7.setFont(new Font("Raleway",Font.BOLD,20));

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
        Date date = new Date();
        String rs = ((JButton)e.getSource()).getText().substring(4);
        //System.out.println(rs);
        try{
            if(e.getSource() == b7){
                new Main_Class(cardNo,pin,name);
                this.setVisible(false);
            } else {
                Con c = new Con();
            /*if(e.getSource() == b1){
                if(Integer.parseInt(b1.getText())<= balance){
                    balance -= Integer.parseInt(b1.getText());
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+b1.getText()+"')");
                    JOptionPane.showMessageDialog(null, "RS " + b1.getText() + " WITHDRAWAL SUCCESSFULLY");
                    new Main_Class(pin);
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if(e.getSource() == b2){
                if(Integer.parseInt(b2.getText())<= balance){
                    balance -= Integer.parseInt(b2.getText());
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+b2.getText()+"')");
                    JOptionPane.showMessageDialog(null, "RS " + b2.getText() + " WITHDRAWAL SUCCESSFULLY");
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if(e.getSource() == b3){
                if(Integer.parseInt(b3.getText())<= balance){
                    balance -= Integer.parseInt(b3.getText());
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+b3.getText()+"')");
                    JOptionPane.showMessageDialog(null, "RS " + b3.getText() + " WITHDRAWAL SUCCESSFULLY");

                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if(e.getSource() == b4){
                if(Integer.parseInt(b4.getText())<= balance){
                    balance -= Integer.parseInt(b4.getText());
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+b4.getText()+"')");
                    JOptionPane.showMessageDialog(null, "RS " + b4.getText() + " WITHDRAWAL SUCCESSFULLY");
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if(e.getSource() == b5){
                if(Integer.parseInt(b5.getText())<= balance){
                    balance -= Integer.parseInt(b5.getText());
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+b5.getText()+"')");
                    JOptionPane.showMessageDialog(null, "RS " + b5.getText() + " WITHDRAWAL SUCCESSFULLY");
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if(e.getSource() == b6){
                if(Integer.parseInt(b6.getText())<= balance){
                    balance -= Integer.parseInt(b6.getText());
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+b6.getText()+"')");
                    JOptionPane.showMessageDialog(null, "RS " + b6.getText() + " WITHDRAWAL SUCCESSFULLY");
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if(e.getSource() == b7){
                new Main_Class(pin);
            }*/

                if(Integer.parseInt(rs)<= balance){
                    balance -= Integer.parseInt(rs);
                    c.statement.executeUpdate("insert into bank values('"+cardNo+"','"+pin+"','"+date+"','Withdrawal','"+rs+"')");
                    JOptionPane.showMessageDialog(null, "RS " + rs + " WITHDRAWAL SUCCESSFULLY");
                    new Main_Class(cardNo,pin,name);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","Error",JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        FastCash f = new FastCash("","",10000);
//    }
}
