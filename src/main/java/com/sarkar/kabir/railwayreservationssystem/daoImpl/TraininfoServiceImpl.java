/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.TraininfoService;
import com.sarkar.kabir.railwayreservationssystem.model.Reservation;

import com.sarkar.kabir.railwayreservationssystem.model.Traininfo;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TraininfoServiceImpl implements TraininfoService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertTraininfo(Traininfo ti) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();

        t.begin();
        s.save(ti);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String updateTraininfo(int train_id, Traininfo ti) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Traininfo oneproductobject = (Traininfo) s.get(Traininfo.class, train_id);
        oneproductobject.setTrainnumber(ti.getTrainnumber());
        oneproductobject.setTrainname(ti.getTrainname());
        oneproductobject.setFromstationid(ti.getFromstationid());
        oneproductobject.setTostationid(ti.getTostationid());
        oneproductobject.setDepaturetime(ti.getDepaturetime());
        oneproductobject.setArivaltime(ti.getArivaltime());
        oneproductobject.setDayoff(ti.getDayoff());

        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteTraininfo(int train_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Traininfo pm = (Traininfo) s.get(Traininfo.class, train_id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewTraininfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Traininfo> productslist = s.createQuery("from Traininfo").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public Traininfo viewoneTraininfo(int train_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Traininfo pm = (Traininfo) s.get(Traininfo.class, train_id);
        t.commit();
        s.close();
        return pm;
    }

    @Override
    public String searchtrain(Traininfo ti) {
        Date d = ti.getD();
        String dd = new SimpleDateFormat("EEEEE").format(d);
        String a = ti.getFromstationid();
        String b = ti.getTostationid();
        System.out.println(a);
        System.out.println(b);
        String c = ti.getDayoff();
        System.out.println(d);
        Session s = sessionFactory.openSession();

        Transaction t = s.getTransaction();
        t.begin();
        List<Traininfo> offday = s.createQuery("select u from Traininfo u where dayoff=?").setParameter(0, dd).list();
//        Query q=s.createQuery("select * from Traininfo where fromstationid=?,tostationid=?,dayoff=?").setParameter(0,fromstid).setParameter(1, tostid).setParameter(2, dates);

        if (offday.size() > 0) {
            Gson g = new Gson();
            String traininfogson = g.toJson("");
            return traininfogson;
        } else {
            List<Traininfo> productslist = s.createQuery("select u from Traininfo u where fromstationid=? and tostationid=?").setParameter(0, a).setParameter(1, b).list();
            Gson g = new Gson();
            String traininfogson = g.toJson(productslist);
            t.commit();
            s.close();

            return traininfogson;
        }

    }



    @Override
    public Traininfo buyticket(int tid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Traininfo pm = (Traininfo) s.get(Traininfo.class, tid);
        t.commit();
        s.close();
        return pm;
    }

   

    @Override
    public int getPassengerId(String email) {
    Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
         Query query= s.createQuery("SELECT passid FROM Reservation WHERE emailid=?");
 String passid = query.setParameter(0, email).list().toString();
        int start = 0; // '(' position in string
        int end = 0; // ')' position in string
        for(int i = 0; i < passid.length(); i++) { 
    if(passid.charAt(i) == '[') // Looking for '(' position in string
       start = i;
    else if(passid.charAt(i) == ']') // Looking for ')' position in  string
       end = i;
}
    String number = passid.substring(start+1, end); 
    int ps = Integer.parseInt(number);    
        
  System.out.println(" passid ID VALUEEEEEEE......."+ps);       

        t.commit();
        s.close();

        return ps;  
    }
// @Override
//    public Traininfo onetrain(int tid) {
//        Session s = sessionFactory.openSession();
//        Transaction t = s.getTransaction();
//        t.begin();
//        Query q=s.createQuery("select u from Traininfo u where trainid=?");
//        List<Traininfo> up=q.setParameter(0,tid).list();
//        
//        t.commit();
//        s.close();
//        return up.get(0);
//    }
//    
//    @Override
//    public String insertreserveSeat(Reservation resid) {
//     Session s = sessionFactory.openSession();
//        Transaction t = s.getTransaction();
//
//        t.begin();
//        s.save(resid);
//        t.commit();
//        s.close();
//
//        return null;
//        
//    }

//    @Override
//    public Traininfo strain(Traininfo ti) {
//        Date d = ti.getD();
//        String dd = new SimpleDateFormat("EEEEE").format(d);
//        String a = ti.getFromstationid();
//        String b = ti.getTostationid();
//        System.out.println(a);
//        System.out.println(b);
//        String c = ti.getDayoff();
//        System.out.println(d);
//        Session s = sessionFactory.openSession();
//
//        Transaction t = s.getTransaction();
//        t.begin();
//        List<Traininfo> offday = s.createQuery("select u from Traininfo u where dayoff=?").setParameter(0, dd).list();
////        Query q=s.createQuery("select * from Traininfo where fromstationid=?,tostationid=?,dayoff=?").setParameter(0,fromstid).setParameter(1, tostid).setParameter(2, dates);
//
//        if (offday.size() > 0) {
//            Traininfo g = new Traininfo();
//            
//            return g;
//        } else {
//            List<Traininfo> productslist = s.createQuery("select u from Traininfo u where fromstationid=? and tostationid=?").setParameter(0, a).setParameter(1, b).list();
//            Traininfo g = new Traininfo();
//            
//            t.commit();
//            s.close();
//
//            return g;
//        }
//    }

    @Override
    public Traininfo strain(Traininfo ti) {
      return null;  
    }

    @Override
    public String insertReservation(Reservation resid) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();

        t.begin();
        s.save(resid);
        t.commit();
        s.close();
       return null;
        
    }

   
}
