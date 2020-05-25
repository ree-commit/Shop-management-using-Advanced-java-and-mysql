
package myproject;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.text.*;
public class sale_product extends JFrame
{
      my_sql_connection my_con=new my_sql_connection();
     int bill_no;
    JLabel jl1,jname,jaddress,jmob,iprice,idis,itax,t1,t2,t3,t4,note,qntl;
    JTextField cinfo,cname,jt1,jt2,ji1,ji2,ji3,tot,dis,tax,net,qnt;
    JButton btn,total,home;
    JComboBox items;
    JList list;
    JTable jtab;
    JScrollPane jlp,jtp,jcp;
    SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date=new java.util.Date();

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
      
  
  
 public DefaultListModel fill_list(String qry)
 {
  DefaultListModel<String> l1=new DefaultListModel<String>();
 try
          {
          ResultSet rs=my_con.fetch_qry(qry);
          while(rs.next())
          {
          l1.addElement(rs.getString(1));
          }
          }
        catch(Exception sk)
          {
          JOptionPane.showMessageDialog(null,"error is"+sk.getMessage());
          }
  
       return l1;
          }
 
    public Vector comboitems()
    {
    Vector<String> comboitems=new Vector<>();
    
     try
          {
         String qry="select itname from iteminfo ";
          ResultSet rs=my_con.fetch_qry(qry);
          while(rs.next())
          {
          comboitems.addElement(rs.getString(1));
          }
          }
        catch(Exception sk)
          {
          JOptionPane.showMessageDialog(null,"error is"+sk.getMessage());
          }

    
    
    return comboitems;
    }
    
