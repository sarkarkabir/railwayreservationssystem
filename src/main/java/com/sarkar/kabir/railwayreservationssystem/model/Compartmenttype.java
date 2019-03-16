
package com.sarkar.kabir.railwayreservationssystem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Compartmenttype implements Serializable{
   @Id
   private int comtypeid;
   @Column
   private String comname;
   @Column
   private double totalseat;

    public int getComtypeid() {
        return comtypeid;
    }

    public void setComtypeid(int comtypeid) {
        this.comtypeid = comtypeid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public double getTotalseat() {
        return totalseat;
    }

    public void setTotalseat(double totalseat) {
        this.totalseat = totalseat;
    }
 
    
   
   
   
}
