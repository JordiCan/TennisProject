/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxmlapplication;

import java.time.LocalDate;
import model.Court;



/**
 *
 * @author Alma
 */
public class MaxBookingDuration {
   private   LocalDate day;
   private  int h = 0;
   private Court c;
    
   
   public MaxBookingDuration(LocalDate d, Court c){
    day = d;
    this.c = c;
}

public int getHoursBooked(){
    return h;
}

public void increaseHoursBooked(){
    h++;
}

public LocalDate getDay(){
    return day;

}

public Court getCourt(){
    return c;
}

public boolean equalsM(MaxBookingDuration b){
    return b.getDay() == this.getDay() && b.getCourt() == this.getCourt() ;

}







}
