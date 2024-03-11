package ATMINTERFACE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn {
    Connection con;
    Statement s;

    public Conn() {
        try {
            con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Pass@1302");
            s = con.createStatement();
            System.out.println(con);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        return s;
    }
}

