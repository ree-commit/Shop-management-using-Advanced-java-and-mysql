
package myproject;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;
public class buyed_Item_information_table  extends JFrame
{
    private JTable jtab;
    private JScrollPane jp;
    private JLabel j1,j2;
    
    public buyed_Item_information_table(DefaultTableModel dtm,String cname,String date)
    {
   
        DefaultTableModel dftm=dtm;
    
        Font f1=new Font("Times New Roman", Font.BOLD,18);
        Font f2=new Font("Times New Roman", Font.ITALIC,17);
        
        setTitle("bill of the customer");
        jtab=new JTable();
        jp=new JScrollPane(jtab);
        jtab.setBackground(Color.blue);
        jtab.setForeground(Color.white);
        jtab.setEnabled(false);
        jtab.setModel(dftm);
        jp.setBounds(50,90,700,500);
        add(jp);
        j1=new JLabel("buyer : " +cname);
        j1.setFont(f1);
        j1.setForeground(Color.blue);
        j1.setBounds(100,10,250,30);
        add(j1);
         j2=new JLabel("Date : " +date);
        j2.setFont(f1);
        j2.setForeground(Color.blue);
        j2.setBounds(360,10,250,30);
        add(j2);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(0,0,800,700);
        setLayout(null);
        setVisible(true);
    }
}
