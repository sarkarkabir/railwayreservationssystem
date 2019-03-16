/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Payment;
import org.springframework.stereotype.Service;

/**
 *
 * @author C5
 */
@Service
public interface PaymentService {

   

   
    public String insertPayment(Payment pi);

    public String updatePayment(Payment pi);

    public Integer deletePayment(int id);

     public String viewPayment();

    public Payment viewonePayment(int id);
}
