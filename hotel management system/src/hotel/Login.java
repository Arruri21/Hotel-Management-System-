
package hotel.management.system;

import com.mysql.cj.protocol.Resultset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{ 
     JTextField username;
     JPasswordField password;
        JButton login,Cancel,User;
    
    Login(){
        
       
        
        //CRAETION OF LOGIN FORM 
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(500,200,600,300);//from left how much dist,from top how much dist,length of frame ,width of frame
        
        //CREATION USERNAME TEXT
        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        //CREATION OF EMPTY FIELD
        username=new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        //CREATION USERNAME TEXT
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        //CREATION OF EMPTY FIELD
        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        //CRAETION OF LOGIN BUTTON
        login =new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        //CRAETION OF LOGIN BUTTON
        Cancel =new JButton("cancel");
        Cancel.setBounds(180,150,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);
        
        JLabel newuser=new JLabel("New User???");
        newuser.setBounds(50,190,100,30);
        newuser.setFont(new Font("serif",Font.PLAIN,16));
        add(newuser);

        
        User =new JButton("Sign Up");
        User.setBounds(180,190,120,30);
        User.setBackground(Color.BLACK);
        User.setForeground(Color.WHITE);
        User.addActionListener(this);
        add(User);
        
        //ADDING A IMAGE TO LOGIN FORM
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);
        
        
         
        
        
        
        
        
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Login l=new Login();
        
    }

 
    public void actionPerformed(ActionEvent ae) {
      
        if(ae.getSource()== login){
            String user=username.getText();
            String pass=password.getText();
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+user+"' and password ='"+pass+"'";
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    Dashboard dashboard = new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
    }
        else if(ae.getSource()== Cancel){
            setVisible(false);
            
        }
        else if(ae.getSource()==User){
        setVisible(false);
        new SignUp();
    }
    
    
}
}