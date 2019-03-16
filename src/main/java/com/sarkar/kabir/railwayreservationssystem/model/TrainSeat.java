/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dhaka
 */
@Entity
public class TrainSeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seatid;
    @Column
    private int trainid;
    @Column
    private int comtypeid;
    @Column
    private String noofcompartment;

    public int getSeatid() {
        return seatid;
    }

    public void setSeatid(int searid) {
        this.seatid = searid;
    }

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
    }

    public int getComtypeid() {
        return comtypeid;
    }

    public void setComtypeid(int comtypeid) {
        this.comtypeid = comtypeid;
    }

    public String getNoofcompartment() {
        return noofcompartment;
    }

    public void setNoofcompartment(String noofcompartment) {
        this.noofcompartment = noofcompartment;
    }

    
    
}