  public sale_product()
  {
      setTitle("product salling page");
      
      home=new JButton("<-home");
      home.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) 
          {
               new mdi_page();
              dispose();
          }
      });
      home.setBounds(10,10,80,20);
      add(home);
      
      jl1=new JLabel("Sale Product");
      jl1.setBounds(200,10,200,30);
      add(jl1);
       
      list=new JList();
      jlp=new JScrollPane(list);
      jlp.setBounds(10,90,200,100);
        add(jlp);
      cinfo=new JTextField("");
      cinfo.addKeyListener(new KeyAdapter() 
      {
          public void keyReleased(KeyEvent e)
          {
        
         String qry="select customer_name from customerinfo where (customer_name like '"+cinfo.getText().trim()+"%') or (Address like '"+cinfo.getText().trim()+"%') or (mobile like '"+cinfo.getText().trim()+"%')";
        list.setModel(fill_list(qry));
          }
                   
});
      cinfo.setBounds(10,50,150,30);
      add(cinfo);
      jname=new JLabel("customer name");
      jname.setBounds(525,50,150,30);
      add(jname);
      
      cname=new JTextField(null);
      cname.setBounds(630,50,150,30);
      add(cname);
      
       jaddress=new JLabel("Address");
      jaddress.setBounds(525,85,150,30);
      add(jaddress);
      
       jt1=new JTextField(null);
      jt1.setBounds(630,85,150,30);
      add(jt1);
      
       jmob=new JLabel("Mobile");
      jmob.setBounds(525,120,150,30);
      add(jmob);
      
      jt2=new JTextField(null);
      jt2.setBounds(630,120,150,30);
      add(jt2);
      
      list.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) 
          {
              try
              {
              String qry="select customer_name,Address,mobile from customerinfo where (customer_name like '"+list.getSelectedValue()+"%')";
              ResultSet rs=my_con.fetch_qry(qry);
              while(rs.next())
              {
               cname.setText(rs.getString(1));
               jt1.setText(rs.getString(2));
               jt2.setText(rs.getString(3));
              }
              }
              catch(Exception sk)
              {
              
              }
          }
      });
     
      items=new JComboBox(comboitems());
      jcp=new JScrollPane(items);
      jcp.setBounds(345,50,170,30);
      items.setEditable(false);
      items.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int ind=items.getSelectedIndex();
                  try
              {
              String qry="select price,discount,GST from iteminfo where itname='"+items.getItemAt(ind)+"' ";
               ResultSet rs=my_con.fetch_qry(qry);
              while(rs.next())
              {
               ji1.setText(rs.getString(1));
               ji2.setText(rs.getString(2));
               ji3.setText(rs.getString(3));
              }
              }
              catch(Exception sk)
              {
              
              }
           
               // j2.setText(items.getItemAt(ind).toString());
            }
        });
   
      add(jcp);
      
      
      iprice=new JLabel("prize");
      iprice.setBounds(525,195,100,30);
      add(iprice);
      
      ji1=new JTextField();
      ji1.setBounds(630,195,120,30);
      add(ji1);
     
      idis=new JLabel("discount");
      idis.setBounds(525,230,100,30);
      add(idis);
      
      ji2=new JTextField();
      ji2.setBounds(630,230,120,30);
      add(ji2);
      
      itax=new JLabel("GST");
      itax.setBounds(525,265,100,30);
      add(itax);
      
      ji3=new JTextField();
      ji3.setBounds(630,265,120,30);
      add(ji3);
      
      note=new JLabel();
      note.setForeground(Color.red);
      note.setBounds(440,385,250,30);
      add(note);
      
      qntl=new JLabel("Enter quantity");
      qntl.setBounds(525,315,120,30);
      add(qntl);
      
       qnt=new JTextField();
      qnt.setBounds(650,315,100,30);
      add(qnt);
      
      btn=new JButton("add");
      btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) 
          {
             
             if((cname.getText().length()!=0) && (jt1.getText().length()!=0) && (jt2.getText().length()!=0))
             {  
                 if((ji1.getText().length()!=0) && (ji2.getText().length()!=0) && (ji3.getText().length()!=0)&&(qnt.getText().length()!=0) )
                 {
                   
                    try{
                     String qry1="select max(bill_no) from bill_info";
                     ResultSet rs=my_con.fetch_qry(qry1);
                  
                       if(rs.next())
                     {
                         String b=rs.getString(1);
                       if(b==null)
                       {
                       bill_no=1;
                       }
                       else
                       {
                     bill_no=Integer.parseInt(rs.getString(1));
                     bill_no=bill_no+1;
                     System.out.println(bill_no);
                       }

                    }
                  
                     String qry2="insert into buy_items(bill_no,it_name,price,discount,GST,Qnt) values('"+bill_no+"','"+items.getSelectedItem()+"','"+ji1.getText()+"','"+ji2.getText()+"','"+ji3.getText()+"','"+qnt.getText()+"')";
                    JOptionPane.showMessageDialog(null, qry2);
                     int Status=my_con.Update_qry(qry2);
                    
                    if(Status==1)
                    {
                    note.setText("successfully added");
                     String qry="select bill_no,it_name,price,discount,GST,Qnt from buy_items where bill_no='"+bill_no+"'";
                    jtab.setModel(dtablefill(qry));
                    total.setText("Total");
                    }
                    }
                    catch(Exception sk)
                    {
                    JOptionPane.showMessageDialog(null, sk.getMessage());
                    }
                   
                    
                 }
                  else
             {
             note.setText("Please, Select an item from combobox or qnt");
             }
             
             }
             else
             {
             note.setText("Please, Select customer from list");
             }
         
        
             

          }
        
      });
      btn.setBounds(500,350,100,30);
      add(btn);
      
      
      jtab=new JTable();
      jtab.setEnabled(false);
      jtp=new JScrollPane(jtab);
      jtp.setBounds(10,200,320,300);
      
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
          
             }
            
          catch(Exception sk)
            {}
            }  
            });
       
       
      
      add(jtp);
      
      total=new JButton();
      total.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) 
          {
              if(total.getText()=="Total")
              {
              String qry="select sum(price * Qnt),sum(discount * Qnt),sum(GST * Qnt) from buy_items where bill_no ='"+bill_no+"'";
              DefaultTableModel eve=dtablefill(qry);
              tot.setText(eve.getValueAt(0, 0).toString());
              dis.setText(eve.getValueAt(0, 1).toString());
              tax.setText(eve.getValueAt(0, 2).toString());
              double netvalue=(Double.valueOf(tot.getText())+Double.valueOf(tax.getText())-Double.valueOf(dis.getText()));
              net.setText(String.valueOf(netvalue));
              String qry1="insert into bill_info(customer_name,Address,mobile,amount,discount,GST,net_amt,bill_date) values('"+cname.getText()+"','"+jt1.getText()+"','"+jt2.getText()+"','"+tot.getText()+"','"+dis.getText()+"','"+tax.getText()+"','"+net.getText()+"','"+sm.format(date)+"')";
              int s=my_con.Update_qry(qry1);
              if(s==1)
              {
              note.setText("bill ready");
              total.setText("go to HOME");
               qnt.setText(null);
               cinfo.setText(null);
               cname.setText(null);
               jt1.setText(null);
               jt2.setText(null);
               ji1.setText(null);
               ji2.setText(null);
               ji3.setText(null);
              
              }
              }
              else if(total.getText()=="go to HOME")
              {
              new mdi_page();
              dispose();
              }
          }
      });
      total.setBounds(200,520,120,30);
      add(total);
      
     t1=new JLabel(" total prize");
      t1.setBounds(525,440,100,30);
      add(t1);
      tot=new JTextField();
      tot.setBounds(630,440,120,30);
      add(tot);
     
       t2=new JLabel("total discount");
      t2.setBounds(525,480,150,30);
      add(t2);
      dis=new JTextField();
      dis.setBounds(630,480,120,30);
      add(dis);
      
       t3=new JLabel("total tax");
      t3.setBounds(525,520,150,30);
      add(t3);
      tax=new JTextField();
      tax.setBounds(630,520,150,30);
      add(tax);
      
       t4=new JLabel("net amount");
      t4.setBounds(525,560,150,30);
      add(t4);
      net=new JTextField();
      net.setBounds(630,560,120,30);
      add(net);
     
      setBounds(10,10,800,700);
      setLayout(null);
      setVisible(true);
  
  }
}
