/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/*import java.sql.* ;
import org.json.simple.JSONObject;    

public class DataBase
{
Connection con;
String[]p=new String [10];
public DataBase()
{

try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
 con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/lab","root","Ror#1515");  

}catch(Exception e){ System.out.println(e);} 




}



 
 



public String[] selectusers( ) throws SQLException
{
try{  
 
PreparedStatement pst= con.prepareStatement("select username,status from users ");

ResultSet rs=pst.executeQuery();  
int i=0;
while(rs.next())
{p[i]=(rs.getString(1)+" "+rs.getString(2));
 i++;
 
}
}
catch(Exception e){ System.out.println(e);}  
  
return p;
}
}
*/
import java.sql.* ;
import java.io.*;
import java.util.Map ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
//import org.json.simple.JSONString;
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



 
 

//public ObservableList<User>

ObservableList<User> selectusers( ) throws SQLException
{
try{ 
   // ObjectMapper mapper=new ObjectMapper();
 //mapper.enable(SerializationFeature.INDENT_OUTPUT);
PreparedStatement pst= con.prepareStatement("select username,status from users ");

ResultSet rs=pst.executeQuery();  

while(rs.next())
{User u=new User();
 u.setUserName(rs.getString(1));
u.setStatus(rs.getString(2));

userList.add(u) ;

}
String l;
   // l = mapper.writeValueAsString(userList);

//for(int i=0;i<5;i++)
            //System.out.println(userList);
}

catch(Exception e){ System.out.println(e);}  
   
  
return userList ;
}
}