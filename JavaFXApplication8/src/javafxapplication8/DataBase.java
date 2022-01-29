/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.sql.* ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DataBase
{
Connection con;
//String[]p=new String [10];
User u=new User();
ObservableList<User> userList=FXCollections.observableArrayList();
public DataBase()
{

try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
 con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/lab","root","Ror#1515");  

}catch(Exception e){ System.out.println(e);} 




}



 
 



public ObservableList<User> selectusers( ) throws SQLException
{
try{  
 
PreparedStatement pst= con.prepareStatement("select username,status from users ");

ResultSet rs=pst.executeQuery();  
//int i=0;
while(rs.next())
{User u=new User();
 u.setUserName(rs.getString(1));
u.setStatus(rs.getString(2));
 //i++;
userList.add(u) ;

}
//for(int i=0;i<5;i++)
           // System.out.println(userList.get(i).getUserName());
}
catch(Exception e){ System.out.println(e);}  
  
return userList;
}
}