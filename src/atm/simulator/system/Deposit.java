package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JLabel atmLabel,label1;
    JTextField text1;
    JButton deposit,back;
    String cardNo,pin,name;
    
    Deposit(String cardNo,String pin,String name){
        super("Deposit");
        this.cardNo = cardNo;
        this.pin = pin;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ATM3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,820,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        atmLabel = new JLabel(i3);
        atmLabel.setBounds(0,0,1540,820);

        label1 = new JLabel("Enter amount you want to deposit.");
        label1.setBounds(400,170,410,80);
        label1.setFont(new Font("Raleway",Font.BOLD,25));
        label1.setForeground(Color.black);


        text1 = new JTextField();
        text1.setBounds(440,300,300,40);
        text1.setBackground(new Color(72, 90, 90, 255));
        text1.setFont(new Font("Raleway",Font.BOLD,20));
        text1.setForeground(Color.white);
        text1.setCaretColor(Color.white);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(670,444,150,29);
        deposit.setBackground(new Color(72, 90, 90, 255));
        deposit.setForeground(Color.white);
        deposit.setFont(new Font("Raleway",Font.BOLD,16));
        deposit.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(670,478,150,29);
        back.setBackground(new Color(72, 90, 90, 255));
        back.setForeground(Color.white);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);

        atmLabel.add(label1);
        atmLabel.add(text1);
        atmLabel.add(deposit);
        atmLabel.add(back);

        this.setBounds(0,0,1540,820);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Deposit");
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
            if(e.getSource() == deposit){
                if(text1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Enter Amount.");
                } else {
                    Con c = new Con();
                    c.statement.executeUpdate("insert into bank values('"+cardNo+"','"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. " +amount +" Deposited Successfully.");
                    setVisible(false);
                    new Main_Class(cardNo,pin,name);
                }
            } else if(e.getSource() == back){
                setVisible(false);
                new Main_Class(cardNo,pin,name);
            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Deposit d = new Deposit("");
//    }
}
