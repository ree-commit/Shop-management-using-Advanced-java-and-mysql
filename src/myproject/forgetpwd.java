
package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class forgetpwd extends JFrame
{
   my_sql_connection my_con=new my_sql_connection();
    public forgetpwd()
    {
    work();
    }
    public void work()
    {
        JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl;
        JButton jb1,jb2,jb3;
        JTextField jt1,jt2,jt3;
        setTitle("fogotten password");
        Font f1=new Font("Times New Roman", Font.BOLD,21);
        Font f2=new Font("Times New Roman", Font.ITALIC,18);
        setTitle("log in page");
        jl1=new JLabel("Change Your PassWord Here");
        jl1.setBounds(130,50,300,40);
        jl1.setForeground(Color.blue);
        jl1.setFont(f1);
        add(jl1);
        
         jl2=new JLabel("Enter Your Correct E-mail");
        jl2.setBounds(20,100,250,30);
        jl2.setForeground(Color.blue);
        jl2.setFont(f2);
        add(jl2);
        jt1=new JTextField();
        jt1.setBounds(280,100,180,30);
        jt1.setForeground(Color.blue);
        jt1.setFont(f2);
        add(jt1);
        
        jl3=new JLabel("Enter Correct Security Question");
        jl3.setBounds(20,140,250,30);
        jl3.setForeground(Color.blue);
        jl3.setFont(f2);
        add(jl3);
        jt2=new JTextField();
        jt2.setBounds(280,140,180,30);
        jt2.setForeground(Color.blue);
        jt2.setFont(f2);
        add(jt2);
        
        jl4=new JLabel("Enter Correct Security Answer");
        jl4.setBounds(20,180,250,30);
        jl4.setForeground(Color.blue);
        jl4.setFont(f2);
        add(jl4);
        jt3=new JTextField();
        jt3.setBounds(280,180,180,30);
        jt3.setForeground(Color.blue);
        jt3.setFont(f2);
        add(jt3);
        
        jl5=new JLabel();
        jl5.setBounds(150,260,200,30);
        jl5.setFont(f2);
        jl5.setVisible(false);
        add(jl5);
         
        jl6=new JLabel();
        jl6.setBounds(150,300,200,30);
        jl6.setFont(f2);
        jl6.setForeground(Color.red);
        jl6.setVisible(false);
        add(jl6);
        
        jl=new JLabel();
        jl.setBounds(150,380,300,30);
        jl.setVisible(false);
        jl.setFont(f2);
        jl.setForeground(Color.red);
        add(jl);
         jb3=new JButton("back");
        jb3.setBounds(20,10,120,30);
        jb3.setVisible(true);
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                new login_page();
            }
        });
        add(jb3);
        
         jb2=new JButton("new login");
        jb2.setBounds(150,340,150,30);
        jb2.setVisible(false);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                new login_page();
            }
        });
        add(jb2);
       
        
        jb1=new JButton("Recover Password");
        jb1.setBounds(190,230,150,30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
           String Email=jt1.getText();
           String SQ=jt2.getText();
           String SA=jt3.getText();


    try
    {
String qry="Select user,pwd from logininfo where email='"+Email+"' and SQ='"+SQ+"' and SA='"+SA+"'";
ResultSet rs=my_con.fetch_qry(qry);
if(rs.next())
{   
 String user=rs.getString("user");
 String pwd=rs.getString("pwd");
jl5.setText("");

int b=JOptionPane.showConfirmDialog(null,"Password Successfully Recovered :to show click yes");
if(b==JOptionPane.YES_OPTION)
{
jl5.setText("username:"+user);
jl5.setVisible(true);
jl6.setText("Password:"+pwd);
jl6.setVisible(true);
jb2.setVisible(true);
jl.setVisible(true);
jl.setText("for confirmation log in again");
}
}
else
{
jl5.setText("invalid info");
jl5.setForeground(Color.red);

jl5.setVisible(true);

}
    }
catch(Exception sk)
{
JOptionPane.showMessageDialog(null,"error is"+sk.getMessage());
}
          
            }
        });
        add(jb1);
        
       
        setBounds(0,0,800,700);
        setLayout(null);
        setVisible(true);
    }
    
}
