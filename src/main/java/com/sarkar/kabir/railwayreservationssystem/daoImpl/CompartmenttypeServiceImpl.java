/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.CompartmenttypeService;
import com.sarkar.kabir.railwayreservationssystem.model.Compartmenttype;
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
public class CompartmenttypeServiceImpl implements CompartmenttypeService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertCompartmenttype(Compartmenttype cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateCompartmenttype(Compartmenttype cm) {
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
    public Integer deleteCompartmenttype(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Compartmenttype cm = (Compartmenttype) s.get(Compartmenttype.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewCompartmenttype() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Compartmenttype> categorieslist = s.createQuery("from Compartmenttype").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson; 
    }

    @Override
    public Compartmenttype viewoneCompartmenttype(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Compartmenttype cm = (Compartmenttype) s.get(Compartmenttype.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    @Override
    public Compartmenttype viewoneCompartmenttypeComname(String comn) {
        Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
        Query q = s.createQuery("from Compartmenttype where comtypeid=?");
       
        q.setString(0, comn);
        List<Compartmenttype> ri=q.list();
        t.commit();
        s.close();
       return ri.get(0);
    }
    
}
