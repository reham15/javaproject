/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author elkrnk 1
 */
public class MyOperations extends OperationsClass {
    
    
  public void selectStudent( int id,Connection con)
     {
     try{  
 
PreparedStatement pst= con.prepareStatement("select * from students where student_id= ?");
pst.setInt(1,id);
ResultSet rs=pst.executeQuery();  
System.out.println(1);
while(rs.next()) { 
    System.out.println(2);
System.out.println( "id:"+rs.getInt(1)+" first_name: "+rs.getString(2)+"last_name  "+rs.getString(3) +"gender:"+rs.getString(5));  
}
}
catch(Exception e){ System.out.println(e);}  
}  

     
     
  
  
    public void deleteStudent( int id)
    {
    }
    
}
