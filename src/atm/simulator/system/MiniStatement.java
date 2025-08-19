package atm.simulator.system;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class MiniStatement extends JFrame implements ActionListener {
    String cardNo,pin,name;
    int balance;

    JTextPane label2;
    JLabel label,label0,label1,label3,label4;
    JButton button;
    MiniStatement(String cardNo,String pin,int balance,String name){
        super("Statement");
        this.cardNo = cardNo;
        this.pin = pin;
        this.balance = balance;
        this.name = name;

        label = new JLabel();
        label.setBounds(0,0,450,600);
        label.setBackground(new Color(225, 205, 220));
        label.setOpaque(true);

        label0 = new JLabel(name);
        label0.setBounds(75,30,150,20);
        label0.setBackground(new Color(225, 205, 220));
        label0.setFont(new Font("Raleway",Font.BOLD,16));
        label0.setOpaque(true);

        label1 = new JLabel();
        label1.setBounds(75,50,250,40);
        label1.setBackground(new Color(225, 205, 220));
        label1.setFont(new Font("Raleway",Font.BOLD,16));
        label1.setOpaque(true);

        label2 = new JTextPane();
        label2.setLocation(30,160);
//        label2.setBounds(30,110,400,300);
        label2.setSize(400,300);
        label2.setBackground(new Color(225, 205, 220));
        label2.setBackground(new Color(225, 205, 20));
        label2.setFont(new Font("Raleway",Font.BOLD,11));
        label2.setOpaque(true);

        label3 = new JLabel("Your balance is: " + balance + " RS.");
        label3.setBounds(40,460,350,30);
        label3.setBackground(new Color(225, 205, 220));
        label3.setFont(new Font("Raleway",Font.BOLD,16));
        label3.setOpaque(true);

        label4 = new JLabel("Your last ten transition History is here.");
        label4.setBounds(40,95,250,40);
        label4.setBackground(new Color(225, 205, 220));
        label4.setFont(new Font("Raleway",Font.BOLD,14));
        label4.setOpaque(true);

        button = new JButton("BACK");
        button.setBounds(30,510,100,30);
        button.setBorder(new EtchedBorder());
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(new Font("Raleway",Font.BOLD,20));
        button.addActionListener(this);
        try{
            Con con = new Con();
            ResultSet resultSet = con.statement.executeQuery("select * from bank where cardNo='"+cardNo+"'");

            while(resultSet.next()){
                label1.setText("Card No. " +resultSet.getString("cardNo").substring(0,4) + "XXXXXXXX" + resultSet.getString("cardNo").substring(12));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            Con c = new Con();
            String q = "SELECT * FROM bank WHERE cardNo = '" + cardNo + "' ORDER BY date DESC LIMIT 10";
            ResultSet resultSet = c.statement.executeQuery(q);

            ArrayList<String> last10 = new ArrayList<>();
            balance = 0;

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");

                String entry = date + "   " + type + "   " + amount + "\n\n";
                last10.add(entry);

                if ("Deposit".equals(type)) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

// Optional: reverse to show oldest first
            Collections.reverse(last10);

            StringBuilder history = new StringBuilder();
            for (String entry : last10) {
                history.append(entry);
            }
            label2.setText(history.toString());
            label2.setText(history.toString());

            /*while (resultSet.next()){

                if(resultSet.getString("type").equals("Deposit")) {
                    label2.setText(label2.getText() + "<html>" + resultSet.getString("date") + "&nbsp; &nbsp; &nbsp; &nbsp;" + resultSet.getString("type") + " " + "&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;" + resultSet.getString("amount") + "<br>  <br><html>");
                } else {
                    label2.setText(label2.getText() + "<html>" + resultSet.getString("date") + "&nbsp; &nbsp; &nbsp; &nbsp;" + resultSet.getString("type") + "&nbsp; &nbsp; &nbsp; " + resultSet.getString("amount") + " <br> <br> <html>");

                }
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }*/


        } catch (Exception e){
            e.printStackTrace();
        }

        label.add(label0);
        label.add(label1);
        label.add(label2);
        label.add(label3);
        label.add(label4);
        label.add(button);

        JScrollPane scrollPane = new JScrollPane(label2);
        scrollPane.setBounds(40, 140, 380, 300); // adjust size
        add(scrollPane);

        this.add(label);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10,10,450,600);
        this.setTitle("Transaction History");
        this.setLayout(null);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
//            new Main_Class(cardNo,pin,name);
            this.setVisible(false);
        }
    }

//    public static void main(String[] args) {
//        MiniStatement m = new MiniStatement("1100000004597247","1234",8500,"Sonu");
//    }
}
