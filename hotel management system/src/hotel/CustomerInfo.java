
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
import java.sql.ResultSet;



public class CustomerInfo extends JFrame implements ActionListener{
    JButton Back;
    CustomerInfo(){
       
        
        JLabel lblId=new JLabel("ID");
        lblId.setBounds(8,20,150,20);
        add(lblId);
        
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(200,20,150,20);
        add(lblnumber);
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(340,20,150,20);
        add(lblname);
        
         JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(480,20,150,20);
        add(lblgender);
        
         JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(620,20,150,20);
        add(lblcountry);
        
         JLabel lblroom=new JLabel("Room No");
        lblroom.setBounds(800,20,150,20);
        add(lblroom);
        
        
        JLabel lbltime=new JLabel("Check In Time");
        lbltime.setBounds(950,20,150,20);
        add(lbltime);
        
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(1100,20,150,20);
        add(lbldeposit);
        
        Back=new JButton("Back");
        Back.setBounds(500,500,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        
        JTable table=new JTable();
        table.setBounds(0,40,1200,500);
        add(table);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,100,1200,600);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Back){
            setVisible(false);
            new Reception();
        }
      
        
    }
    public static void main(String[] args) {
        new CustomerInfo();
        
    }


    
}
