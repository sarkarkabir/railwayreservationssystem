/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.daoImpl;

import com.google.gson.Gson;
import com.sarkar.kabir.railwayreservationssystem.dao.FareChartService;
import com.sarkar.kabir.railwayreservationssystem.model.Compartmenttype;
import com.sarkar.kabir.railwayreservationssystem.model.FareChart;
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
public class FareChartServiceImpl implements FareChartService {
   @Autowired
    SessionFactory sessionFactory;
    
    
    @Override
    public String insertFareChart(FareChart fc) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(fc);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateFareChart(int fare_id, FareChart fc) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        FareChart oneproductobject = (FareChart) s.get(FareChart.class, fare_id);
        oneproductobject.setFromstationid(fc.getFromstationid());
        oneproductobject.setTostationid(fc.getTostationid());
        oneproductobject.setComname(fc.getComname());
        oneproductobject.setFareamt(fc.getFareamt());
        oneproductobject.setPasstypeid(fc.getPasstypeid());
        s.update(oneproductobject);
        t.commit();
        s.close();
       return null;

         
    }

    @Override
    public String deleteFareChart(int fare_id) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        FareChart pm = (FareChart) s.get(FareChart.class, fare_id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewFareChart() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<FareChart> productslist = s.createQuery("from FareChart").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public FareChart viewOneFareChart(int fare_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        FareChart pm = (FareChart) s.get(FareChart.class, fare_id);
        t.commit();
        s.close();
        return pm;
    }

//    @Override
//    public FareChart viewOneFareChartbyStation(String from, String to, String com) {
//        Session s = sessionFactory.openSession();
//        Transaction t = s.getTransaction();
//        t.begin();
//        //Compartmenttype fc= new Compartmenttype();
//        FareChart fch = new FareChart();
//        System.out.println("ddddddddddddddddddddd" +from+"  to  " + to+"  com is " + com);
//        int cs= Integer.parseInt(com);
//        List<Compartmenttype> comn = s.createQuery("select comname from Compartmenttype where comtypeid=?").setParameter(0, cs).list();
//        System.out.println("lksjdflksjdflkjs  "+comn);
//        String oks = "";
//        Compartmenttype fc = comn.get(0);
////        String kd = fc.getComname();
////        oks= comn.toString();
////        
//        System.out.println("ct is ssssssssssssssssssss   "+fc.getComname());
////        fch.setComtypeid(comn);
////        System.out.println("kkkkkkkkkkkkkkk   "+fch.getComtypeid());
////        String ke= fch.getComtypeid();
////        System.out.println("kkkkkkkkkkkkkkk   "+ke);
//        
//        List<FareChart> productslist = s.createQuery("from FareChart where fromstationid=? and tostationid=? and comtypeid=?").setParameter(0, from).setParameter(1, to).setParameter(2, fc.getComname()).list();
//        System.out.println("result is ssssssssssssssssssss  "+productslist.get(0));
//        t.commit();
//        s.close();
//        return productslist.get(0);
//    }

    @Override
    public String viewOneFareChartbyStationByid(String from, String to, String com) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        System.out.println("ddddddddddddddddddddd" +from+"  to  " + to+"  com is " + com);
        int cs= Integer.parseInt(com);
        Query ct = s.createQuery("select comname from Compartmenttype where comtypeid=?").setParameter(0, cs);
        
        String ctname= ct.toString();
        System.out.println("ct is "+ctname);
        
        List<FareChart> productslist = s.createQuery("from FareChart where fromstationid=? and tostationid=? and comtypeid=?").setParameter(0, from).setParameter(1, to).setParameter(2, "AC").list();
        Gson g = new Gson();
        System.out.println("result is ssssssssssssssssssss  "+productslist);
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslist.get(0).toString();
    }

    @Override
    public FareChart viewOneFareChartbyStation(String from, String to, String com) {
          Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
       List<FareChart> productslist = s.createQuery("from FareChart where fromstationid=? and tostationid=? and comname=?").setParameter(0, from).setParameter(1, to).setParameter(2, com).list();
        System.out.println("result is ssssssssssssssssssss  "+productslist.get(0));
        t.commit();
        s.close();
        return productslist.get(0);
    }
    
    
}
