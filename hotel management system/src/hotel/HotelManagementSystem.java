package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem(){
//        setSize(1366,565);
//        setLocation(100,100);
        
        //INSERTING THE BACKGROUND IMAGE ON MAIN PAGE
        setBounds(100,100,1366,565);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);
        add(image);
        
        //CREATION OF HOTEL MANAGEMENT SYSTEM TEXT IN MAIN PAGE
        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(20,430,1000,90); 
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);
        
        //CREATING OF NEXT BUTTON IN THE MAIN PAGE
        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,30);
        next.setBackground(Color.white);
        next.setForeground(Color.green);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.BOLD,30));//name of font,font style,font 
        image.add(next);
    
        setVisible(true);
        
        //FOR HOTEL MANAGEMNET TEXT BLINKING
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            text.setVisible(true);
             try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    } 

    public static void main(String[] args) {
         HotelManagementSystem hm=new HotelManagementSystem();
    }
    //FOR PERFORMING ACTION ON NEXT KEYWORD
    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Login();

    }
    
}

 
