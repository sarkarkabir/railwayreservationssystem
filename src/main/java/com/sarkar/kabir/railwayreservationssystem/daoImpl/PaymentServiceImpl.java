/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.PaymentService;
import com.sarkar.kabir.railwayreservationssystem.model.Payment;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author C5
 */
@Repository
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPayment(Payment pi) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pi);
        t.commit();
        s.close();
        return null;
    }
     @Override
    public String viewPayment() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment>  paymentist = s.createQuery("from Payment").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(paymentist);
        t.commit();
        s.close();
        return productslistgson;
    }

    

    @Override
    public String updatePayment(Payment pid) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment oneproductobject = (Payment) s.get(Payment.class, pid);
        oneproductobject.setPaymentid(pid.getPaymentid());
        oneproductobject.setResid(pid.getResid());
        oneproductobject.setFareid(pid.getFareid());
        oneproductobject.setQty(pid.getQty());
        oneproductobject.setFareamt(pid.getFareamt());
        oneproductobject.setTotal(pid.getTotal());
        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;   
    }

    @Override
    public Integer deletePayment(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment pm = (Payment) s.get(Payment.class, id);
        s.delete(pm);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public Payment viewonePayment(int id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment pm = (Payment) s.get(Payment.class, id);
        t.commit();
        s.close();
        return pm;
    }

}
