/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.StationService;
import com.sarkar.kabir.railwayreservationssystem.model.Addstation;

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
public class StationServiceImpl implements StationService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertAddstation(Addstation cm) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateAddstation(Addstation cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public Integer deleteAddstation(int id) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Addstation cm = (Addstation) s.get(Addstation.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;   
    }

    @Override
    public String viewAddstation() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Addstation> categorieslist = s.createQuery("from Addstation").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson; 
    }

    @Override
    public Addstation viewoneAddstation(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Addstation cm = (Addstation) s.get(Addstation.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm; 
    }

   
     
}
