
package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ch1 extends JInternalFrame
{  
    my_sql_connection my_con=new my_sql_connection();
    public int status;
    public ch1()
    {
       
        JLabel jl1,jl2,jl3,jl4,jl5,jl6;
        JTextField jt1,jt2,jt3,jt4,jt5,jt6;
        JButton jb1;
    setTitle("home_page");
        jl1=new JLabel("user");
        jl1.setBounds(100,50,150,30);
        add(jl1);
        jt1=new JTextField();
        jt1.setBounds(260,50,150,30);
        add(jt1);
                
        jl2=new JLabel("password");
        jl2.setBounds(100,100,150,30);
        add(jl2);
        jt2=new JTextField();
        jt2.setBounds(260,100,150,30);
        add(jt2);
                
        jl3=new JLabel("email");
        jl3.setBounds(100,140,150,30);
        add(jl3);
        jt3=new JTextField();
        jt3.setBounds(260,140,150,30);
        add(jt3);
                
         jl4=new JLabel("security question");
        jl4.setBounds(100,180,150,30);
        add(jl4);
        jt4=new JTextField();
        jt4.setBounds(260,180,150,30);
        add(jt4);   
        
         jl5=new JLabel("security Answer");
        jl5.setBounds(100,220,150,30);
        add(jl5);
        jt5=new JTextField();
        jt5.setBounds(260,220,150,30);
        add(jt5);
        
        
        
        jb1=new JButton("Update");
        jb1.setBounds(240,260,150,30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String user=jt1.getText();
                String pwd=jt2.getText();
                String email=jt3.getText();
                String SQ=jt4.getText();
                String SA=jt5.getText();
                
     try
    {
String qry="update logininfo set user='"+user+"',pwd='"+pwd+"',email='"+email+"',SQ='"+SQ+"',SA='"+SA+"' where logid='1'" ;
int status=my_con.Update_qry(qry);
if(status==1)
{
    jt1.setText("");
    jt2.setText("");
    jt3.setText("");
    jt4.setText("");
    jt5.setText("");

JOptionPane.showMessageDialog(null,"data updated successfully"); 
dispose();


}
else
{
JOptionPane.showMessageDialog(null, "Sorry,please try again");
}
    }
    catch(Exception sk)
    {
        JOptionPane.showMessageDialog(null, "error is"+sk.getMessage());

    }
 }
        });
        add(jb1);
         
         
        
     setBounds(10,10,450,500);
    setLayout(null);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
    setVisible(true);
    }
}
