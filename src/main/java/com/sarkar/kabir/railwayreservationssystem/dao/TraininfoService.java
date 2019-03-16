/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Reservation;
import com.sarkar.kabir.railwayreservationssystem.model.Traininfo;

import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface TraininfoService {

     public String insertTraininfo(Traininfo ti);

        public String updateTraininfo(int train_id, Traininfo ti);

        public String deleteTraininfo(int train_id);

        public String viewTraininfo();
        public int getPassengerId(String email);

        public Traininfo viewoneTraininfo(int train_id);
         
        public String searchtrain(Traininfo ti);
       
        public Traininfo strain(Traininfo ti);
        
         public Traininfo buyticket(int tid);
        
       
//         public  String insertreserveSeat(Reservation resid);
         public String insertReservation(Reservation resid);
         
         
         
         //for payment
         
          
         
        
        
     
        
       

   

}
