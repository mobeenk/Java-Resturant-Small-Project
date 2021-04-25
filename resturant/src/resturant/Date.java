/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant;

import java.util.Random;

/**
 *
 * @author kayali
 */
public class Date {
    private int day;
      private int month;
     private int year;
  
    

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
 
 

 
    
}
