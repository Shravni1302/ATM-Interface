package ATMINTERFACE;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Statement;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno,pinnumber;
    SignupThree(String formno){
        this.formno = formno;

        setLayout(null);
        JLabel S3 = new JLabel("Page 3: Account Details");
        S3.setFont(new Font("Raleway", Font.BOLD, 22));
        S3.setBounds(280,40,400,40);
        add(S3);

        JLabel type = new JLabel("Account type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,150,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup accounttype = new ButtonGroup();
        accounttype.add(r1);
        accounttype.add(r2);
        accounttype.add(r3);
        accounttype.add(r4);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(100,300,200,30);
        add(cardno);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100,330,300,20);
        add(carddetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pno = new JLabel("XXXX");
        pno.setFont(new Font("Raleway", Font.BOLD, 22));
        pno.setBounds(330,370,200,30);
        add(pno);

        JLabel pindetails = new JLabel("Your 4 Digit Password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100,400,300,20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,450,300,30);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4=new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposite Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposite Account";
            }
            Random random = new Random();
            String cardnumber = " " + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pin = " " + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facilities = " ";
            if (c1.isSelected()){
                facilities = facilities + "ATM Card";
            } else if (c2.isSelected()){
                facilities = facilities + "Internet Banking";
            } else if (c3.isSelected()){
                facilities = facilities + "Mobile Banking";
            } else if (c4.isSelected()){
                facilities = facilities + "Email and SMS Alerts";
            } else if (c5.isSelected()){
                facilities = facilities + "Cheque Book";
            } else if (c6.isSelected()){
                facilities = facilities + "E-Statement";
            } else if (c7.isSelected()){
                facilities = facilities + "I hereby declare that the above entered details are correct to the best of my knowledge";
            }
            try {
                if(accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");

                }else{
                    Conn c = new Conn();
                    Statement s = c.getStatement();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pin+"','"+facilities+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";
                    s.executeUpdate(query1);
                    s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number:" + cardnumber + "\n Pin:" + pin);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            }catch (Exception e){
                System.out.println(e);

            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new login().setVisible(true);

        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}
