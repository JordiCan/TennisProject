/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxmlapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jordi
 */
public class Utils {
    public static  Boolean checkUser (String input)
    {   if(input.equals("")){
          return false; 
        }
        return true;
    }
    
     
    public static  Boolean checkSurname (String input)
    {   if(input.equals("")){
          return false; 
        }
        return true;
    }
    
    public static  Boolean checkTelephone (String input)
    {   if(input.equals("")){
          return false; 
        }
        //Check length of the phone number
        if((input.length())<8){return false;}
    
       // Invalid characters
        String regex = "^[0-9]{6,9}$";
        Pattern pattern = Pattern.compile(regex);
        // Match ReGex with value to check
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    
    public static Boolean checkNickname(String input){
        if(input.equals("")){
            return false;
        }
        return true;
    }
    
    public static  Boolean checkPassword (String input)
    {   if(input.equals("")){
          return false; 
        }
       // Required characters
        String regex = "^[A-Za-z0-9]{8,15}";
        Pattern pattern = Pattern.compile(regex);
        // Match ReGex with value to check
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    
    public static  Boolean checkCard (String input)
    {   if(!input.equals("")){
            if(input.length()!=16){return false;}
            }
        return true;
    }
     
    public static Boolean checkSVC(String input){
        if(!input.equals("")){
            if(input.length()!=3){return false;}
        }
        return true;
    } 
   
    public static Boolean checkCSC(String input){
        if (input.length() != 3 ){
            return false;
        } 
        if(input.equals("")){
          return true; 
        }
        // Invalid characters
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$abcdefghijklmnopqrstuvwxzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Pattern pattern = Pattern.compile(regex);
        // Match ReGex with value to check
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
        
     
    }
   
    
}
