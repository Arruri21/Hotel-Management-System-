
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
import java.sql.ResultSet;



public class ManagerInfo extends JFrame implements ActionListener{
    JButton Back;
    ManagerInfo(){
       
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(8,20,150,20);
        add(lblname);
        
        
        JLabel lblage=new JLabel("Age");
        lblage.setBounds(150,20,150,20);
        add(lblage);
        
         JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(260,20,150,20);
        add(lblgender);
        
         JLabel lbljob=new JLabel("Job");
        lbljob.setBounds(400,20,150,20);
        add(lbljob);
        
         JLabel lblsalary=new JLabel("Salary");
        lblsalary.setBounds(520,20,150,20);
        add(lblsalary);
        
         JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(650,20,150,20);
        add(lblphone);
        
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(780,20,150,20);
        add(lblemail);
        
        
        JLabel lblaadhar=new JLabel("Aadhar");
        lblaadhar.setBounds(900,20,150,20);
        add(lblaadhar);
        
        Back=new JButton("Back");
        Back.setBounds(500,500,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        
        JTable table=new JTable();
        table.setBounds(0,40,1000,500);
        add(table);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,100,1000,600);
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
        new ManagerInfo();
        
    }


    
}
