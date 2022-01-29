/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

/**
 *
 * @author elkrnk 1
 */
public class mydate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Date date = new Date(12, 12, 12);
             System.out.println(date);
             LocalDate ld = LocalDate.of(1931, Month.OCTOBER, 15);
              System.out.println(ld);
              LocalDate ld1 = LocalDate.ofYearDay(2017, 21);
                System.out.println(ld1); 
                LocalDate ld2 = LocalDate.ofYearDay(2017, 90);
                System.out.println(ld2); 
                LocalDate ld3 = LocalDate.ofEpochDay(1); 
                System.out.println(ld3); 
                LocalDate ld4 = LocalDate.ofEpochDay(90);
                System.out.println(ld4);


        // TODO code application logic here
    }
    
}
