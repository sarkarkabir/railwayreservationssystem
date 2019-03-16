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
public class Traininfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trainid;
    @Column
    private String trainnumber;
    @Column
    private String trainname;
    @Column
    private String fromstationid;
    @Column
    private String tostationid;
    @Column
    private String depaturetime;
    @Column
    private String arivaltime;
   @Column
    private String dayoff;
   @Transient
   private int stationid;
   @Transient
   private Date d;

    public int getStationid() {
        return stationid;
    }

    public void setStationid(int stationid) {
        this.stationid = stationid;
    }

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
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

   

}
