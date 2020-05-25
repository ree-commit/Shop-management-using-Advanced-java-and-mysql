
package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mdi_page extends JFrame
{
    
    Font f1=new Font("Times New Roman", Font.BOLD, 17);
    JMenuBar jmb;
    JMenu jm1,jm2,jm3,jm4,jm5;
     JMenuItem jmt1,jmt11,jmt2,jmt3,jmt4,jmt5;       
    public mdi_page()
    {
        
        setTitle("new customer page");
        JLabel jl1=new JLabel("Welcome to This Page");
        jl1.setBounds(50,40,300,30);
        add(jl1);
        jmb=new JMenuBar();
        jmb.setBackground(Color.blue);

        jm1=new JMenu("HOME");
        jm1.setFont(f1);
        jm1.setForeground(Color.white);

        jmt1=new JMenuItem("Edit info");
        jm1.add(jmt1);
        final JDesktopPane obj=new JDesktopPane();
        setContentPane(obj);
        jmt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               ch1 c1=new ch1();
               obj.add(c1,BorderLayout.CENTER);
               
             
            }
        });        
         
        jmb.add(jm1);
        JMenuItem jmt11=new JMenuItem("bill_info");
         jmt11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              new bill_info();
            }
        });   
        jm1.add(jmt11);
        
        jm2=new JMenu("ADD ITEM");
        jm2.setFont(f1);
        jm2.setForeground(Color.white);
        
        jmt2=new JMenuItem("Add items");
        jmt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ch3 c3=new ch3(); 
                obj.add(c3,BorderLayout.CENTER);

            }
        });
        jm2.add(jmt2);
       
        jmb.add(jm2);
        
        jm3=new JMenu("ADD CUSTOMER");
        jm3.setFont(f1);
        jm3.setForeground(Color.white);

        jmb.add(jm3);
        jmt3=new JMenuItem("Add customer");

        jmt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ch2 c2=new ch2(); 
                obj.add(c2,BorderLayout.CENTER);

            }
        });
        jm3.add(jmt3);
        
        jm4=new JMenu("SELL Product");
        jm4.setFont(f1);
        jm4.setForeground(Color.white);

        jmb.add(jm4);
        jmt4=new JMenuItem("Click");

        jmt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new sale_product();

            }
        });
        jm4.add(jmt4);
        
        jm5=new JMenu("EXIT");
        jmt5=new JMenuItem("click");
        jmt5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new login_page();
            }
        });
        jm5.add(jmt5);
        jm5.setFont(f1);
        jmb.add(jm5);
        jm5.setForeground(Color.white);

        setJMenuBar(jmb);
        add(jmb);
        
      
        setBounds(0,0,800,700);
        setLayout(null);
        setVisible(true);
    }
}
