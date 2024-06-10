
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    Choice customerid;
    JTextField tfroomno,tfcheckin,tfcheckout;
    JLabel lblcheckouttime,lbltime,lblroomno;
    JButton Back,Checkout;
    Checkout(){
        
        
        JLabel lblheading=new JLabel("Checkout");
        lblheading.setBounds(160,60,200,30);
        lblheading.setFont(new Font("serif",Font.BOLD,22));
        add(lblheading);
        
        
        JLabel lblcustomerid=new JLabel("Customer ID");
        lblcustomerid.setBounds(20,110,200,30);
        lblcustomerid.setFont(new Font("serif",Font.PLAIN,18));
        add(lblcustomerid);
        
         
        customerid=new Choice();
        customerid.setBounds(250,110,200,40);
        add(customerid);
        
        
        lblroomno=new JLabel("Room Number");
        lblroomno.setBounds(20,160,200,30);
          lblroomno.setFont(new Font("serif",Font.PLAIN,18));
        add(lblroomno);
       
        tfroomno=new JTextField();
        tfroomno.setBounds(250,160,200,30);
        add(tfroomno);
        
         lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(20,210,200,30);
          lbltime.setFont(new Font("serif",Font.PLAIN,18));
        add(lbltime);
        
        
        tfcheckin=new JTextField();
        tfcheckin.setBounds(250,210,200,30);
        add(tfcheckin);
        
         JLabel lblcheckout=new JLabel("Checkout Time");
        lblcheckout.setBounds(20,260,200,30);
          lblcheckout.setFont(new Font("serif",Font.PLAIN,18));
        add(lblcheckout);
        
        
        Date date=new Date();
         lblcheckouttime=new JLabel(""+date);
        lblcheckouttime.setBounds(250,260,250,30);
          lblcheckouttime.setFont(new Font("serif",Font.PLAIN,18));
        add(lblcheckouttime);
        
        
        
        Checkout=new JButton("Check");
        Checkout.setBounds(60,330,100,30);
        Checkout.setFont(new Font("serif",Font.BOLD,16));
        Checkout.setBackground(Color.BLACK);
        Checkout.setForeground(Color.WHITE);
        Checkout.addActionListener(this);
        add(Checkout);
        
         Back=new JButton("Back");
        Back.setBounds(230,330,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
       Image i2=i1.getImage().getScaledInstance(350,400,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,40,400,350);
        add(image);
        
        try{
            Conn conn=new Conn();
            String query="select * from customer";
            ResultSet rs=conn.s.executeQuery(query);
             while(rs.next()){
                 customerid.add(rs.getString("Number"));
                 tfroomno.setText(rs.getString("Room"));
                 tfcheckin.setText(rs.getString("Time"));
             }
        }
        catch(Exception ae){
            ae.printStackTrace();
        }
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,900,450);
        setVisible(true);
        
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Checkout){
            String query1="delete from customer where Number='"+customerid.getSelectedItem()+"'";
            String query2="update room set availability='Available' where Roomnumber='"+tfroomno.getText()+"'";
            try{
                 Conn c=new Conn();
                c.s.executeQuery(query1);
                c.s.executeQuery(query2);
                JOptionPane.showMessageDialog(null,"Checkout done");
            }
            catch(Exception aee){
               
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
        
    }

    public static void main(String[] args) {
        new Checkout();
        
    }

   }
