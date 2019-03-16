/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.CompartmentSubTypeService;
import com.sarkar.kabir.railwayreservationssystem.model.CompartmentSubType;
import java.util.List;
import org.hibernate.Query;
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
public class CompartmentSubTypeServiceImpl implements CompartmentSubTypeService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertCompartmentSubType(CompartmentSubType cst) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cst);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateCompartmentSubType(int comsub_id, CompartmentSubType cst) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        CompartmentSubType oneproductobject = (CompartmentSubType) s.get(CompartmentSubType.class, comsub_id);
        oneproductobject.setComtypeid(cst.getComtypeid());
        oneproductobject.setComsubname(cst.getComsubname());
         s.update(oneproductobject);
        t.commit();
        s.close();
        return null;

       
    }

    @Override
    public String deleteCompartmentSubType(int comsub_id) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        CompartmentSubType pm = (CompartmentSubType) s.get(CompartmentSubType.class, comsub_id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewCompartmentSubType() {
    Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<CompartmentSubType> productslist = s.createQuery("from CompartmentSubType").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public CompartmentSubType viewOneCompartmentSubType(int comsub_id) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        CompartmentSubType pm = (CompartmentSubType) s.get(CompartmentSubType.class, comsub_id);
        t.commit();
        s.close();
        return pm;
    }
@Override
    public CompartmentSubType viewOneCompartmentSubName(String  comsu) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //Query q=s.createQuery("select u from CompartmentSubType u where comsubid=?");
       // List<CompartmentSubType> up=q.setParameter(0,csbid).list();
        List<CompartmentSubType> productslist = s.createQuery("from CompartmentSubType where comsubname=?").setParameter(0,comsu ).list();
        t.commit();
        s.close();
        return productslist.get(0);
    }

}
