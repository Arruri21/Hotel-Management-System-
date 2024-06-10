
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton jrbmale,lblfemale;
    JComboBox jcbid;
    Choice croom;
    JButton addcustomer,back;
     JLabel checkintime;
    AddCustomer(){
        JLabel lblheading=new JLabel("New Customer Form");
        lblheading.setBounds(100,20,200,30);
        lblheading.setForeground(Color.blue);
        lblheading.setFont(new Font("serif",Font.PLAIN,20));
        add(lblheading);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(20,60,200,30);
        lblid.setFont(new Font("serif",Font.PLAIN,18));
        add(lblid);
        
        
        String id[]={"Passport","Aadhar","Pancard","Driving Licence","VoterID","Ration Card"};
        jcbid=new JComboBox(id);
        jcbid.setBounds(220,60,200,30);
        jcbid.setBackground(Color.WHITE);
        add(jcbid);
       
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(20,100,200,30);
        lblnumber.setFont(new Font("serif",Font.PLAIN,18));
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(220,100,200,30);
        add(tfnumber);
        
         JLabel lblname=new JLabel("Name");
        lblname.setBounds(20,140,200,30);
        lblname.setFont(new Font("serif",Font.PLAIN,18));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(220,140,200,30);
        add(tfname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(20,180,200,30);
        lblgender.setFont(new Font("serif",Font.PLAIN,18));
        add(lblgender);
        
        
        
        jrbmale=new JRadioButton("Male");
        jrbmale.setBounds(220,180,80,30);
        jrbmale.setBackground(Color.WHITE);
        add(jrbmale);
  
        
         JRadioButton lbfemale=new JRadioButton("Female");
        lbfemale.setBounds(300,180,100,30);
         lbfemale.setBackground(Color.WHITE);
        add(lbfemale);  
        
       
        
         JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(20,220,200,30);
        lblcountry.setFont(new Font("serif",Font.PLAIN,18));
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(220,220,200,30);
        add(tfcountry);

        JLabel Allocation=new JLabel("Allocated Room No");
        Allocation.setBounds(20,260,200,30);
        Allocation.setFont(new Font("serif",Font.PLAIN,18));
        add(Allocation);
        
        croom=new Choice();
        try{
            Conn conn=new Conn();
            String query="select * from room where availability='Available'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        croom.setBounds(220,265,200,30);
        add(croom);
        
        
        JLabel lbltime=new JLabel("Checkin Time");
        lbltime.setBounds(20,300,200,30);
        lbltime.setFont(new Font("serif",Font.PLAIN,18));
        add(lbltime);
        
        Date date=new Date();
        checkintime=new JLabel("]"+date);
        checkintime.setBounds(220,300,200,30);
        checkintime.setFont(new Font("serif",Font.BOLD,14));
        add(checkintime);
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(20,340,200,30);
        lbldeposit.setFont(new Font("serif",Font.PLAIN,18));
        add(lbldeposit);
       
        tfdeposit=new JTextField();
        tfdeposit.setBounds(220,340,200,30);
        add(tfdeposit);
        
        
        addcustomer=new JButton("Add Customer");
        addcustomer.setBounds(70,400,100,30);
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.addActionListener(this);
        add(addcustomer);
        
         
        back=new JButton("Back");
        back.setBounds(230,400,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,60,400,300);
        add(image);
        
        
        
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350,150,800,500);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addcustomer){
            String ID=(String)jcbid.getSelectedItem();
            String Number=tfnumber.getText();
            String Name=tfname.getText();
            String gender=null;
            if(jrbmale.isSelected()){
                gender="male";
            }
            else{
                gender="female";
            }
            String Country=tfcountry.getText();
            String Room=croom.getSelectedItem();
            String Time=checkintime.getText();
            String Deposit=tfdeposit.getText();
            try{
                String query="insert into customer values('"+ID+"','"+Number+"','"+Name+"','"+gender+"','"+Country+"','"+Room+"','"+Time+"','"+Deposit+"')";
                String query2="update room set availability = 'occupied' where roomnumber='"+Room+"'";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new Reception();
            }
            catch(Exception ee){
                
            }
            
            
    }
        else if(ae.getSource()==back){
              setVisible(false);
                new Reception(); 
            
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }

    
    
}
