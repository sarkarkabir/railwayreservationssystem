/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author dhaka
 */
@Entity
public class Passengertype implements Serializable{
  
    @Id
    private int passtypeid;
    @Column
    private String passtype;

    public int getPasstypeid() {
        return passtypeid;
    }

    public void setPasstypeid(int passtypeid) {
        this.passtypeid = passtypeid;
    }

    public String getPasstype() {
        return passtype;
    }

    public void setPasstype(String passtype) {
        this.passtype = passtype;
    }

    
    
}
