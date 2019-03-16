/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Passengerinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface PassengerinfoService {

    public String insertPassengerinfo(Passengerinfo cm);

    public String updatePassengerinfo(Passengerinfo cm);

    public Integer deletePassengerinfo(int id);

    public String viewPassengerinfo();

    public Passengerinfo viewonePassengerinfo(int id);
    public Passengerinfo viewonePassengerbyEmail(String email);
}
