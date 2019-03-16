/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dhaka
 */
@Entity
public class Passengerinfo {

    @Id
    private int passid;
    @Column
    private String passname;
    @Column
    private String passadd;
    @Column
    @Temporal(TemporalType.DATE)
    private Date passdob;
    @Column
    private String passgender;
    @Column
    @Temporal(TemporalType.DATE)
    private Date regdate;
    @Column
    private String passstatus;
    @Column
    private String passemail;

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
    }

    public String getPassname() {
        return passname;
    }

    public void setPassname(String passname) {
        this.passname = passname;
    }

    public String getPassadd() {
        return passadd;
    }

    public void setPassadd(String passadd) {
        this.passadd = passadd;
    }

    public Date getPassdob() {
        return passdob;
    }

    public void setPassdob(Date passdob) {
        this.passdob = passdob;
    }

   
    public String getPassgender() {
        return passgender;
    }

    public void setPassgender(String passgender) {
        this.passgender = passgender;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getPassstatus() {
        return passstatus;
    }

    public void setPassstatus(String passstatus) {
        this.passstatus = passstatus;
    }

    public String getPassemail() {
        return passemail;
    }

    public void setPassemail(String passemail) {
        this.passemail = passemail;
    }
    
    
}
