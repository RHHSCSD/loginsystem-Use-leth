/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystemproject;

/**
 *
 * @author chixi
 */
public class User{
  private String username;
  private String password;
  private String email;
  private String phoneNumber;
  private String address;
  private String salt;
  
  
  public User(String username, String password, String email, String phoneNumber, String address, String salt) {
    this.username = username;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.password = password;
    this.salt = salt;
  }
  public User(String username, String password, String email) {
    this.username = username;
    this.email = email;
    this.phoneNumber = "";
    this.address = "";
    this.password = password;}
  
  public User(String[] info){
    this.username = info[0];
    this.email = info[2];
    this.phoneNumber = info[3];
    this.address = info[4];
    this.password = info[1];
  }
  
  public String toString(){
    return username + ", " + password  + ", "+ email + ", " + phoneNumber + ", " + address+ ", " + salt;
  }
  public String getUsername(){
      return username;
    }
  public void setPassword(String password){
      this.password = password;
    }
  public String getPassword(){
      return password;
    }
  public String getSalt(){
      return salt;
    }

}