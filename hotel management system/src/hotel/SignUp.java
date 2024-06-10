
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class SignUp extends JFrame implements ActionListener{
    JButton submit;
    JTextField tfusername,tfpassword;
    SignUp(){
        
        JLabel Heading=new JLabel("Sign Up Portal");
        Heading.setBounds(180,50,200,30);
        Heading.setFont(new Font("serif",Font.BOLD,24));
        add(Heading);
        
        
        JLabel Username=new JLabel("Username");
        Username.setBounds(100,100,150,30);
        Username.setFont(new Font("serif",Font.PLAIN,20));
        add(Username);
        
        tfusername=new JTextField();
        tfusername.setBounds(250,100,200,30);
        add(tfusername);
        
        JLabel password=new JLabel("Password");
        password.setBounds(100,150,150,30);
        password.setFont(new Font("serif",Font.PLAIN,20));
        add(password);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(250,150,200,30);
        add(tfpassword);
        
         submit=new JButton("Sign Up");
        submit.setBounds(200,200,100,30);
        submit.setFont(new Font("serif",Font.BOLD,16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
     setLayout(null);   
  getContentPane().setBackground(Color.WHITE);
setBounds(500,200,500,300);
setVisible(true);
        
    }
    public static void main(String[] args) {
        new SignUp();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==submit){
         String username=tfusername.getText();
        String password=tfpassword.getText();
           try{
           Conn conn=new Conn();
           String str="insert into login values('"+username+"','"+password+"') ";
           conn.s.execute(str);
           JOptionPane.showMessageDialog(null,"Sign up successfully");
           }
           catch(Exception ae){
               ae.printStackTrace();
           }

           
       }
    }
            
    
    
}
