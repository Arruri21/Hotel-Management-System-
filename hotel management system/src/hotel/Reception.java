
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception extends JFrame implements ActionListener{
         JButton customer,Rooms,Department,Allemployees,customerinfo,
                 checkout,Managerinfo,search,Updateroom,pickup,UpdateStatus,logout,Back;
Reception(){
    
    
    Back =new JButton("Back");
    Back.setBounds(10,10,70,20);
    Back.setFont(new Font("serif",Font.PLAIN,16));
    Back.setForeground(Color.WHITE);
    Back.setBackground(Color.BLACK);
    Back.addActionListener(this);
    add(Back);
    customer=new JButton("New Customer Form");
    customer.setBounds(10,40,200,30);
    customer.setFont(new Font("serif",Font.PLAIN,16));
    customer.setForeground(Color.WHITE);
    customer.setBackground(Color.BLACK);
    customer.addActionListener(this);
    add(customer);
    
    Rooms =new JButton("Rooms");
    Rooms.setBounds(10,80,200,30);
    Rooms.setFont(new Font("serif",Font.PLAIN,16));
    Rooms.setForeground(Color.WHITE);
    Rooms.setBackground(Color.BLACK);
    Rooms.addActionListener(this);

    add(Rooms);
    
    Department =new JButton("Department");
    Department.setBounds(10,130,200,30);
    Department.setFont(new Font("serif",Font.PLAIN,16));
    Department.setForeground(Color.WHITE);
    Department.setBackground(Color.BLACK);
    Department.addActionListener(this);
    add(Department);
    
    Allemployees =new JButton("All Employees");
    Allemployees.setBounds(10,180,200,30);
    Allemployees.setFont(new Font("serif",Font.PLAIN,16));
    Allemployees.setForeground(Color.WHITE);
    Allemployees.setBackground(Color.BLACK);
    Allemployees.addActionListener(this);
    add(Allemployees);
    
    customerinfo =new JButton("Customer Info");
    customerinfo.setBounds(10,230,200,30);
    customerinfo.setFont(new Font("serif",Font.PLAIN,16));
    customerinfo.setForeground(Color.WHITE);
    customerinfo.setBackground(Color.BLACK);
    customerinfo.addActionListener(this);
    add(customerinfo);
    
    Managerinfo =new JButton("Manager Info");
    Managerinfo.setBounds(10,280,200,30);
    Managerinfo.setFont(new Font("serif",Font.PLAIN,16));
    Managerinfo.setForeground(Color.WHITE);
    Managerinfo.setBackground(Color.BLACK);
    Managerinfo.addActionListener(this);
    add(Managerinfo);
    
    checkout =new JButton("Checkout");
    checkout.setBounds(10,330,200,30);
    checkout.setFont(new Font("serif",Font.PLAIN,16));
    checkout.setForeground(Color.WHITE);
    checkout.setBackground(Color.BLACK);
    checkout.addActionListener(this);
    add(checkout);
    
    UpdateStatus =new JButton("Update Status");
    UpdateStatus.setBounds(10,380,200,30);
    UpdateStatus.setFont(new Font("serif",Font.PLAIN,16));
    UpdateStatus.setForeground(Color.WHITE);
    UpdateStatus.setBackground(Color.BLACK);
      UpdateStatus.addActionListener(this);
    add(UpdateStatus);
    
    
    Updateroom =new JButton("Update Room Status");
    Updateroom.setBounds(10,430,200,30);
    Updateroom.setFont(new Font("serif",Font.PLAIN,16));
    Updateroom.setForeground(Color.WHITE);
    Updateroom.setBackground(Color.BLACK);
    Updateroom.addActionListener(this);
    add(Updateroom);
    
    pickup =new JButton("Pickup Service");
    pickup.setBounds(10,480,200,30);
    pickup.setFont(new Font("serif",Font.PLAIN,16));
    pickup.setForeground(Color.WHITE);
    pickup.setBackground(Color.BLACK);
    pickup.addActionListener(this);
    add(pickup);
    
    search =new JButton("Search Room");
    search.setBounds(10,530,200,30);
    search.setFont(new Font("serif",Font.PLAIN,16));
    search.setForeground(Color.WHITE);
    search.setBackground(Color.BLACK);
    search.addActionListener(this);

    add(search);
    
    logout =new JButton("Logout");
    logout.setBounds(10,580,200,30);
    logout.setFont(new Font("serif",Font.PLAIN,16));
    logout.setForeground(Color.WHITE);
    logout.setBackground(Color.BLACK);
    logout.addActionListener(this);
    add(logout);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
    JLabel image=new JLabel(i1);
    image.setBounds(250,80,500,400);
    add(image);
    
    



    
    
     setBounds(350,50,800,700);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setVisible(true);
    
    }

 @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==customer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==Rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==Department){
            setVisible(false);
            new Department();
        }
         else if(ae.getSource()==Allemployees){
            setVisible(false);
            new EmployeeInfo();
        }
          else if(ae.getSource()==customerinfo){
          setVisible(false);
          new CustomerInfo();
        }
         else if(ae.getSource()==Managerinfo){
          setVisible(false);
          new ManagerInfo();
        }
        else if(ae.getSource()==search){
          setVisible(false);
          new SearchRoom();
        }
         else if(ae.getSource()==UpdateStatus){
          setVisible(false);
          new UpdateCheckout();
        }
        else if(ae.getSource()==Updateroom){
          setVisible(false);
          new UpdateRoom();
        }
            else if(ae.getSource()==pickup){
          setVisible(false);
          new Updatepickup();
        }
        else if(ae.getSource()==checkout){
          setVisible(false);
          new Checkout();
        }
        else if(ae.getSource()==logout){
          setVisible(false);
          new Login();
        }
         else if(ae.getSource()==Back){
          setVisible(false);
          new Dashboard();
        }
        
     
    }
    public static void main(String[] args) {
        
        new Reception();
        
    }

   
}
