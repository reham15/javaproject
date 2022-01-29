/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
/**
 *
 * @author elkrnk 1
 */
public class myApp {
   static  Connection con;
    public static void main(String[] args) {
        MyOperations operation=new MyOperations();
       Connectionmydata c=new Connectionmydata();
         con= c.startConnection("root", "Ror#1515");
         
        operation.selectStudent( 3, con);
         
        

        // TODO code application logic here
    }
    
    
    
}
