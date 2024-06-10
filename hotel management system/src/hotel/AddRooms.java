
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddRooms extends JFrame implements ActionListener{
    JTextField tfroomno,tfprice;
    JComboBox jcbcleaned,jcbtype,jcbavailable;
    JButton cancel,add;
    
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        //ADDING THE HEADING 
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("serif",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        //ADDING ROOM NUMBER FOR THE SECTION
        JLabel lblroomno=new JLabel("Room No");
        lblroomno.setFont(new Font("serif",Font.PLAIN,18));
        lblroomno.setBounds(60,60,150,30);
        add(lblroomno);
        
        tfroomno=new JTextField();
        tfroomno.setBounds(200,60,180,30);
        add(tfroomno);
        
        //CHECKING WEATHER THE ROOMS ARE AVAILABLE OR NOT
        JLabel lblAvailable=new JLabel("Available");
        lblAvailable.setFont(new Font("serif",Font.PLAIN,18));
        lblAvailable.setBounds(60,110,150,30);
        add(lblAvailable);
       
        String Savilable[]={"Available","Occupied"};
        jcbavailable=new JComboBox(Savilable);
        jcbavailable.setBounds(200,110,180,30);
        add(jcbavailable);
        
         JLabel lblClean=new JLabel("Clean Staus");
        lblClean.setFont(new Font("serif",Font.PLAIN,18));
        lblClean.setBounds(60,160,150,30);
        add(lblClean);
       //CHECKING WEATHER THE ROOM IS CLEANED OR NOT
        String Sclean[]={"Cleaned","Dirty"};
        jcbcleaned=new JComboBox(Sclean);
        jcbcleaned.setBounds(200,160,180,30);
        add(jcbcleaned);
      
        //ADDING THE PRICE OF THE ROOM BASED ON LIKE SINGLE OR DOUBLE BED ROOM
        JLabel lblPrice=new JLabel("Price");
        lblPrice.setFont(new Font("serif",Font.PLAIN,18));
        lblPrice.setBounds(60,210,150,30);
        add(lblPrice);
        
        
        tfprice=new JTextField();
        tfprice.setBounds(200,210,180,30);
        add(tfprice);
        
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("serif",Font.PLAIN,18));
        lbltype.setBounds(60,260,150,30);
         add(lbltype);
         
          String Stype[]={"Single","Double"};
        jcbtype=new JComboBox(Stype);
        jcbtype.setBounds(200,260,180,30);
        add(jcbtype);
        //ADDING THE BUUTOON LIKE ADD ROOM AND CANCEL BUUTONS 
        add=new JButton("Add Room");
        add.setBounds(70,350,130,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(240,350,130,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
 
        setBounds(330,200,940,470);
     
        setVisible(true);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String roomnumber=tfroomno.getText();
            String availability=(String)jcbavailable.getSelectedItem();
            String status=(String)jcbcleaned.getSelectedItem();
            String price=tfprice.getText();
            String type=(String)jcbtype.getSelectedItem();
            
            try{
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                conn.s.execute(str);
                JOptionPane.showMessageDialog(null,"new room added sucessfully");
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
        }
        else{
            setVisible(false);
        }
      
    }
    
    public static void main(String[] args) {
        new AddRooms();
    }

    
            
    
}
