/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author dhaka
 */
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int resid;
    @Column
    private int passid;
    @Column
    @Temporal(TemporalType.DATE)
    private Date resdate =new Date();
    @Column
    private int ptn;
     @Column
    private String resstatus="ordered";
    @Column
    private int trainid;
    //@Transient
    @Column
    private String comname;
    @Column
    private String comsubname;
    
    
   
    @Column
    private int adult;
    @Column
    private int child;
    @Column
    private String emailid;
    
   // private int trainid;
   @Transient
   private String trainnumber;
    @Transient
    private String trainname;
    //@Transient
    private String fromstationid;
    //@Transient
    private String tostationid;
   //@Transient
    private String depaturetime;
    //@Transient
    private String arivaltime;
   @Transient
    private String dayoff;       
    //@Transient
   private Date d;
    

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
    }

    public Date getResdate() {
        return resdate;
    }

    public void setResdate(Date resdate) {
        this.resdate = resdate;
    }

    public int getPtn() {
        return ptn;
    }

    public void setPtn(int ptn) {
        this.ptn = ptn;
    }

   
    

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
    }

    public String getResstatus() {
        return resstatus;
    }

    public void setResstatus(String resstatus) {
        this.resstatus = resstatus;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getTrainnumber() {
        return trainnumber;
    }

    public void setTrainnumber(String trainnumber) {
        this.trainnumber = trainnumber;
    }

    public String getTrainname() {
        return trainname;
    }

    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }

    public String getFromstationid() {
        return fromstationid;
    }

    public void setFromstationid(String fromstationid) {
        this.fromstationid = fromstationid;
    }

    public String getTostationid() {
        return tostationid;
    }

    public void setTostationid(String tostationid) {
        this.tostationid = tostationid;
    }

    public String getDepaturetime() {
        return depaturetime;
    }

    public void setDepaturetime(String depaturetime) {
        this.depaturetime = depaturetime;
    }

    public String getArivaltime() {
        return arivaltime;
    }

    public void setArivaltime(String arivaltime) {
        this.arivaltime = arivaltime;
    }

    public String getDayoff() {
        return dayoff;
    }

    public void setDayoff(String dayoff) {
        this.dayoff = dayoff;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComsubname() {
        return comsubname;
    }

    public void setComsubname(String comsubname) {
        this.comsubname = comsubname;
    }

  
    

   

    
   

}
