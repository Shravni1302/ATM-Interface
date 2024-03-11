package ATMINTERFACE;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public  class Ministatement extends JFrame {
    String pinnumber;
    Ministatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select*from login where pin = '"+pinnumber+"'");
            while(rs.next()) {
                card.setText("Card Number " + rs.getString("cardnumber").substring(0,4) + "XXXXXXX" + rs.getString("cardnumber").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select*from bank where pin = '"+pinnumber+"'");
            while (rs.next()){
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp" + rs.getString("amount") + "<br><br><html>");

            }
        }catch (Exception e){
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    public static void main(String args[]){
        new Ministatement("");
    }
}