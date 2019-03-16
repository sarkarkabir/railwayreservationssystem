/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Reservation;
import org.springframework.stereotype.Service;

/**
 *
 * @author C5
 */
@Service
public interface ReservationService {
    public String insertReservation( Reservation rv);

    public String updateReservation(int res_id, Reservation rv);

    public String deleteReservation(int res_id);

    public String viewReservation();

    public Reservation viewOneReservation(int res_id);
    
}
