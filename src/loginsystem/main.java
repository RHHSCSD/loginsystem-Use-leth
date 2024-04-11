/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystemproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chixi
 */
public class main {

    public static void main(String[] args) {
//        String salt = "";
//        for (int i = 0; i < 4; i++) {
//            salt += (char)((Math.random() * 90)+33);
//        }
//        System.out.println(salt);
//        ArrayList<User> users = new ArrayList<User>();
//        try {
//            File file = new File("users.txt");
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                String[] data = line.split(", ");
//                User user = new User(data[0], data[1], data[2], data[3], data[4]);
//                users.add(user);
//                System.out.println(user);
//            }
//            sc.close();
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
       
        
        
        LoginSystem system = new LoginSystem();
        system.register("Billy","12345678!","lopopo","6476075999","Stanroft 41");
        System.out.println(system.login("Billy","12345678!"));
    }
}
