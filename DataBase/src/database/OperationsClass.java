/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;

/**
 *
 * @author elkrnk 1
 */
public class OperationsClass implements Operations {
     public void selectStudent( int id,Connection con)
     {
     }
    
   public void selectStudent( String fname,String lname,Connection con)
   {
   }
    public void selectStudentGender( String gender,Connection con)
    {
    
    }
        public void selectStudentsGrade( String gender,Connection con)
        {
        }

    public void updateStudentGrade( int id,String grade)
    {
    }
    public void insertStudent( int id,String fname,String lname,String grade,String Bdate)
    {}
    public void deleteStudent( int id)
    {
    }
    
}
