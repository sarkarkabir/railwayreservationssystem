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
public class CompartmentSubType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comsubid;
    @Column
    private int comtypeid;
    @Column
    private String comsubname;

    public int getComsubid() {
        return comsubid;
    }

    public void setComsubid(int comsubid) {
        this.comsubid = comsubid;
    }

    public int getComtypeid() {
        return comtypeid;
    }

    public void setComtypeid(int comtypeid) {
        this.comtypeid = comtypeid;
    }

    public String getComsubname() {
        return comsubname;
    }

    public void setComsubname(String comsubname) {
        this.comsubname = comsubname;
    }

   

}
