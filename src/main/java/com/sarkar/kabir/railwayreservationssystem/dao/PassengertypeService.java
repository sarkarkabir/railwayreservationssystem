/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Passengertype;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface PassengertypeService {
   public String insertPassengertype(Passengertype cm);

    public String updatePassengertype(Passengertype cm);

    public Integer deletePassengertype(int id);

    public String viewPassengertype();

    public Passengertype viewonePassengertype(int id);
}
