
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
import java.sql.ResultSet;



public class Department extends JFrame implements ActionListener{
    JButton Back;
    Department(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        
        JLabel lbldepartment=new JLabel("Department");
        lbldepartment.setBounds(180,20,100,20);
        add(lbldepartment);
        
        
        JLabel lblbudget=new JLabel("Budget");
        lblbudget.setBounds(400,20,100,20);
        add(lblbudget);
        
        

        
        Back=new JButton("Back");
        Back.setBounds(200,500,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        
        JTable table=new JTable();
        table.setBounds(10,50,700,400);
        add(table);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from department");
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
        new Department();
        
    }


    
}
