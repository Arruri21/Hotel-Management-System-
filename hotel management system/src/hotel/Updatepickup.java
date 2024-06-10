
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.proteanit.sql.*;
import java.sql.ResultSet;



public class Updatepickup extends JFrame implements ActionListener{
    JButton Back,submit;
            JCheckBox jcbavailable;
            JTable table;
            Choice typeofcar;
    Updatepickup(){
        JLabel lblheading=new JLabel("Pickup Service");
        lblheading.setBounds(400,20,150,20);
        lblheading.setFont(new Font("serif",Font.BOLD,20));
        add(lblheading);
        
        JLabel lblroombedtype=new JLabel("Type Of Car");
        lblroombedtype.setBounds(40,80,100,30);
        lblroombedtype.setFont(new Font("serif",Font.PLAIN,20));
        add(lblroombedtype);
        
        typeofcar=new Choice();
        typeofcar.setBounds(180,85,150,30);
        add(typeofcar);
         try{
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from drivers");
             while(rs.next()){
                 typeofcar.add(rs.getString("carcompany"));
             }
             
             
         }
         catch(Exception ae){
             ae.printStackTrace();
         }
        
        
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,280,150,20);
        add(lblname);
        
        
        JLabel lblage=new JLabel("Age");
        lblage.setBounds(200,280,150,20);
        add(lblage);
     
        
         JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(330,280,150,20);
        add(lblgender);
        
         JLabel lblcarcompany=new JLabel("Carcompany");
        lblcarcompany.setBounds(450,280,150,20);
        add(lblcarcompany);
        
        JLabel lblcarmodel=new JLabel("Car Model");
        lblcarmodel.setBounds(590,280,150,20);
        add(lblcarmodel);
        
        JLabel lblavailable=new JLabel("Available");
        lblavailable.setBounds(750,280,150,20);
        add(lblavailable);
        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(900,280,150,20);
        add(lbllocation);
        

        
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
            ResultSet rs1=conn.s.executeQuery("select * from drivers");
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
       // String bedtype=lblbedtype.getText();
      
        if(e.getSource()==submit){
            try{
                String query1="select * from drivers where carcompany='"+typeofcar.getSelectedItem()+"' ";
                Conn conn=new Conn();
                ResultSet rs;
                
                    rs=conn.s.executeQuery(query1);
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
        new Updatepickup();
        
    }


    
}

