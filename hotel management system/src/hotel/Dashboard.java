
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);
        //SETTING THE BACKGROUND IMAGE TO THE PAGE
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,100);
        add(image);
        
        //ADDING THE CONTEXT TO THE PAGE ON TOP
        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("serif",Font.PLAIN,46));
        text.setForeground(Color.red);
        image.add(text);
        
        //ADDING MENU BAR ON TOP
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        //ADDING MENUITEMS IN THE MENU BAR
        JMenu hotel=new JMenu("Hotel management");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        JMenu Admin=new JMenu("Admin");
        Admin.setForeground(Color.blue);
        mb.add(Admin);
        
        //ADDING THE MENU ITEMS INSIDE THE MENU BAR
        JMenuItem Reception=new JMenuItem("Reception");
        Reception.addActionListener(this);
        hotel.add(Reception);
        
        JMenuItem AddEmployee=new JMenuItem("AddEmployee");
        AddEmployee.addActionListener(this);
        Admin.add(AddEmployee);
        
        JMenuItem AddRooms=new JMenuItem("AddRooms");
        AddRooms.addActionListener(this);
        Admin.add(AddRooms);
        
         JMenuItem AddDrivers=new JMenuItem("AddDrivers");
        AddDrivers.addActionListener(this);
        Admin.add(AddDrivers);
        
     
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("AddEmployee")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("AddRooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
        else if(ae.getActionCommand().equals("AddDrivers")){
             new AddDrivers();
    }

    }
    public static void main(String[] args) {
        Dashboard d=new Dashboard();
    }

    

}

