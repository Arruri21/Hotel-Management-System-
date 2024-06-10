
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateRoom extends JFrame implements ActionListener{
    JTextField tfname,tfroom,tfcleaningstatus,tfavailable;
    JButton Back,Check,update;
    Choice customerid;
    UpdateRoom(){
        
        JLabel lbltext=new JLabel("Update Room Status");
        lbltext.setBounds(200,10,200,30);
        lbltext.setFont(new Font("serif",Font.BOLD,20));
        lbltext.setForeground(Color.BLUE);
        add(lbltext);
        
        
        
          JLabel lblID=new JLabel("Customer Id");
        lblID.setBounds(20,50,200,30);
        lblID.setFont(new Font("serif",Font.BOLD,20));
        add(lblID);
        
         customerid=new Choice();
        customerid.setBounds(250,50,200,30);
        add(customerid);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while(rs.next()){
                customerid.add(rs.getString("Number"));
            }
        }
        catch(Exception ae){
            ae.printStackTrace();
        }
        
        
          JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(20,90,150,30);
        lblroom.setFont(new Font("serif",Font.BOLD,20));
        add(lblroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(250,90,200,30);
        add(tfroom);
      
         JLabel lblavailable=new JLabel("Availability");
        lblavailable.setBounds(20,140,150,30);
        lblavailable.setFont(new Font("serif",Font.BOLD,20));
        add(lblavailable);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(250,140,200,30);
        add(tfavailable);
      
        
         JLabel lblCleaningstatus=new JLabel("Cleaning Status");
        lblCleaningstatus.setBounds(20,190,150,30);
        lblCleaningstatus.setFont(new Font("serif",Font.BOLD,20));
        add(lblCleaningstatus);
        
        tfcleaningstatus=new JTextField();
        tfcleaningstatus.setBounds(250,190,200,30);
        add(tfcleaningstatus);
      
        

        
        Check=new JButton("Check");
        Check.setBounds(30,250,100,30);
        Check.setFont(new Font("serif",Font.BOLD,16));
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        Check.addActionListener(this);
        add(Check);
        
        update=new JButton("Update");
        update.setBounds(170,250,100,30);
        update.setFont(new Font("serif",Font.BOLD,16));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        
        Back=new JButton("Back");
        Back.setBounds(300,250,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
       Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(470,40,450,300);
        add(image);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,950,400);
        setVisible(true);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Check){
              String id=customerid.getSelectedItem();
              String query="select * from customer where number='"+id+"'";
              try{
                  Conn conn=new Conn();
                  ResultSet rs=conn.s.executeQuery(query);
                  while(rs.next()){
                      tfroom.setText(rs.getString("Room"));
                 
                  }
                  ResultSet rs2=conn.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                  while(rs2.next()){
                      tfavailable.setText(rs2.getString("availability"));
                      tfcleaningstatus.setText(rs2.getString("cleaning_status"));
                      
                   
                  }
              }
              catch(Exception ee){
                  ee.printStackTrace();
              }
            
        }
        else if(e.getSource()==update){
            String number=customerid.getSelectedItem();
            String available=tfavailable.getText();
            String room=tfroom.getText();
            String cleaning_status=tfcleaningstatus.getText();
           
            
            try{
            Conn conn=new Conn();
           conn.s.executeUpdate("update room set availability='"+available+"',cleaning_status='"+cleaning_status+"' where roomnumber='"+room+"' ");
            JOptionPane.showMessageDialog(null,"Data updated successfully");
            setVisible(false);
            new Reception();
            
                
            }
            catch(Exception aee){
                aee.printStackTrace();
            }
    }
        else if(e.getSource()==Back){
            setVisible(false);
            new Reception();
            
        }
    }
        
    public static void main(String[] args) {
        new UpdateRoom();
    }

       
}
