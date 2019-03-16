/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.PassengerinfoService;
import com.sarkar.kabir.railwayreservationssystem.model.Passengerinfo;
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
public class PassengerinfoServiceImpl  implements PassengerinfoService{
   @Autowired
   SessionFactory sessionFactory;
    @Override
    public String insertPassengerinfo(Passengerinfo cm) {
       Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
     return null; 
    }

    @Override
    public String updatePassengerinfo(Passengerinfo cm) {
        Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
      return null; 
    }

    @Override
    public Integer deletePassengerinfo(int id) {
         Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
        Passengerinfo cid=(Passengerinfo)s.get(Passengerinfo.class, id);
        s.delete(cid);
        t.commit();
        s.close();
     return null;
    }

    @Override
    public String viewPassengerinfo() {
       Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
      List<Passengerinfo>categorieslist=s.createQuery("from Passengerinfo").list();
      Gson g=new Gson();
      String addstationlistgson=g.toJson(categorieslist);
        t.commit();
        s.close();
     return addstationlistgson; 
    }

    @Override
    public Passengerinfo viewonePassengerinfo(int id) {
        Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
        Passengerinfo pi=(Passengerinfo)s.get(Passengerinfo.class, id);
        t.commit();
        s.close();
        Gson g=new Gson();
        String addstationgson=g.toJson(pi);
       return pi;
    }

    @Override
    public Passengerinfo viewonePassengerbyEmail(String email) {
        Session s=sessionFactory.openSession();
        Transaction t=s.getTransaction();
        t.begin();
        Query q = s.createQuery("from Passengerinfo where passemail=?");
        q.setString(0, email);
        List<Passengerinfo> pi=q.list();
        t.commit();
        s.close();
       return pi.get(0);
    }
    
    
    
}
