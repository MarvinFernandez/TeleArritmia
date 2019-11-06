/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danielmarchan
 */
public class Patient implements Serializable {
    
    public enum GENDER{male,female};
    
    private String name;
    private String surname;
    private String id;
    private String email;
    private Date dob;
    private GENDER sex; 
    private ArrayList<Integer> ECG = new ArrayList();
    private ArrayList<Integer> time = new ArrayList();
    private ArrayList<Integer> EDA = new ArrayList();
    

    public Patient(String name, String surname, String id, String email, Date dob, GENDER sex, ArrayList<Integer> ECG,ArrayList<Integer> EDA) {
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
        this.id = null;
        this.email = null;
        this.dob = null;
        this.sex = null;
        this.ECG = null;
        this.EDA = null;
        this.time = null;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public GENDER getSex() {
        return sex;
    }

    public void setSex(GENDER sex) {
        this.sex = sex;
    }

    public ArrayList<Integer> getECG(){
        return this.ECG;
    }
    
    public void setECG(ArrayList<Integer> ecg){
        this.ECG = ecg;
    }
    
    public void addECG(int i){
        this.ECG.add(i);
    }
    
    public ArrayList<Integer> getEDA(){
        return this.EDA;
    }
    
    public void setEDA(ArrayList<Integer> eda){
        this.EDA = eda;
    }
    
    public void addEDA(int i){
        this.EDA.add(i);
    }
    
    public ArrayList<Integer> getTime(){
        return this.time;
    }
    
    public void setTime(ArrayList<Integer> time){
        this.time = time;
    }
    
    public void addTime(int i){
        this.time.add(i);
    }
    

    @Override
    public String toString() {
        return "Patient{\n" + " name=" + name + "\n surname=" + surname + 
                "\n id=" + id + "\n email=" + email + "\n dob=" + dob.getDay()+
                "/"+dob.getMonth()+"/"+dob.getYear() + "\n sex=" + sex + "\n}";
    }
    
    
    
}
