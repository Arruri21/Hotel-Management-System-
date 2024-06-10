
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
import java.sql.ResultSet;



public class Room extends JFrame implements ActionListener{
    JButton Back;
    Room(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setBounds(3,20,100,20);
        add(lblroomno);
        
        
        JLabel lblAvailability=new JLabel("Availability");
        lblAvailability.setBounds(120,20,100,20);
        add(lblAvailability);
        
         JLabel lblstatus=new JLabel("Status");
        lblstatus.setBounds(220,20,100,20);
        add(lblstatus);
        
         JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(320,20,100,20);
        add(lblprice);
        
         JLabel lblbedtype=new JLabel("BedType");
        lblbedtype.setBounds(420,20,100,20);
        add(lblbedtype);
        
        Back=new JButton("Back");
        Back.setBounds(200,500,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        
        JTable table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,100,1050,600);
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
        new Room();
        
    }


    
}
