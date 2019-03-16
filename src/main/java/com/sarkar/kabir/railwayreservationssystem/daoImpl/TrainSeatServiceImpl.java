/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.TrainSeatService;
import com.sarkar.kabir.railwayreservationssystem.model.TrainSeat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dhaka
 */
@Repository
public class TrainSeatServiceImpl implements TrainSeatService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertTrainSeat(TrainSeat ts) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(ts);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateTrainSeat(int seat_id, TrainSeat ts) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        TrainSeat oneproductobject = (TrainSeat) s.get(TrainSeat.class, seat_id);
        oneproductobject.setTrainid(ts.getTrainid());
        oneproductobject.setComtypeid(ts.getComtypeid());
        oneproductobject.setNoofcompartment(ts.getNoofcompartment());

        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteTrainSeat(int seat_id) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        TrainSeat pm = (TrainSeat) s.get(TrainSeat.class, seat_id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewTrainSeat() {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<TrainSeat> productslist = s.createQuery("from TrainSeat").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public TrainSeat viewOneTrainSeat(int seat_id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        TrainSeat pm = (TrainSeat) s.get(TrainSeat.class, seat_id);
        t.commit();
        s.close();
        return pm;
    }

}
