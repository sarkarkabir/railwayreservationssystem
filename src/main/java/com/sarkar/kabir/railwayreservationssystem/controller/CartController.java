///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sarkar.kabir.railwayreservationssystem.controller;
//
//import com.google.gson.Gson;
//import com.sarkar.kabir.railwayreservationssystem.dao.ReservationDetailsService;
//import com.sarkar.kabir.railwayreservationssystem.dao.ReservationService;
//import com.sarkar.kabir.railwayreservationssystem.dao.TraininfoService;
//import com.sarkar.kabir.railwayreservationssystem.model.Reservation;
//import info.javaknowledge.project36.dao.ProductService;
//import com.sarkar.kabir.railwayreservationssystem.model.payment;
//import info.javaknowledge.project36.model.Product;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.ListIterator;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author User
// */
//@Controller
//public class CartController {
//
//    @Autowired
//    TraininfoService traindao;
//    @Autowired
//    ReservationService resdao;
//    @Autowired
//    ReservationDetailsService reddao;
//    
//
//    @RequestMapping("/showcartpage")
//    public ModelAndView showCartPage(HttpSession httpSession) {
//        String traininfolist = traindao.viewTraininfo();
//        String reservationlist = resdao.viewReservation();
//        String reservationdetailslist=reddao.viewReservationDetails();
//        ModelAndView mv = new ModelAndView("paymentforreserve", "newreservationObject", new Reservation());
//        //mv.addObject("phurchaselist", phurchaselist);
//        mv.addObject("traininfolist", traininfolist);
//        mv.addObject("reservationlist", reservationlist);
//        mv.addObject("reservationdetailslist", reservationdetailslist);
//        
//        mv.addObject("check", "true");
//       Gson g = new Gson();
//        
//        
//        ArrayList<payment> c = (ArrayList<payment>) httpSession.getAttribute("usercart");
//        if (c.isEmpty()) {
//            httpSession.setAttribute("cartempty", "true");
//             mv.addObject("itemsincartt", "null");
//            return mv;
//        } else {
//            String cartgson = g.toJson(c);
//            mv.addObject("itemsincart", cartgson);
//            httpSession.setAttribute("grandtotal", getGrandTotal(c));
//            httpSession.setAttribute("grandquantity", getgrandquantity(c));
//            httpSession.setAttribute("cartempty", "false");
//            return mv;
//        }
//    }
//
//    @RequestMapping("/addtocart")
//    public String addingToCart(@RequestParam("getReservationId") int ReservationId, HttpSession session) {
//
//        Reservation pm = resdao.viewOneReservation(ReservationId);
//        session.setAttribute("ReservationId", ReservationId);
//        String flag = "not inserted";
//        ArrayList<payment> cartarray = (ArrayList<payment>) session.getAttribute("usercart");
//
//        if (cartarray.isEmpty()) {
//            cartarray.add(new payment(pm.getResid(), pm.getTrainid(), 1, pm.getAdult(), pm.));
//            flag = "inserted";
//        } else {
//            Iterator<payment> lit = cartarray.iterator();
//            while (lit.hasNext()) {
//                payment d = lit.next();
//                if (d.getPid() == productId) {
//                    int index = cartarray.indexOf(d);
//                    String name = d.getPname();
//                    int qty = d.getQty() + 1;
//                    double price = d.getPrice();
//                    cartarray.remove(index);
//                    cartarray.add(index, new payment(productId, name, qty, price, ((qty) * price)));
//                    session.setAttribute("usercart", cartarray);
//                    flag = "inserted";
//                    break;
//                }
//            }
//            if (flag.equals("not inserted")) {
//                cartarray.add(new payment(pm.getProductid(), pm.getProductname(), 1, pm.getSaleprice(), pm.getSaleprice()));
//                session.setAttribute("usercart", cartarray);
//            }
//        }
//        session.setAttribute("grandquantity", getgrandquantity(cartarray));
////        UserCartDetails usercart = new UserCartDetails();
////        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
////        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
////        usercart.setProductsincart(cartarray.toString());
////        cdao.insertCartwithProducts(usercart);
//        return "redirect:/buyproductpage";
//    }
//
//    public int getgrandquantity(ArrayList<payment> items) {
//        int grandquant = 0;
//        ListIterator<payment> itr = items.listIterator();
//        while (itr.hasNext()) {
//            payment obj = (payment) itr.next();
//            grandquant = grandquant + obj.getQty();
//        }
//        return grandquant;
//    }
//
//    public double getGrandTotal(ArrayList<payment> item) {
//        double gtotal = 0;
//        ListIterator<payment> itr = item.listIterator();
//        while (itr.hasNext()) {
//            payment ob = (payment) itr.next();
//            gtotal = gtotal + (ob.getQty() * ob.getPrice());
//        }
//        return gtotal;
//    }
//
//    @RequestMapping(value = "/editquantity")
//    public String editCart(@RequestParam("getproductid") int id, @RequestParam("value") String sign, HttpSession session) {
//        ArrayList<payment> c = (ArrayList<payment>) session.getAttribute("usercart");
//        Iterator<payment> lit = c.iterator();
//        while (lit.hasNext()) {
//            payment d = lit.next();
//            int index = c.indexOf(d);
//            if (d.getPid() == id) {
//                String name = d.getPname();
//                int qty = d.getQty();
//                double price = d.getPrice();
//                c.remove(index);
//                if (sign.equals("decrease") && qty > 1) {
//                    c.add(index, new payment(id, name, qty - 1, price, ((qty + 1) * price)));
//                } else if (sign.equals("decrease") && qty == 1) {
//                    c.add(index, new payment(id, name, 1, price, price));
//                } else if (sign.equals("increase") && qty < 100) {
//                    c.add(index, new payment(id, name, qty + 1, price, ((qty + 1) * price)));
//                } else {
//                    c.add(index, new payment(id, name, qty, price, ((qty) * price)));
//                }
//                break;
//            }
//        }
//        session.setAttribute("grandquantity", getgrandquantity(c));
//        session.setAttribute("usercart", c);
//
//        return "redirect:/showcartpage";
//    }
//
//    @RequestMapping("/removeproductitem")
//    public String removeproductitem(@RequestParam("pid") int productid, HttpSession session) {
//        @SuppressWarnings("unchecked")
//        ArrayList<payment> cartitems = (ArrayList<payment>) session.getAttribute("usercart");
//        Iterator<payment> list = (Iterator<payment>) cartitems.iterator();
//        while (list.hasNext()) {
//            payment c = list.next();
//            if (c.getPid() == productid) {
//                cartitems.remove(cartitems.indexOf(c));
//                break;
//            }
//        }
//        session.setAttribute("grandquantity", getgrandquantity(cartitems));
//        session.setAttribute("usercart", cartitems);
//        return "redirect:/showcartpage";
//    }
//}
