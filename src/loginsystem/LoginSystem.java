/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystemproject;


import java.util.*;
import java.io.*;
import java.security.*;

/**
 *
 * @author Billy Lu
 */
public class LoginSystem {
    private static final String fileName = "users.txt";
    /**
     * Save a user into a .txt file
     * @param user    user to be saved
     */
    public void saveUser(User user) {
        user.setPassword(encryption(user.getPassword()+user.getSalt()));
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            pw.println(user + ", ");
            pw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Encrypt a password 
     * @param password   password to be encrypted
     * @return
     */
    public String encryption(String password) {
        //java helper class to perform encryption
        String encryptedPassword = "";
        try {
            MessageDigest mesd = MessageDigest.getInstance("SHA-256");
            //give the helper function the password
            mesd.update(password.getBytes());
            //perform the encryption
            byte byteData[] = mesd.digest();
            //To express the byte data as a hexadecimal number (the normal way)
            for (int i = 0; i < byteData.length; ++i) {
                encryptedPassword += (Integer.toHexString((byteData[i] & 0xFF)
                        | 0x100).substring(1, 3));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return encryptedPassword;
    }

    /**
     *  Register a user
     * @param username   Username of the user
     * @param password   password of the user
     * @param email      email of the user
     * @param phoneNumber phone number of the user
     * @param address    address of the user
     * @return    -1 if username already exists. -2 if password is invalid, 1 if register is successful
     */
    public int register(String username, String password, String email, String phoneNumber, String address) {
        if (!isUniqueName(username)) {
            return (-1);
        }
        if (!isOkPassword(password)) {
            return (-2);
        }
        String salt = generateSalt();
        User user = new User(username, password, email, phoneNumber, address, salt);
        saveUser(user);
        return 1;
    }

    /**
     * Login a user
     * @param username   Username of the user
     * @param password   password of the user
     * @return    1 if success, -1 if password or username is incorrect
     */ 
    public int login(String username, String password) {
        ArrayList<User> users = loadAllUser();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if(user.getPassword().equals(encryption(password + user.getSalt())))
                    return 1;
            }
        }
        return -1;
    }

    /**
     *  load all users in to an arraylist
     * @return  every user in user.txt file
     */
    public ArrayList<User> loadAllUser() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(", ");
                User user = new User(data[0], data[1], data[2], data[3], data[4], data[5]);
                users.add(user);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return users;
    }

    /**
     * Check if user name is unique
     * @param username
     * @return
     */
    public boolean isUniqueName(String username) {
        ArrayList<User> users = loadAllUser();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * check if password is valid
     * @param password
     * @return true if valid, false otherwise
     */
    public boolean isOkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (password.matches(".*[0-9].*") == false) {
            return false;
        }
        return true;
    }

    /**
     *  Generate a random salt
     * @return   4 digit salt 
     */
    public String generateSalt(){
          String salt = "";
      for (int i = 0; i < 4; i++) {
            salt += (char)((Math.random() * 90)+33);
        }
      return salt;
  }
}
