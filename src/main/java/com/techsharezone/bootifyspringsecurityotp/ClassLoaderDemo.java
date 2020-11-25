package com.techsharezone.bootifyspringsecurityotp;/*
 * @created 25/11/2020 -03:03
 * @project bootify-spring-security-otp
 * @author  saurabhshcs
 */

import java.net.URL;

public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        // returns the ClassLoader object associated with this Class
        ClassLoader cLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println("\n\n\n\t\t\t______________cls - " +cLoader.getClass());

        // finds resource with the given name
        System.out.println("***Value = " + cLoader.getResource("templates/sendOtp.html"));

//        // finds resource with the given name
//        url = cLoader.getResource("resources/templates/sendOtp.html");
//        System.out.println("Value = " + url);
    }
}
