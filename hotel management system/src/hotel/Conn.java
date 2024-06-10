
package hotel.management.system;

import java.sql.*;

public class Conn {
    Connection cs;
    Statement s;
    Conn() {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        cs=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Venky@52168");
        s=cs.createStatement(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Conn();
    }
}


