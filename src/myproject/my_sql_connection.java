
package myproject;

import java.sql.*;

public class my_sql_connection
{
    
    
    ResultSet rs;
    
    public int Update_qry(String qry)
    {
        int status=0;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/myproject","root","12345");
        Statement st1=con.createStatement();
        if(st1.executeUpdate(qry)==1)
        {
        status=1;
        }
        }
        catch(Exception rr)
        {
        System.out.println("error is"+rr.getMessage());
        }
        return status;
    }
    
    public ResultSet fetch_qry(String qry)
    {
 
        try
        {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost/myproject","root","12345");
      Statement st2=con.createStatement();
      rs=st2.executeQuery(qry);
        }
        catch(Exception rr)
        {
        
        }
         return rs;
    }
    

}
