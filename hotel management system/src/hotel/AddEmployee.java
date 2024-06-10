
package hotel.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname,tfphone,tfemail,tfaadhar,tfsalary,tfage;
    JRadioButton lbmale,lbfemale;
    JComboBox jcjob;
    JButton jsubmit,Back;
    
    AddEmployee() {
        setLayout(null);
        
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(60,30,120,30);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,180,30);
        add(tfname);
        
         JLabel lbage=new JLabel("Age");
        lbage.setBounds(60,80,120,30);
        lbage.setFont(new Font("serif",Font.BOLD,20));
        add(lbage);
        
        tfage=new JTextField();
        tfage.setBounds(200,80,180,30);
        add(tfage);
        
        JLabel lbgender=new JLabel("Gender");
        lbgender.setBounds(60,130,120,30);
         lbgender.setFont(new Font("serif",Font.BOLD,20));
        add(lbgender);
        
        lbmale=new JRadioButton("Male");
        lbmale.setBounds(200,130,80,30);
        lbmale.setBackground(Color.WHITE);
        add(lbmale);  
        
        lbfemale=new JRadioButton("Female");
        lbfemale.setBounds(300,130,80,30);
         lbfemale.setBackground(Color.WHITE);
        add(lbfemale);  
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(lbmale);
        bg.add(lbfemale);
        
        
        JLabel lbjob=new JLabel("Job");
        lbjob.setBounds(60,180,120,30);
         lbjob.setFont(new Font("serif",Font.BOLD,20));
        add(lbjob);
        
        String s[]={"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager"};
        jcjob=new JComboBox(s);
        jcjob.setBounds(200,180,180,30);
        jcjob.setBackground(Color.WHITE);
        add(jcjob);
        
        
        
        JLabel lbsalary=new JLabel("Salary");
        lbsalary.setBounds(60,230,120,30);
        lbsalary.setFont(new Font("serif",Font.BOLD,20));
        add(lbsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(200,230,180,30);
        add(tfsalary);
        
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(60,280,120,30);
        lbphone.setFont(new Font("serif",Font.BOLD,20));
        add(lbphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(200,280,180,30);
        add(tfphone);

        JLabel lbemail=new JLabel("Email");
        lbemail.setBounds(60,330,120,30);
        lbemail.setFont(new Font("serif",Font.BOLD,20));
        add(lbemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,330,180,30);
        add(tfemail);

        JLabel lbaadhar=new JLabel("Aadhar");
        lbaadhar.setBounds(60,380,120,30);
        lbaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,180,30);
        add(tfaadhar);
        
        jsubmit=new JButton("Submit");
        jsubmit.setBounds(120,440,100,30);
        jsubmit.addActionListener(this);
        add(jsubmit);
        
         
      
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,450);
        add(image);
        
        

        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
        
        String gender=null;
        if(lbmale.isSelected()){
            gender="male";
        }
        else if(lbfemale.isSelected()){
            gender="female";
        }
        String job=(String)jcjob.getSelectedItem();
        
        try{
            Conn conn=new Conn();
            String query="insert into employee values ('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added succesfully");
            setVisible(false);
            new Reception();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        
        
        
     
    }
    
    public static void main(String[] args) {
        new AddEmployee();
        
    }

    
}
