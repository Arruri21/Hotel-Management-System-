
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
import java.sql.ResultSet;



public class SearchRoom extends JFrame implements ActionListener{
    JButton Back,submit;
    JLabel lblbedtype;
    JComboBox jcbtype;
            JCheckBox jcbavailable;
            JTable table;
    SearchRoom(){
        JLabel lblheading=new JLabel("Search For Room");
        lblheading.setBounds(400,20,150,20);
        lblheading.setFont(new Font("serif",Font.BOLD,20));
        add(lblheading);
        
        JLabel lblroombedtype=new JLabel("Bed Type");
        lblroombedtype.setBounds(40,80,150,30);
        lblroombedtype.setFont(new Font("serif",Font.PLAIN,20));
        add(lblroombedtype);
        
        
          String Stype[]={"Single","Double"};
        jcbtype=new JComboBox(Stype);
        jcbtype.setBounds(150,80,180,30);
        add(jcbtype);
         
        
        jcbavailable=new JCheckBox("Only display Available");
        jcbavailable.setBounds(700,80,150,30);
        jcbavailable.setBackground(Color.WHITE);
        add(jcbavailable);
        
        
        
        JLabel lblname=new JLabel("Room Number");
        lblname.setBounds(8,280,150,20);
        add(lblname);
        
        
        JLabel lblavailability=new JLabel("Availability");
        lblavailability.setBounds(230,280,150,20);
        add(lblavailability);
     
        
         JLabel lblstatus=new JLabel("Status");
        lblstatus.setBounds(450,280,150,20);
        add(lblstatus);
        
         JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(640,280,150,20);
        add(lblprice);
        
        lblbedtype=new JLabel("Bed Type");
        lblbedtype.setBounds(820,280,150,20);
        add(lblbedtype);
        

        
        submit=new JButton("Submit");
        submit.setBounds(300,500,100,30);
        submit.setFont(new Font("serif",Font.BOLD,16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        Back=new JButton("Back");
        Back.setBounds(600,500,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        
        
        
        table=new JTable();
        table.setBounds(0,300,1000,500);
        add(table);
        
        try{
            Conn conn=new Conn();
            ResultSet rs1=conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs1));
            
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
        String bedtype=lblbedtype.getText();
      
        if(e.getSource()==submit){
            try{
                String query1="select * from room where bed_type='"+jcbtype.getSelectedItem()+"' ";
                String query2="select * from room where availability='Available' AND bed_type= '"+jcbtype.getSelectedItem()+"' ";
                Conn conn=new Conn();
                ResultSet rs;
                if(jcbavailable.isSelected()){
                    rs=conn.s.executeQuery(query2);
                    
                }
                else{
                    rs=conn.s.executeQuery(query1);
                }
                  table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception ae){
                ae.printStackTrace();
            }
        }
        else{
             
            setVisible(false);
            new Reception();
        }
        
      
        
    }
    public static void main(String[] args) {
        new SearchRoom();
        
    }


    
}
