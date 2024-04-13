/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystemproject;

/**
 * 
 * @author Billy Lu
 */
public class User{
  private String username;
  private String password;
  private String email;
  private String phoneNumber;
  private String address;
  private String salt;
  private static final String DELIMITER = ", ";
  
    /**
     * Constructor for User
     * 
     * @param username
     * @param password
     * @param email
     * @param phoneNumber
     * @param address
     * @param salt
     */
    public User(String username, String password, String email, String phoneNumber, String address, String salt) {
    this.username = username;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.password = password;
    this.salt = salt;
  }

    /**
     * Constructor for User
     * @param username
     * @param password
     * @param email
     */
    public User(String username, String password, String email) {
    this.username = username;
    this.email = email;
    this.phoneNumber = "";
    this.address = "";
    this.password = password;}
  
    /**
     * Constructor for User
     * @param info   Take in a array of strings containing the info needed for a user 
     */
    public User(String[] info){
    this.username = info[0];
    this.email = info[2];
    this.phoneNumber = info[3];
    this.address = info[4];
    this.password = info[1];
  }
  
    /**
     * Overide tostring method for user, printing all information seperated by delimeter.
     * @return
     */
 
    public String toString(){
    return username + DELIMITER + password  + DELIMITER + email + DELIMITER + phoneNumber + DELIMITER + address+ DELIMITER + salt;
  }

    /**
     * Return user's username
     * @return
     */
    public String getUsername(){
      return username;
    }

    /**
     * set user's password
     * @param password
     */
    public void setPassword(String password){
      this.password = password;
    }

    /**
     * Return user's password
     * @return
     */
    public String getPassword(){
      return password;
    }

    /**
     * Return user's salt
     * @return
     */
    public String getSalt(){
      return salt;
    }

}