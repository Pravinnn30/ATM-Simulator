package atm.simulator.system;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
    JLabel label,imgLabel1,page,accDetail,accTypeT,cardNoT,pinT,servicesT,XNoT,XPinT,digitPassT,digitCardNumberT,digitCardRT;
    JButton backButton,submit,cancel;
    JRadioButton savAcc,fixAcc,curAcc,recAcc;
    JCheckBox atm,intBank,mobBank,emailAlert,chequeBook,e_state,term;
    String formNo,name;

    SignUp3(String formNon,String name){
        super("APPLICATION FORM");
        //this.formNo = formNo;
        this.name = name;
        this.formNo = formNon;
        page = new JLabel("Page No. 3");
        page.setBounds(250,50,100,30);
        page.setFont(new Font("Raleway",Font.BOLD,18));

        label = new JLabel("Form No. " + formNo);
        label.setBounds(520,10,200,30);
        label.setFont(new Font("Raleway",Font.BOLD,12));

        accDetail = new JLabel("Addition Details");
        accDetail.setBounds(250,80,250,30);
        accDetail.setFont(new Font("Raleway",Font.BOLD,24));

        accTypeT = new JLabel("Account Type:");
        accTypeT.setBounds(100,145,150,30);
        accTypeT.setFont(new Font("",Font.BOLD,16));

        savAcc = new JRadioButton("Saving Account");
        savAcc.setFont(new Font("Raleway",Font.BOLD,14));
        savAcc.setBounds(120,180,150,25);
        savAcc.setBackground(new Color(222,225,228));

        fixAcc = new JRadioButton("Fixed Account");
        fixAcc.setFont(new Font("Raleway",Font.BOLD,14));
        fixAcc.setBounds(300,180,150,25);
        fixAcc.setBackground(new Color(222,225,228));

        curAcc = new JRadioButton("Current Account");
        curAcc.setFont(new Font("Raleway",Font.BOLD,14));
        curAcc.setBounds(120,210,150,25);
        curAcc.setBackground(new Color(222,225,228));

        recAcc = new JRadioButton("Recurring Account");
        recAcc.setFont(new Font("Raleway",Font.BOLD,14));
        recAcc.setBounds(300,210,180,25);
        recAcc.setBackground(new Color(222,225,228));

        ButtonGroup group1 = new ButtonGroup();
        group1.add(savAcc);
        group1.add(fixAcc);
        group1.add(curAcc);
        group1.add(recAcc);

        cardNoT = new JLabel("Card Number:");
        cardNoT.setBounds(100,250,150,30);
        cardNoT.setFont(new Font("",Font.BOLD,18));
        cardNoT.setBounds(100,250,150,30);

        XNoT = new JLabel("XXXX-XXXX-XXXX-9999");
        XNoT.setFont(new Font("Railway",Font.PLAIN,16));

        XNoT.setBounds(280,250,300,20);

        digitCardRT = new JLabel("(It would appear on atm card/cheque Book and statements)");
        digitCardRT.setFont(new Font("Railway",Font.PLAIN,10));
        digitCardRT.setBounds(280,270,300,20);

        digitCardNumberT = new JLabel("(Your 16-digit Card Number)");
        digitCardNumberT.setFont(new Font("Railway",Font.PLAIN,10));
        digitCardNumberT.setBounds(100,270,150,30);

        pinT = new JLabel("pinT:");
        pinT.setBounds(100,300,150,30);
        pinT.setFont(new Font("",Font.BOLD,18));

        XPinT = new JLabel("XXXX");
        XPinT.setFont(new Font("Railway",Font.PLAIN,16));
        XPinT.setBounds(280,300,150,30);

        digitPassT = new JLabel("(4-digit Password)");
        digitPassT.setFont(new Font("Railway",Font.PLAIN,10));
        digitPassT.setBounds(100,320,150,30);

        servicesT = new JLabel("services Required:");
        servicesT.setBounds(100,360,200,30);
        servicesT.setFont(new Font("",Font.BOLD,18));

        atm = new JCheckBox("ATM Card");
        atm.setBounds(120,390,150,25);
        atm.setFont(new Font("Raleway",Font.PLAIN,14));
        atm.setBackground(new Color(222,225,228));
//        atm.

        intBank = new JCheckBox("Internet Banking");
        intBank.setBounds(380,390,150,25);
        intBank.setFont(new Font("Raleway",Font.PLAIN,14));
        intBank.setBackground(new Color(222,225,228));
//        intBank.

        mobBank = new JCheckBox("Mobile Banking");
        mobBank.setBounds(120,420,150,25);
        mobBank.setFont(new Font("Raleway",Font.PLAIN,14));
        mobBank.setBackground(new Color(222,225,228));
//        mobBank.

        emailAlert = new JCheckBox("Email Alert");
        emailAlert.setBounds(380,420,150,25);
        emailAlert.setFont(new Font("Raleway",Font.PLAIN,14));
        emailAlert.setBackground(new Color(222,225,228));
//        emailAlert.

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(120,450,150,25);
        chequeBook.setFont(new Font("Raleway",Font.PLAIN,14));
        chequeBook.setBackground(new Color(222,225,228));
//        chequeBook.

        e_state = new JCheckBox("E-Statement");
        e_state.setBounds(380,450,150,25);
        e_state.setFont(new Font("Raleway",Font.PLAIN,14));
        e_state.setBackground(new Color(222,225,228));
//        e_state.

        term = new JCheckBox("I hereby declares that the above entered details correct to the best of my Knowledge");
        term.setBounds(120,490,450,30);
        term.setFont(new Font("Raleway",Font.PLAIN,10));
        term.setBackground(new Color(222,225,228));
        term.setSelected(true);
//        term.

        submit = new JButton("Submit");
        submit.setBounds(200,520,100,30);
        submit.setFont(new Font("Raleway",Font.PLAIN,12));
        submit.setBorder(new EtchedBorder());
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBounds(400,520,100,30);
        cancel.setFont(new Font("Raleway",Font.PLAIN,12));
        cancel.setBorder(new EtchedBorder());
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/backImg.png"));
        Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        backButton = new JButton(i3);
        backButton.setBounds(7,7,30,30);
        backButton.setBackground(new Color(222,225,228));
        backButton.addActionListener(this);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/image1.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        imgLabel1 = new JLabel(ii3);
        imgLabel1.setBounds(80,30,100,100);

        this.add(label);
        this.add(accDetail);
        this.add(page);
        this.add(accTypeT);
        this.add(cardNoT);
        this.add(pinT);
        this.add(savAcc);
        this.add(fixAcc);
        this.add(curAcc);
        this.add(recAcc);
        this.add(XNoT);
        this.add(digitCardNumberT);
        this.add(digitCardRT);
        this.add(XPinT);
        this.add(digitPassT);
        this.add(servicesT);

        this.add(atm);
        this.add(intBank);
        this.add(mobBank);
        this.add(emailAlert);
        this.add(chequeBook);
        this.add(chequeBook);
        this.add(e_state);
        this.add(term);

        this.add(submit);
        this.add(cancel);

        this.setBounds(20,10,700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.add(imgLabel1);
        this.add(backButton);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(222,225,228));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accType = "";
        if(fixAcc.isSelected()){
            accType = fixAcc.getText();
        } else if(savAcc.isSelected()){
            accType = savAcc.getText();
        } else if(curAcc.isSelected()){
            accType = curAcc.getText();
        } else if(recAcc.isSelected()) {
            accType = recAcc.getText();
        }
        StringBuilder servicesReq = new StringBuilder();
        if(atm.isSelected())
            servicesReq.append(atm.getText()).append(",");
        if(intBank.isSelected())
            servicesReq.append(intBank.getText()).append(",");
        if(mobBank.isSelected())
            servicesReq.append(mobBank.getText()).append(",");
        if(emailAlert.isSelected())
            servicesReq.append(emailAlert.getText()).append(",");
        if(chequeBook.isSelected())
            servicesReq.append(chequeBook.getText()).append(",");
        if(e_state.isSelected())
            servicesReq.append(e_state.getText()).append(",");

        Random ran = new Random();
        long first1 = 1100000000000000L + (ran.nextLong() % 100000000L);
        String cardNo = "" + first1;

        long first2 = 110000L + (ran.nextLong() % 10000L);
        String pin = "" + first2;

        try {
            if (e.getSource() == submit) {
                if (accType.isEmpty() || !term.isSelected()) {
                    if (accType.isEmpty())
                        JOptionPane.showMessageDialog(null, "Please fill the fields.");
                    else
                        JOptionPane.showMessageDialog(null, "Please accept the term & conditions.");
                } else {
                    Con c = new Con();
                    String q1 = "insert into signupthree values('"+formNo+"','"+cardNo+"','"+accType+"','"+pin+"','"+servicesReq+"')";
                    String q2 = "insert into login values('"+formNo+"','"+name+"','"+cardNo+"','"+pin+"')";
                    c.statement.executeUpdate(q1);
                    c.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Card number is:" + cardNo + "\nPin is:" + pin);
                    new Deposit(cardNo,pin,name);
                    this.setVisible(false);
                }
            } else if (e.getSource() == cancel) {
                Con c = new Con();
                String q1 = "DELETE FROM signUp WHERE formNo = '" + formNo + "'";
                String q2 = "DELETE FROM signUpTwo WHERE formNo = '" + formNo + "'";
//                String q = "DELETE FROM signUpTwo WHERE formNo = '" + formNo + "'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                System.exit(0);
            } else {
                // if we want to delete data from database
//                Con c = new Con();
//                String q = "DELETE FROM signUpTwo WHERE formNo = '" + formNo + "'";
//                c.statement.executeUpdate(q);
                this.setVisible(false);
                SignUp2 prev2 = new SignUp2(formNo,name,"",1);

            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }
//
//    public static void main(String[] args) {
//        SignUp3 s = new SignUp3(" 3455","Sonu");
//    }
}
