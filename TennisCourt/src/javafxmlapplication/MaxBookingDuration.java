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
   private   int day;
   private  int h = 0;
   private Court c;
    
   
   public MaxBookingDuration(int day, Court c, int h){
    this.day = day;
    this.c = c;
    this.h = h;
}

public int getHoursBooked(){
    return h;
}

public void increaseHoursBooked(){
    h++;
}

public int getDay(){
    return day;

}

public Court getCourt(){
    return c;
}









}
