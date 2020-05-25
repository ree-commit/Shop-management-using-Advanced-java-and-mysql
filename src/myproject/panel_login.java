
package myproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class panel_login extends JFrame
{
     JLabel jl1,jl2,jl3,jl4;
        JButton jb1,jb2;
        JTextField jt1;
        JPasswordField jt2;
        JPanel jpan;
    static int hz=550,vz=600;
    public panel_login()
    {
        Font f1=new Font("Times New Roman", Font.BOLD,21);
        Font f2=new Font("Times New Roman", Font.ITALIC,18);
        setTitle("log in page");
        jpan=new JPanel();
        jl1=new JLabel("Log In With Us");
        jl1.setBounds(200,50,200,50);
        jl1.setForeground(Color.blue);
        jl1.setFont(f1);
        jpan.add(jl1);
        add(jl1);
                
        jl2=new JLabel("User name");
        jl2.setBounds(100,110,150,30);
        jl2.setForeground(Color.blue);
        jl2.setFont(f2);
        jpan.add(jl2);
        add(jl2);
        jt1=new JTextField();
        jt1.setBounds(260,110,150,30);
        jt1.setForeground(Color.blue);
        jt1.setFont(f2);
        jpan.add(jt1);
        add(jt1);
        jl3=new JLabel("password");
        jl3.setBounds(100,150,150,30);
        jl3.setForeground(Color.blue);
        jl3.setFont(f2);
        jpan.add(jl3);
        add(jl3);
        jt2=new JPasswordField();
        jt2.setBounds(260,150,150,30);
        jt2.setForeground(Color.blue);
        jt2.setFont(f2);
       jpan. add(jt2);
       add(jt2);
        jl4=new JLabel("------");
        jl4.setBounds(150,260,250,30);
        jl4.setForeground(Color.red);
        jl4.setFont(f2);
       jpan. add(jl4);
       add(jl4);
        jb1=new JButton("Login");
        jb1.setBounds(130,220,100,30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
           String user=jt1.getText().toString();
           String password=jt2.getText().toString();

           String qry="Select logid from logininfo where user='"+user+"' and pwd='"+password+"'";

    try
    {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/myproject","root","12345");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qry);
if(rs.next())
{    
jl4.setText("successful");
dispose();
 new mdi_page();
}
else
{
jl4.setText("invalid user and password");
}
}
catch(Exception sk)
{
//JOptionPane.showMessageDialog(null,"error is"+sk.getMessage());
}
          
            }
        });
       jpan. add(jb1);
       add(jb1);
        
        jb2=new JButton("Forget Password");
        jb2.setBounds(270,220,150,30);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                new forgetpwd();
            }
        });
        jpan.add(jb2);  
        add(jb2);
       jpan.setBounds(60,60,hz-100,vz-300);
       JPanel jpan1=new JPanel();
       jpan.setBackground(Color.CYAN);
       jpan1.setBackground(Color.magenta);
       jpan1.setBounds(30,30,hz-50,vz-200);
       jpan1.add(jpan);
       add(jpan);
       
       add(jpan1);
       getContentPane().setBackground(Color.blue);
        
        setBounds(100,100,hz,vz);
        setLayout(null);
        setVisible(true);
    
    }
    
}
