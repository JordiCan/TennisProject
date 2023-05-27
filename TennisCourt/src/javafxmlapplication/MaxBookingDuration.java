/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxmlapplication;

import java.time.LocalDate;
import java.time.LocalTime;
import model.Court;



/**
 *
 * @author Alma
 */
public class MaxBookingDuration {
   private   LocalDate  day;
   private  LocalTime h ;
   private Court c;
    
   
   public MaxBookingDuration(LocalDate day, Court c, LocalTime h){
    this.day = day;
    this.c = c;
    this.h = h;
}

public LocalTime  getHoursBooked(){
    return h;
}


public LocalDate getDay(){
    return day;

}

public Court getCourt(){
    return c;
}









}
