package atm.simulator.system;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SignUp2 extends JFrame implements ActionListener {
    JLabel imgLabel1,label,page2,addDetail,religion,category,income,educational,occupation,panNumber,aadNo,serCitizen,existingAcc,sec;
    JComboBox<String> religionB,categoryB,incomeB,educationalB,occupationB;
    JTextField  panNumberT,aadNoT;
    JRadioButton serCitizenY,existingAccY;
    JRadioButton serCitizenN,existingAccN;
    JButton button,backButton;

    String formNo,name,prevFormNo;

    int count;SignUp2(String formNo,String name,int count){
        super("APPLICATION FORM");
        this.formNo = formNo;
        this.name = name;
        this.count = count;
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/image1.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        imgLabel1 = new JLabel(ii3);
        imgLabel1.setBounds(80,30,100,100);

        label = new JLabel("Form No. " + formNo);
        label.setBounds(520,10,200,30);
        label.setFont(new Font("Raleway",Font.BOLD,12));

        page2 = new JLabel("Page No. 2");
        page2.setBounds(250,50,100,30);
        page2.setFont(new Font("Raleway",Font.BOLD,18));

        addDetail = new JLabel("Addition Details");
        addDetail.setBounds(250,80,250,30);
        addDetail.setFont(new Font("Raleway",Font.BOLD,24));

        religion = new JLabel("Religion:");
        religion.setBounds(80,170,150,30);
        religion.setFont(new Font("Raleway",Font.BOLD,15));

        religionB = new JComboBox<>(new String[]{"Hindu","Muslim","Sikh","Christian","Others"});
        religionB.setBounds(240,170,350,25);
        religionB.setFont(new Font("Raleway",Font.PLAIN,15));

        category = new JLabel("Category:");
        category.setBounds(80,200,150,30);
        category.setFont(new Font("Raleway",Font.BOLD,15));

        categoryB = new JComboBox<>(new String[]{"General(GEN)","Backward class(OBC)","Scheduled Caste(SC)","Others"});
        categoryB.setBounds(240,200,350,25);
        categoryB.setFont(new Font("Raleway",Font.PLAIN,15));

        income = new JLabel("Income:");
        income.setBounds(80,230,150,30);
        income.setFont(new Font("Raleway",Font.BOLD,15));

        incomeB = new JComboBox<>(new String[]{"null","below 1 Lakh","1.1 - 2 Lakh","2.1 - 4 Lakh","4.1 - 7 Lakh","More than 8 Lakh","others"});
        incomeB.setBounds(240,230,350,25);
        incomeB.setFont(new Font("Raleway",Font.PLAIN,15));
//        incomeB.setBackground(new Color(222,225,228));
//        incomeB.addMouseListener(new MouseAdapter());

        educational = new JLabel("Educational:");
        educational.setBounds(80,260,150,30);
        educational.setFont(new Font("Raleway",Font.BOLD,15));

        educationalB = new JComboBox<>(new String[]{"Uneducated","12th Pass","UnderGraduate","PostGraduate","Others"});
        educationalB.setBounds(240,260,350,25);
        educationalB.setFont(new Font("Raleway",Font.PLAIN,15));

        occupation = new JLabel("Occupation:");
        occupation.setBounds(80,290,150,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,15));

        occupationB = new JComboBox<>(new String[]{"Labour","Business man","Farmer","Doctor","Engineer","Student","Other"});
        occupationB.setBounds(240,290,350,25);
        occupationB.setFont(new Font("Raleway",Font.PLAIN,15));

        panNumber = new JLabel("PAN Number:");
        panNumber.setBounds(80,320,150,30);
        panNumber.setFont(new Font("Raleway",Font.BOLD,15));

        panNumberT = new JTextField();
        panNumberT.setBounds(240,320,350,25);
        panNumberT.setFont(new Font("Raleway",Font.PLAIN,15));

        aadNo = new JLabel("Aadhaar Number");
        aadNo.setBounds(80,350,150,30);
        aadNo.setFont(new Font("Raleway",Font.BOLD,15));

        aadNoT = new JTextField("");
        aadNoT.setFocusable(true);
        //aadNoT.setAction(new ActionEvent(this,aadNoT,(Long);
        aadNoT.setBounds(240,350,350,25);
        aadNoT.setFont(new Font("Raleway",Font.PLAIN,15));
//        aadNoT.setForeground(Color.red);
//        aadNoT.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                aadNoT.setText("");
//            }
//        });

        serCitizen = new JLabel("Senior Citizen:");
        serCitizen.setBounds(80,380,150,30);
        serCitizen.setFont(new Font("Raleway",Font.BOLD,15));

        serCitizenY = new JRadioButton("YES");
        serCitizenY.setBounds(240,380,80,25);
        serCitizenY.setFont(new Font("Raleway",Font.PLAIN,15));
        serCitizenY.setBackground(new Color(222,225,228));

        serCitizenN = new JRadioButton("NO");
        serCitizenN.setBounds(400,380,50,25);
        serCitizenN.setFont(new Font("Raleway",Font.PLAIN,15));
        serCitizenN.setBackground(new Color(222,225,228));

        ButtonGroup group2 = new ButtonGroup();
        group2.add(serCitizenY);
        group2.add(serCitizenN);

        existingAcc = new JLabel("Existing Account :");
        existingAcc.setBounds(80,410,150,30);
        existingAcc.setFont(new Font("Raleway",Font.BOLD,15));

        existingAccY = new JRadioButton("YES");
        existingAccY.setBounds(240,410,80,25);
        existingAccY.setFont(new Font("Raleway",Font.PLAIN,15));
        existingAccY.setBackground(new Color(222,225,228));

        existingAccN = new JRadioButton("NO");
        existingAccN.setBounds(400,410,50,25);
        existingAccN.setFont(new Font("Raleway",Font.PLAIN,15));
        existingAccN.setBackground(new Color(222,225,228));

        ButtonGroup group1 = new ButtonGroup();
        group1.add(existingAccY);
        group1.add(existingAccN);

        sec = new JLabel();
        sec.setBounds(240,470,350,25);
        sec.setFont(new Font("Raleway",Font.PLAIN,15));

        button = new JButton("Next");
        button.setBounds(550,500,100,40);
        button.setBorder(new EtchedBorder());
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/backImg.png"));
        Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        backButton = new JButton(i3);
        backButton.setBounds(7,7,30,30);
        backButton.setBackground(new Color(222,225,228));
        backButton.addActionListener(this);

        this.add(religionB);
        this.add(categoryB);
        this.add(incomeB);
        this.add(occupationB);
        this.add(educationalB);

        this.add(panNumberT);
        this.add(aadNoT);
        this.add(serCitizenY);
        this.add(serCitizenN);
        this.add(existingAccY);
        this.add(existingAccN);

        this.add(label);
        this.add(religion);
        this.add(category);
        this.add(income);
        this.add(educational);
        this.add(occupation);
        this.add(panNumber);
        this.add(aadNo);
        this.add(serCitizen);
        this.add(existingAcc);
        this.add(page2);
        this.add(addDetail);
        this.add(backButton);
        this.add(imgLabel1);
        this.add(button);

        this.setBounds(20,10,700,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        this.add(imgLabel1);
        this.getContentPane().setBackground(new Color(222,225,228));
        this.setVisible(true);
    }
    public SignUp2(String formNo,String name,String str,int count){
        SignUp2 s = new SignUp2(formNo,name,count);
        this.prevFormNo = formNo;
        this.count = 1;
        s.sec.setText(prevFormNo);

        try{
            Con c = new Con();
            String q1 = "select * from signuptwo where formNoTwo = '"+formNo+"'";
            ResultSet resultSet = c.statement.executeQuery(q1);
//            ResultSet resultSet = c.statement.executeQuery("select * from signup where formNo='"+formNo+"'");
            if(resultSet.next()) {
//                System.out.println(resultSet.getString(2));

                s.religionB.setSelectedItem(resultSet.getString(2));
                s.categoryB.setSelectedItem(resultSet.getString(3));
                s.incomeB.setSelectedItem(resultSet.getString(4));
                s.educationalB.setSelectedItem(resultSet.getString(5));
                s.occupationB.setSelectedItem(resultSet.getString(6));
                s.panNumberT.setText(resultSet.getString(7));
                s.aadNoT.setText(resultSet.getString(8));
                if (resultSet.getString(9).equals("YES"))
                    s.serCitizenY.setSelected(true);

                else
                    s.serCitizenN.setSelected(true);

                if (resultSet.getString(10).equals("YES"))
                    s.existingAccY.setSelected(true);

                else
                    s.existingAccN.setSelected(true);

            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        formNo = first;
        try{
            if (e.getSource() == button) {
                String rel = (String) religionB.getSelectedItem();
                String cat = (String) categoryB.getSelectedItem();
                String inc = (String) incomeB.getSelectedItem();
                String edu = (String) educationalB.getSelectedItem();
                String occ = (String) occupationB.getSelectedItem();

                String pan = panNumberT.getText();
                String aad = aadNoT.getText();

                String seeCit = "";
                if (serCitizenY.isSelected()) {
                    seeCit = "YES";
                } else {
                    seeCit = "NO";
                }

                String exitacc = "";
                if (existingAccY.isSelected()) {
                    exitacc = "YES";
                } else {
                    exitacc = "NO";
                }
//            (Long.parseLong(aadNoT.getText()))


                if(count == 0){
                    if (aadNoT.getText().isEmpty() || panNumberT.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill all the fields.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Con c = new Con();
                        String q = "insert into signuptwo values('" + formNo + "','" + rel + "','" + cat + "','" + inc + "','" + edu +
                                                    "','" + occ + "','" + pan + "','" + aad + "','" + seeCit + "','" + exitacc + "')";
                        c.statement.executeUpdate(q);
                        new SignUp3(formNo,name);
                        this.setVisible(false);
                    }
                } else {
                    Con c = new Con();
//                    String q1 = "update signup set formNo = '" + formNo + "'";
//                    c.statement.executeUpdate(q1);
                    String q2 = "UPDATE signuptwo SET religion ='"+rel+"',category='"+cat+"',income='"+inc+"',educational='"+edu+
                                                "',occupation='"+occ+"',panNo='"+pan+"',aadharNo='"+aad+"',senior_Citizen='"+seeCit+
                                                "',existing_Acc='"+exitacc+"'WHERE formNoTwo='"+formNo+"'";
                    c.statement.executeUpdate(q2);
                    new SignUp3(formNo,name);
                    this.setVisible(false);
                }
            } else if (e.getSource() == backButton) {
                this.setVisible(false);
                // if we want to delete data from database

//                Con c = new Con();
//                String q = "DELETE FROM signUp WHERE formNo = '" + formNo + "'";
//                c.statement.executeUpdate(q);
                SignUp1 prev1 = new SignUp1(formNo,1);

            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        SignUp2 s = new SignUp2("1234123412341234");
//
//    }
}
