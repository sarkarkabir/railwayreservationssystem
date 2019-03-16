/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationService;
import com.sarkar.kabir.railwayreservationssystem.model.Reservation;
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
public class ReservationServiceImpl implements  ReservationService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertReservation(Reservation rv) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(rv);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateReservation(int res_id, Reservation rv) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Reservation oneproductobject = (Reservation) s.get(Reservation.class, res_id);
        oneproductobject.setPassid(rv.getPassid());
        oneproductobject.setResdate(rv.getResdate());
        oneproductobject.setPtn(rv.getPtn());
        oneproductobject.setTrainid(rv.getTrainid());
        oneproductobject.setResstatus(rv.getResstatus());
        oneproductobject.setAdult(rv.getAdult());
        oneproductobject.setChild(rv.getChild());
        oneproductobject.setEmailid(rv.getEmailid());

        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteReservation(int res_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Reservation pm = (Reservation) s.get(Reservation.class, res_id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewReservation() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Reservation> productslist = s.createQuery("from Reservation").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Reservation viewOneReservation(int res_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Reservation pm = (Reservation) s.get(Reservation.class, res_id);
        t.commit();
        s.close();
        return pm;
    }
    
    
}
