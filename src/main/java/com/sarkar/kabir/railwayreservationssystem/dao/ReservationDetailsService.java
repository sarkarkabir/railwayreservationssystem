/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.ReservationDetails;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface ReservationDetailsService {
   //public String insertReservationDetails(  ReservationDetails rvd);
   public String insertReservationDetails(ArrayList<ReservationDetails> reservationdetails);

    public String updateReservationDetails(int resdet_id,  ReservationDetails rvd);

    public String deleteReservationDetails(int resdet_id);

    public String viewReservationDetails();

    public ReservationDetails viewOneReservationDetails(int resdet_id);
    public ReservationDetails viewOneReservatiodSeatno(int resdtid,String seatno,int train ,Date tt,int comsub);
    
}
