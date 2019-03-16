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

/**
 *
 * @author dhaka
 */
@Entity
public class ReservationDetails implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resdetid;
    @Column
    private int resid;
    @Column
    private int comsubid;
    @Column
    private int fareid;
    @Column
    private int seatno;
    

    public int getResdetid() {
        return resdetid;
    }

    public void setResdetid(int resdetid) {
        this.resdetid = resdetid;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public int getComsubid() {
        return comsubid;
    }

    public void setComsubid(int comsubid) {
        this.comsubid = comsubid;
    }

    public int getFareid() {
        return fareid;
    }

    public void setFareid(int fareid) {
        this.fareid = fareid;
    }

    public int getSeatno() {
        return seatno;
    }

    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }

   
    
    
    
    
}
