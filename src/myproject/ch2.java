
package myproject;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ch2  extends JInternalFrame
{
        my_sql_connection my_con=new my_sql_connection();
    
    private static String gnd;
  
    public DefaultTableModel dtablefill( String qry)
   {
       DefaultTableModel dt=null;
         try
    {
    Vector <String> col=new Vector <String>();
       Vector row=new Vector ();
    ResultSet rs=my_con.fetch_qry(qry);
    ResultSetMetaData rsd=rs.getMetaData();
    int colcount=rsd.getColumnCount();
    for(int i=1;i<=colcount;i++)
    {
    col.add(rsd.getColumnName(i));
    }
while(rs.next())
{
Vector<String> vt=new Vector<String>();
for(int j=1;j<=colcount;j++)
{
vt.add(rs.getString(j));
} 
row.add(vt);
}  
dt=new DefaultTableModel(row, col);
  
    }
         catch(Exception sk)
         {
         System.out.println(sk.getMessage());
         
         }
      
   return dt;
   }
   
 
        Font f1=new Font("Times New Roman", Font.BOLD,17);
        Font f2=new Font("Times New Roman", Font.ITALIC,17);
        JLabel j1,j2,j3,j4,j5,j6,j7,j8,jtitle,jsearch,gender;
        JTextField t1,t2,t3,t4,t5,t7,tsearch;
        JRadioButton jr,t6;
        JButton btn; JTable jtab;
        ButtonGroup jb;
       
        
    public ch2()
    {
        setTitle("home_page");
        jtitle=new JLabel("-: CUSTOMER INFORMATION :-");
        jtitle.setBounds(50,20,260,30);
        jtitle.setForeground(Color.blue);
        jtitle.setFont(f1);
        add(jtitle);
          
        jsearch=new JLabel("<search");
        jsearch.setBounds(535,30,150,30);
        jsearch.setForeground(Color.blue);
        jsearch.setFont(f1);
        add(jsearch);
      
        tsearch=new JTextField();
        tsearch.setBounds(380,30,150,30);
        tsearch.setBackground(Color.blue);
        tsearch.setForeground(Color.white);
        tsearch.setFont(f2);
        tsearch.addKeyListener(new KeyAdapter() 
        {
         public void keyReleased(KeyEvent e)
         {
             try{
         String qry="select cust_id,customer_name from customerinfo where customer_name like '"+tsearch.getText().trim()+"%' ";
        jtab.setModel(dtablefill(qry));
             }
         catch(Exception sk)
         {
         System.out.println(sk.getMessage());
         }
         }
        });
        add(tsearch); 
            
        btn=new JButton("Add");
        jtab=new JTable();
        jtab.setBounds(375,70,270,300);
        jtab.setBackground(Color.blue);
        jtab.setForeground(Color.white);
 
        ListSelectionModel list=jtab.getSelectionModel();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                     try
             {
           
                int index=jtab.getSelectedRow();
            String cust_id=jtab.getValueAt(index, 0).toString();
            String qry1="select * from customerinfo where cust_id='"+cust_id+"'";
           DefaultTableModel dft=dtablefill(qry1);
            btn.setText("Update"); 
            t1.setText(dft.getValueAt(0, 1).toString());
            t2.setText(dft.getValueAt(0, 2).toString());
            t3.setText(dft.getValueAt(0, 3).toString());
            t4.setText(dft.getValueAt(0, 4).toString());
            t5.setText(dft.getValueAt(0, 5).toString());
            String gender=dft.getValueAt(0, 6).toString();
           if(gender.equals("MALE"))
           {
           jr.setSelected(true);
           }
           else 
           {
            t6.setSelected(true);
           }
           
            t7.setText(dft.getValueAt(0, 7).toString());
           
             }
            
          catch(Exception sk)
            {}
            }  
            });
       
          add(jtab);
        JScrollPane jp=new JScrollPane(jtab);
        jp.setBackground(Color.MAGENTA);

         jp.setBounds(335,70,300,300);
         add(jp);
        j1=new JLabel("Customer's Name");
        j1.setBounds(20,60,150,30);
        j1.setForeground(Color.blue);
        j1.setFont(f2);
        add(j1);
        t1=new JTextField();
        t1.setBounds(170,60,150,30);
        t1.setBackground(Color.blue);
        t1.setForeground(Color.white);
        t1.setFont(f2);
        add(t1);
        
        j2=new JLabel("Address");
        j2.setBounds(20,100,150,30);
        j2.setForeground(Color.blue);
        j2.setFont(f2);
        add(j2);
        t2=new JTextField();
        t2.setBounds(170,100,150,30);
        t2.setBackground(Color.blue);
        t2.setForeground(Color.white);
        t2.setFont(f2);
        add(t2);
        
        j3=new JLabel("Post Code");
        j3.setBounds(20,140,150,30);
        j3.setForeground(Color.blue);
        j3.setFont(f2);
        add(j3);
        t3=new JTextField();
        t3.setBounds(170,140,150,30);
        t3.setBackground(Color.blue);
        t3.setForeground(Color.white);
        t3.setFont(f2);
        add(t3);
        
          j4=new JLabel("Mobile");
        j4.setBounds(20,180,150,30);
        j4.setForeground(Color.blue);
        j4.setFont(f2);
        add(j4);
        t4=new JTextField();
        t4.setBounds(170,180,150,30);
        t4.setBackground(Color.blue);
        t4.setForeground(Color.white);
        t4.setFont(f2);
        add(t4);
        
          j5=new JLabel("Email");
        j5.setBounds(20,220,150,30);
        j5.setForeground(Color.blue);
        j5.setFont(f2);
        add(j5);
        t5=new JTextField();
        t5.setBounds(170,220,150,30);
        t5.setBackground(Color.blue);
        t5.setForeground(Color.white);
        t5.setFont(f2);
        add(t5);
        
        gender=new JLabel("Gender");
        gender.setForeground(Color.blue);
        gender.setBounds(20,260,100,30);
         add(gender);
         
        jr=new JRadioButton("MALE");
         jr.setSelected(true);
        jr.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e)
             {
          if(jr.isSelected())
           {
                 gnd=jr.getText();
           }
             }
         });
        jr.setBounds(120,260,100,30);
        jr.setForeground(Color.blue);
        jr.setFont(f2);
        add(jr);
        
        t6=new JRadioButton("FEMALE");
        t6.setSelected(true);
        t6.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 if(t6.isSelected())
                 {
                      gnd=t6.getName();
             }
             }
         });
        t6.setBounds(220,260,100,30);
        t6.setForeground(Color.blue);
        t6.setFont(f2);
        add(t6);
        jb=new ButtonGroup();
        jb.add(jr);
        jb.add(t6);
       
         j7=new JLabel("Active Type");
        j7.setBounds(20,300,150,30);
        j7.setForeground(Color.blue);
        j7.setFont(f2);
        add(j7);
        t7=new JTextField();
        t7.setBounds(170,300,150,30);
        t7.setBackground(Color.blue);
        t7.setForeground(Color.white);
        t7.setFont(f2);
        add(t7);
        
          j8=new JLabel("-----");
        j8.setBounds(120,380,250,30);
        j8.setForeground(Color.blue);
        j8.setFont(f2);
        add(j8);
        
        btn.setBounds(120,340,150,30);
        btn.setForeground(Color.blue);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 try
                {
                if(btn.getText()=="Add")
                {
               
                    String qryy="insert into customerinfo(customer_name,Address,postcode,mobile,email,Gender,ActiveType) values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+gnd+"','"+t7.getText()+"')";
                int st=my_con.Update_qry(qryy);
                if(st==1)
                {
                j8.setText("Successfully added");
                String qry1="select cust_id,customer_name from customerinfo order by cust_id desc limit 10";
                jtab.setModel(dtablefill(qry1));
                }
               else
                {
                j8.setText("not added");
                }
                }
               
                
                else if(btn.getText()=="Update")
                {
                   
                String qryu="update customerinfo set customer_name='"+t1.getText()+"',Address='"+t2.getText()+"',postcode='"+t3.getText()+"',mobile='"+t4.getText()+"',email='"+t5.getText()+"',Gender='"+gnd+"',ActiveType='"+t7.getText()+"' where cust_id='"+jtab.getValueAt(jtab.getSelectedRow(), 0)+"'";
                int st= my_con.Update_qry(qryu);
                        if(st==1)
                {
                j8.setText("Successfully Updated");
                 t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t5.setText(null);
                jr.setSelected(true);
                t4.setText(null);
                t7.setText(null);
                btn.setText("Add");
                String qry1="select cust_id,customer_name from customerinfo order by cust_id limit 10";
                jtab.setModel(dtablefill(qry1));
                }
                 else
                {
                j8.setText("not Updated");
                }        
                }
                else
                {
                j8.setText("error");
                }
            }   
                    catch(Exception sk)
                    {
                    
                    }
                
            }
        } );

        setBounds(10,10,650,700);
        setLayout(null);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setVisible(true);
    }
}
