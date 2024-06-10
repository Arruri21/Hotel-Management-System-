
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdateCheckout extends JFrame implements ActionListener{
    JTextField tfname,tfcheckin,tfamountpaid,tfpendingamount,tfroom;
    JButton Back,Check,update;
    Choice customerid;
    UpdateCheckout(){
        
        JLabel lbltext=new JLabel("Update Status");
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
        
          JLabel lblname=new JLabel("Name");
        lblname.setBounds(20,140,150,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(250,140,200,30);
        add(tfname);
        
        JLabel lblcheckin=new JLabel("CheckIn Time");
        lblcheckin.setBounds(20,190,200,30);
        lblcheckin.setFont(new Font("serif",Font.BOLD,20));      
        add(lblcheckin);
        
        tfcheckin=new JTextField();
        tfcheckin.setBounds(250,190,200,30);
        add(tfcheckin);
        
         JLabel lblamountpaid=new JLabel("Amount Paid");
        lblamountpaid.setBounds(20,250,200,30);
        lblamountpaid.setFont(new Font("serif",Font.BOLD,20));
        add(lblamountpaid);
        
        tfamountpaid=new JTextField();
        tfamountpaid.setBounds(250,250,200,30);
        add(tfamountpaid);
        
         JLabel lblpendingamount=new JLabel("Pending Amount");
        lblpendingamount.setBounds(20,310,200,30);
        lblpendingamount.setFont(new Font("serif",Font.BOLD,20));
        add(lblpendingamount);

        tfpendingamount=new JTextField();
        tfpendingamount.setBounds(250,310,200,30);
        add(tfpendingamount);

        
        Check=new JButton("Check");
        Check.setBounds(30,360,100,30);
        Check.setFont(new Font("serif",Font.BOLD,16));
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        Check.addActionListener(this);
        add(Check);
        
        update=new JButton("Update");
        update.setBounds(170,360,100,30);
        update.setFont(new Font("serif",Font.BOLD,16));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        
        Back=new JButton("Back");
        Back.setBounds(300,360,100,30);
        Back.setFont(new Font("serif",Font.BOLD,16));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
       Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,40,400,400);
        add(image);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,950,500);
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
                      tfname.setText(rs.getString("Name"));
                      tfcheckin.setText(rs.getString("Time"));
                      tfamountpaid.setText(rs.getString("Deposit"));        
                  }
                  ResultSet rs2=conn.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                  while(rs2.next()){
                      String price=rs2.getString("price");
                      int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfamountpaid.getText());
                      tfpendingamount.setText(""+amountpaid);
                  }
              }
              catch(Exception ee){
                  ee.printStackTrace();
              }
            
        }
        else if(e.getSource()==update){
            String number=customerid.getSelectedItem();
            String name=tfname.getText();
            String room=tfroom.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfamountpaid.getText();
            
            try{
            Conn conn=new Conn();
            conn.s.executeUpdate("update customer set Room='"+room+"',Name='"+name+"',Time='"+checkin+"',Deposit='"+deposit+"' where Number='"+number+"'");
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
        new UpdateCheckout();
    }

       
}
