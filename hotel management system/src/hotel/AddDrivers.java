
package hotel.management.system;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AddDrivers extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox jcbgender,jcbavailable;
    JButton driver,cancel;
    AddDrivers(){
        setBounds(400,120,900,550);
        JLabel addname=new JLabel("Add Drivers");
        addname.setBounds(120,50,200,30);
        addname.setFont(new Font("serif",Font.BOLD,24));
        add(addname);
       
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,100,200,30);
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,100,200,30);
        add(tfname);
        
        JLabel lblage=new JLabel("Age");
        lblage.setBounds(50,150,200,30);
        lblage.setFont(new Font("serif",Font.PLAIN,20));
        add(lblage);
        
          
        tfage=new JTextField();
        tfage.setBounds(200,150,200,30);
        add(tfage);
        
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(50,200,200,30);
        lblgender.setFont(new Font("serif",Font.PLAIN,20));
        add(lblgender);
        
        String s[]={"Male","Female"};
        jcbgender =new JComboBox(s);
        jcbgender.setBounds(200,200,200,30);
        jcbgender.setFont(new Font("serif",Font.PLAIN,20));
        add(jcbgender);
        
        
        
        JLabel lblcompany=new JLabel("car company");
        lblcompany.setBounds(50,250,200,30);
        lblcompany.setFont(new Font("serif",Font.PLAIN,20));
        add(lblcompany);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(200,250,200,30);
        add(tfcompany);
        
        
        JLabel lblcarmodel=new JLabel("Car Model");
        lblcarmodel.setBounds(50,300,200,30);
        lblcarmodel.setFont(new Font("serif",Font.PLAIN,20));
        add(lblcarmodel);
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,300,200,30);
        add(tfmodel);
        
        JLabel lblavailable=new JLabel("Available");
        lblavailable.setBounds(50,350,200,30);
         lblavailable.setFont(new Font("serif",Font.PLAIN,20));
        add(lblavailable);
        
        String available[]={"Available","Occupied"};
        jcbavailable=new JComboBox(available);
        jcbavailable.setBounds(200,350,200,30);
        add(jcbavailable);
        
          
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setBounds(50,400,200,30);
         lbllocation.setFont(new Font("serif",Font.PLAIN,20));
        add(lbllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(200,400,200,30);
        add(tflocation);
        
        driver=new JButton("Add Driver");
        driver.setBounds(80,450,100,30);
        driver.setBackground(Color.BLACK);
        driver.setForeground(Color.WHITE);
        driver.addActionListener(this);
        add(driver);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(230,450,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,100,400,300);
        add(image);
        
        
        
        
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);   
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==driver){
       String Name=tfname.getText();
       String Age=tfage.getText();
       String Gender=(String)jcbgender.getSelectedItem();
       String carcompany=tfcompany.getText();
       String carmodel=tfmodel.getText();
       String Available=(String)jcbavailable.getSelectedItem();
       String Location=tflocation.getText();
        try{
            Conn conn=new Conn();
            String query="insert into drivers values ('"+Name+"', '"+Age+"', '"+Gender+"', '"+carcompany+"', '"+carmodel+"', '"+Available+"', '"+Location+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Driver added succesfully");
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
     
                
                }
        else if(ae.getSource()==cancel){
                setVisible(false);
                new Reception();
    }
    }
    
    public static void main(String[] args) {
        new AddDrivers();
        
    }

            
    
}
