
package myproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;

public class bill_info extends JFrame
{
    my_sql_connection my_con=new my_sql_connection();
    JTextField jt;
    private JButton home;
    JTable jtab;
  
    DefaultTableModel dft;
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
   
  
    public bill_info()
    {
        setTitle("bill information");
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
        jt=new JTextField();
        jt.setBackground(Color.blue);
        jt.setForeground(Color.white);
       
        jt.addKeyListener(new KeyAdapter() 
        {
            public void keyReleased(KeyEvent e)
            {
            String qry="select * from bill_info where customer_name like '"+jt.getText()+"%' or bill_date like '"+jt.getText()+"%' or Address like '"+jt.getText()+"%' or mobile like '"+jt.getText()+"%'";
            DefaultTableModel dtm=dtablefill(qry);
            jtab.setModel(dtm);
            }
                    });
        jt.setBounds(100,50,200,30);
        add(jt);
        jtab=new JTable();
        jtab.setShowVerticalLines(true);
        jtab.setShowHorizontalLines(true);
        jtab.setBackground(Color.blue);
        jtab.setForeground(Color.white);
       // jtab.setBounds(50,100,700,400);
        JScrollPane jp=new JScrollPane(jtab);
        jp.setBackground(Color.red);
        jp.setBounds(10,100,750,400);
        add(jp);
         
         ListSelectionModel list=jtab.getSelectionModel();
         //list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
         list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
            int index=jtab.getSelectedRow();
           String bill_id=jtab.getValueAt(index, 0).toString();
           String qry1="select * from buy_items where bill_no='"+bill_id+"'";
           dft=dtablefill(qry1);
           new  buyed_Item_information_table(dft,jtab.getValueAt(index,1).toString(),jtab.getValueAt(index, 8).toString());
            }
        });
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setBounds(0,0,800,700);
        setLayout(null);
        setVisible(true);
    }
}
