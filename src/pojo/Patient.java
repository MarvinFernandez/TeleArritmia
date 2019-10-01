/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author danielmarchan
 */
public class Patient {
    
    public enum gender{male,female};
    
    private String name;
    private String surname;
    private Integer id;
    private String email;
    private Date dob;
    private gender sex; 
    private int ECG[][]; 
    private int EDA[][];

    public Patient(String name, String surname, Integer id, String email, Date dob, gender sex, int[][] ECG, int[][] EDA) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
        this.ECG = ECG;
        this.EDA = EDA;
    }

    public Patient() {
        this.name = null;
        this.surname = null;
        this.id = 0;
        this.email = null;
        this.dob = null;
        this.sex = null;
        this.ECG = null;
        this.EDA = null;
    }
    
    
 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public gender getSex() {
        return sex;
    }

    public void setSex(gender sex) {
        this.sex = sex;
    }

    public int[][] getECG() {
        return ECG;
    }

    public void setECG(int[][] ECG) {
        this.ECG = ECG;
    }

    public int[][] getEDA() {
        return EDA;
    }

    public void setEDA(int[][] EDA) {
        this.EDA = EDA;
    }

    @Override
    public String toString() {
        return "Patient{\n" + "name=" + name + "\n surname=" + surname + "\n id=" + id + "\n email=" + email + "\n dob=" + dob + "\n sex=" + sex + "\n}";
    }
    
    
    
}
