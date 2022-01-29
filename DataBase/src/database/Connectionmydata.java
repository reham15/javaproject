/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author elkrnk 1
 */
public class Connectionmydata {
  Connection con;
    Connection startConnection(String user, String pass) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/lab", user, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
