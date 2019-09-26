/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Ridmi Shalika
 */
public class Config {
    
    public static String SMS_Genaral_attendance =  "Nikasha+SMS+Alert-NLC-Dear+Parent,-NLC-Your+<TITLE>+<NAME>+safly+entered+nikasha+premises+at+<TIME>.";
    public static String SMS_course_attendance =  "Nikasha+SMS+Alert-NLC-Name+:+<NAME>-NLC-Course+:+<COURSE>-NLC-Status+:+Attend-NLC-In+Time+:+<IN_TIME>-NLC-Out+Time+:+<OUT_TIME>.";
    public static String SMS_Genaral_not_attendance = "Nikasha+SMS+Alert-NLC-Name+:+<NAME>-NLC-Course+:+<COURSE>-NLC-Status+:+NOT+Attend."; 
    
    
    public static final int cardnoLength = 10;
    public static final int studentIdLength = 5;
}
