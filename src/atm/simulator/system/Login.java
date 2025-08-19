package atm.simulator.system;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JLabel label,label1,textLabel1,textLabel2;
    TextField textField;
    JPasswordField passwordField;
    JButton signIn,clear,signup;
    String name;
    public Login(){
        super("ATM Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(20,10,700,600);

        label = new JLabel();
        label.setBounds(0,0,700,500);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/image1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label1 = new JLabel(i3);
        label1.setBounds(300,20,100,100);

        textLabel1 = new JLabel("CARD NO.");
        textLabel1.setBounds(80,150,100,30);
        textLabel1.setFont(new Font("Arial",Font.BOLD,20));

        textLabel2 = new JLabel("PIN");
        textLabel2.setBounds(80,200,100,30);
        textLabel2.setFont(new Font("Arial",Font.BOLD,20));

        textField = new TextField();
        textField.setBounds(220,150,300,30);
        textField.setFont(new Font("Arial",Font.PLAIN,20));

        passwordField = new JPasswordField();
        passwordField.setBounds(220,200,300,30);
        passwordField.setFont(new Font("Arial",Font.PLAIN,20));

        signIn = new JButton("SIGN IN");
        signIn.setBounds(250, 280,100,50);
        signIn.setForeground(Color.white);
        signIn.setBackground(Color.black);
        signIn.setBorder(new EtchedBorder());
        signIn.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setBounds(380, 280,100,50);
        clear.setForeground(Color.white);
        clear.setBackground(Color.black);
        clear.setBorder(new EtchedBorder());
        clear.addActionListener(this);

        signup = new JButton("SIGN UP");
        signup.setBounds(250, 350,230,50);
        signup.setForeground(Color.white);
        signup.setBackground(Color.black);
        signup.setBorder(new EtchedBorder());
        signup.addActionListener(this);

        this.setLayout(null);
        this.add(textField);
        this.add(signIn);
        this.add(clear);
        this.add(signup);
        this.add(passwordField);
        this.add(textLabel1);
        this.add(textLabel2);
        this.add(label1);
        this.add(label);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cardNo;
        try{
            if (e.getSource() == signIn) {
                if (textField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter the Card Number.");
                } else if (Arrays.toString(passwordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter the PIN.");
                } else {

                    Con c3 = new Con();
                    cardNo = textField.getText();
                    char[] pass = passwordField.getPassword();
                    String pin = new String(pass);

                    String q = "select * from login where cardNo = '"+cardNo+"' and pin = '"+pin+"'";
                    ResultSet resultSet = c3.statement.executeQuery(q);
                    if(resultSet.next()){
                        try{
//                            Con c = new Con();
//                            String q1 = "select * from login where cardNo = '"+cardNo+"' ";
                            name = resultSet.getString("name");
                        } catch (Exception E){
                            E.printStackTrace();
                        }
                        this.setVisible(false);
                        new Main_Class(cardNo,pin,name);
                    } else {
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                    }
                }
            } else if (e.getSource() == clear) {
                textField.setText("");
                passwordField.setText("");
            } else {
                new SignUp1(0);
                this.setVisible(false);
            }
        } catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        //Main_Class m = new Main_Class(pin);
    }
}
