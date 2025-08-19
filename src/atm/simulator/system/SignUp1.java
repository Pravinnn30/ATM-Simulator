package atm.simulator.system;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Random;

public class SignUp1 extends JFrame implements ActionListener {
    JLabel imgLabel1,label1,labelPage,labelPer,nameL,fatherName,gender,dateOfBirth,emailAdd,maritalStatus,address,city,pinCode,state,sec;
    Random ran = new Random();
    long first4 = (ran.nextLong()%9000L) + 1000L;
    String first = " " + Math.abs(first4);
    JTextField nameT,fatherNameT,dateOfBirthT,emailAddT,addressT,cityT,pinCodeT,stateT;
    JRadioButton male,female,other,married,unmarried,otherM;
    JButton button,backButton;
    String name,formNo,prevFormNo;
    int count;

    public SignUp1(int count){

        super("APPLICATION FORM");
        this.count = count;
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
        imgLabel1.setBounds(70,30,100,100);

        label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(180,10,550,80);
        label1.setFont(new Font("Raleway",Font.BOLD,32));

        labelPage = new JLabel("Page No.1");
        labelPage.setBounds(300,90,130,30);
        labelPage.setFont(new Font("Raleway",Font.BOLD,18));

        labelPer = new JLabel("Personal Details");
        labelPer.setBounds(300,110,150,30);
        labelPer.setFont(new Font("Raleway",Font.BOLD,18));

        nameL = new JLabel("Name");
        nameL.setBounds(70,170,130,30);
        nameL.setFont(new Font("Raleway",Font.BOLD,15));

        nameT = new JTextField();
        nameT.setBounds(240,170,350,25);
        nameT.setFont(new Font("Raleway",Font.PLAIN,15));

        fatherName = new JLabel("Father's Name:");
        fatherName.setBounds(70,200,130,30);
        fatherName.setFont(new Font("Raleway",Font.BOLD,15));

        fatherNameT  = new JTextField();
        fatherNameT.setBounds(240,200,350,25);
        fatherNameT.setFont(new Font("Raleway",Font.PLAIN,15));

        gender = new JLabel("Gender");
        gender.setBounds(70,230,130,30);
        gender.setFont(new Font("Raleway",Font.BOLD,15));

        male = new JRadioButton("Male");
        male.setBounds(240,230,60,25);
        male.setBackground(new Color(222,225,228));

        female = new JRadioButton("Female");
        female.setBounds(380,230,80,25);
        female.setBackground(new Color(222,225,228));

        other = new JRadioButton("Other");
        other.setBounds(530,230,60,25);
        other.setBackground(new Color(222,225,228));

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        dateOfBirth = new JLabel("Date Of Birth:");
        dateOfBirth.setBounds(70,260,130,30);
        dateOfBirth.setFont(new Font("Raleway",Font.BOLD,15));

        dateOfBirthT = new JTextField("dd/mm/yy");
        dateOfBirthT.setBounds(240,260,350,25);
        dateOfBirthT.setFont(new Font("Raleway",Font.PLAIN,15));
        dateOfBirthT.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                dateOfBirthT.setText("");
            }
        });
        dateOfBirthT.addActionListener(this);

        emailAdd = new JLabel("Email Address");
        emailAdd.setBounds(70,290,130,30);
        emailAdd.setFont(new Font("Raleway",Font.BOLD,15));

        emailAddT = new JTextField();
        emailAddT.setBounds(240,290,350,25);
        emailAddT.setFont(new Font("Raleway",Font.PLAIN,15));

        maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setBounds(70,320,130,30);
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,15));

        married = new JRadioButton("Married");
        married.setBounds(240,320,90,25);
        married.setBackground(new Color(222,225,228));

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(380,320,110,25);
        unmarried.setBackground(new Color(222,225,228));

        otherM = new JRadioButton("Other");
        otherM.setBounds(530,320,60,25);
        otherM.setBackground(new Color(222,225,228));

        ButtonGroup group2 = new ButtonGroup();
        group2.add(married);
        group2.add(unmarried);
        group2.add(otherM);

        address = new JLabel("Address");
        address.setBounds(70,350,130,30);
        address.setFont(new Font("Raleway",Font.BOLD,15));

        addressT = new JTextField();
        addressT.setBounds(240,350,350,25);
        addressT.setFont(new Font("Raleway",Font.PLAIN,15));

        city = new JLabel("City:");
        city.setBounds(70,380,130,30);
        city.setFont(new Font("Raleway",Font.BOLD,15));

        cityT = new JTextField();
        cityT.setBounds(240,380,350,25);
        cityT.setFont(new Font("Raleway",Font.PLAIN,15));

        pinCode = new JLabel("Pin Code:");
        pinCode.setBounds(70,410,130,30);
        pinCode.setFont(new Font("Raleway",Font.BOLD,15));

        pinCodeT = new JTextField();
        pinCodeT.setBounds(240,410,350,25);
        pinCodeT.setFont(new Font("Raleway",Font.PLAIN,15));

        state = new JLabel("State:");
        state.setBounds(70,440,130,30);
        state.setFont(new Font("Raleway",Font.BOLD,15));

        stateT = new JTextField();
        stateT.setBounds(240,440,350,25);
        stateT.setFont(new Font("Raleway",Font.PLAIN,15));

        sec = new JLabel();
        sec.setBounds(240,470,350,25);
        sec.setFont(new Font("Raleway",Font.PLAIN,15));
        sec.setForeground(new Color(222,225,228));

        button = new JButton("Next");
        button.setBounds(550,500,100,40);
        button.setBorder(new EtchedBorder());
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);

        this.setBounds(20,10,700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.add(labelPage);
        this.add(labelPer);
        this.add(nameT);
        this.add(fatherNameT);
        this.add(male);
        this.add(female);
        this.add(other);
        this.add(dateOfBirthT);
        this.add(emailAddT);
        this.add(married);
        this.add(unmarried);
        this.add(otherM);
        this.add(addressT);
        this.add(cityT);
        this.add(pinCodeT);
        this.add(stateT);
        this.add(sec);

        this.add(nameL);
        this.add(fatherName);
        this.add(gender);
        this.add(dateOfBirth);
        this.add(emailAdd);
        this.add(maritalStatus);
        this.add(address);
        this.add(city);
        this.add(pinCode);
        this.add(state);
        this.add(label1);
        this.add(backButton);
        this.add(imgLabel1);
        this.add(button);
        this.getContentPane().setBackground(new Color(222,225,228));
        this.setResizable(false);
        this.setVisible(true);
    }
    public SignUp1(String formNo,int count){
        SignUp1 s = new SignUp1(count);
        this.prevFormNo = formNo;
        this.count = 1;
        s.sec.setText(prevFormNo);
        try{
            Con c = new Con();
            String q1 = "select * from signup where formNo = '"+formNo+"'";
            ResultSet resultSet = c.statement.executeQuery(q1);
//            ResultSet resultSet = c.statement.executeQuery("select * from signup where formNo='"+formNo+"'");
            if(resultSet.next()){
//                System.out.println(resultSet.getString(2));

                s.nameT.setText(resultSet.getString(2));
                s.fatherNameT.setText(resultSet.getString(3));
                s.dateOfBirthT.setText(resultSet.getString(4));

                if(resultSet.getString("gender").equals("Male"))
                    s.male.setSelected(true);
                else if (resultSet.getString("gender").equals("Female"))
                    s.female.setSelected(true);
                else if(other.isSelected())
                    s.other.setSelected(true);

                s.emailAddT.setText(resultSet.getString(6));

                if(resultSet.getString(7).equals("Married"))
                    s.married.setSelected(true);
                else if (resultSet.getString(7).equals("Unmarried"))
                    s.unmarried.setSelected(true);
                else if(otherM.isSelected())
                    s.otherM.setSelected(true);

                s.addressT.setText(resultSet.getString(8));
                s.cityT.setText(resultSet.getString(9));
                s.pinCodeT.setText(resultSet.getString(10));
                s.stateT.setText(resultSet.getString(11));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        formNo = first;
        prevFormNo = sec.getText();
        try {
            if (e.getSource() == button) {
                name = nameT.getText();
                String fatherName = fatherNameT.getText();
                String dateOfBirth = dateOfBirthT.getText();
                String emailAdd = emailAddT.getText();

                String gender = null;
                if (female.isSelected())
                    gender = other.getText();
                 else if (other.isSelected())
                    gender = female.getText();
                 else if(male.isSelected())
                    gender = male.getText();


                String maritalStatusT = null;
                if (otherM.isSelected())
                    maritalStatusT = otherM.getText();
                else if (married.isSelected())
                    maritalStatusT = married.getText();
                else if (unmarried.isSelected())
                    maritalStatusT = unmarried.getText();

                String address = addressT.getText();
                String city = cityT.getText();
                String pinCode = pinCodeT.getText();
                String state = stateT.getText();


                if(count == 0){
                    if (nameT.getText().isEmpty() || fatherNameT.getText().isEmpty() || pinCodeT.getText().isEmpty()
                            || addressT.getText().isEmpty() || stateT.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill All details.");
                    } else {
                        Con con1 = new Con();
                        String q = "insert into signup values('"+formNo+"','"+name+"','"+fatherName+"','"+dateOfBirth+"','"+gender+
                                    "','"+emailAdd+"','"+maritalStatusT+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
                        con1.statement.executeUpdate(q);
                        new SignUp2(formNo,name,count);
                        this.setVisible(false);
                    }
                } else {
                    Con c = new Con();
//                    String q = "insert into signup values('" + formNo + "','" + name + "','" + fatherName + "','" + gender + "','"
//                                  + dateOfBirth + "','" + emailAdd + "','" + maritalStatusT + "','" + address + "','" + city + "','"
//                                  + pinCode + "','" + state + "')";
                    String q1 = "update signup set formNo = '" + formNo + "'where formNo = '" +prevFormNo+ "'";
                    c.statement.executeUpdate(q1);


                    String q2 = "UPDATE signup SET name ='"+name+"',fatherName='"+fatherName+"',DOB='"+dateOfBirth+"',gender='"
                                    +gender+"',email='"+emailAdd+"',marital_status='"+maritalStatusT+"',address='"+address+"',city='"
                                    +city+"',pincode='"+pinCode+"',state='"+state+"'WHERE formNo ='"+formNo+"'";
                    c.statement.executeUpdate(q2);

//                    System.out.println("Marital Status: '" + maritalStatus + "', Length: " + maritalStatus.length());
//                    String q3 = "update signup set fatherName = '" + fatherName + "'where formNo = '" +formNo+ "'";
//                    String q4 = "update signup set DOB = '" + dateOfBirth + "'where formNo = '" +formNo+ "'";
//                    String q5 = "update signup set gender = '" + gender + "'where formNo = '" +formNo+ "'";
//                    String q6 = "update signup set email = '" + emailAdd + "'where formNo = '" +formNo+ "'";
//                    String q7 = "update signup set marital_status = '" + maritalStatus + "'where formNo = '" +formNo+ "'";
//                    String q8 = "update signup set address = '" + address + "'where address = '" +formNo+ "'";
//                    String q9 = "update signup set city = '" + city + "'where formNo = '" +formNo+ "'";
//                    String q10 = "update signup set pincode = '" + pinCode + "'where formNo = '" +formNo+ "'";
//                    String q11 = "update signup set state = '" + state + "'where formNo = '" +formNo+ "'";

//                    c.statement.executeUpdate(q1);
//                    c.statement.executeUpdate(q3);
//                    c.statement.executeUpdate(q4);
//                    c.statement.executeUpdate(q5);
//                    c.statement.executeUpdate(q6);
//                    c.statement.executeUpdate(q7);
//                    c.statement.executeUpdate(q8);
//                    c.statement.executeUpdate(q9);
//                    c.statement.executeUpdate(q10);
//                    c.statement.executeUpdate(q11);

//                    con1.statement.executeUpdate(q);
                    new SignUp2(formNo,name,0);
                    this.setVisible(false);
                }
            } else if (e.getSource() == backButton) {
                // if we want to delete data from database
//                Con c = new Con();
//                String q = "DELETE FROM signUp WHERE formNo = '" + formNo + "'";
//                c.statement.executeQuery(q);
                this.setVisible(false);
                Login l = new Login();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}
