package com.sarkar.kabir.railwayreservationssystem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FareChart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fareid;
    @Column
    private String fromstationid;
    @Column
    private String tostationid;
    @Column
    private String comname;
    @Column
    private double fareamt;
    @Column
    private String passtypeid;

    public int getFareid() {
        return fareid;
    }

    public void setFareid(int fareid) {
        this.fareid = fareid;
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

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    

    


    public double getFareamt() {
        return fareamt;
    }

    public void setFareamt(double fareamt) {
        this.fareamt = fareamt;
    }

    public String getPasstypeid() {
        return passtypeid;
    }

    public void setPasstypeid(String passtypeid) {
        this.passtypeid = passtypeid;
    }

    
}
