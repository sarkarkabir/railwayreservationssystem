/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.FareChartService;
import com.sarkar.kabir.railwayreservationssystem.dao.PaymentService;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationDetailsService;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationService;
import com.sarkar.kabir.railwayreservationssystem.dao.TraininfoService;
import com.sarkar.kabir.railwayreservationssystem.model.Payment;
import com.sarkar.kabir.railwayreservationssystem.model.Traininfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author C5
 */
@Controller
public class PaymentController {

    @Autowired
    PaymentService paysd;
    @Autowired
    ReservationService rss;
    @Autowired
    ReservationDetailsService resdetdao;
    @Autowired
    TraininfoService tis;
    @Autowired
    FareChartService fcsdao;
    
    @RequestMapping("/showcartpage")
    public ModelAndView paymentpage() {
        String paymentlist = paysd.viewPayment();
        String traininforlist = tis.viewTraininfo();
        String reservationlist = rss.viewReservation();
        String reservationdetails =resdetdao.viewReservationDetails() ;
        String farecharlist =fcsdao.viewFareChart() ;
        
        ModelAndView mv = new ModelAndView("paymentticket", "paymentforticketp", new Payment());
        
        mv.addObject("paymentlist", paymentlist);
        mv.addObject("traininforlist", traininforlist);
        mv.addObject("reservationlist", reservationlist);
        mv.addObject("reservationdetails", reservationdetails);
        mv.addObject("farecharlist", farecharlist);
        mv.addObject("check", "true");
        return mv;
    }
    
    @RequestMapping(value = "/addpayment", params = "AddPay")
    public String addpayment(@ModelAttribute("paymentforticketp") Payment pi) {
        pi.setTotal(pi.getQty()*pi.getFareamt());
        paysd.insertPayment(pi);
        
        return "redirect:/showcartpage";
    }
    @RequestMapping(value = "/addpayment", params = "EditPay")
    public String addpaymented(@ModelAttribute("paymentforticketp") Payment pi) {
        pi.setTotal(pi.getQty()*pi.getFareamt());
        paysd.updatePayment(pi);
        
        
        return "redirect:/showcartpage";
    }
    
    @RequestMapping("removepayment/{Id}")
    public String removeaddaddstation(@PathVariable("Id") int categoryId) {
        paysd.deletePayment(categoryId);
        return "redirect:/showcartpage";
    }
@RequestMapping("/editpaymentbutton")
    public ModelAndView passingonedd(@RequestParam("getcid") int categoryId) {

       Payment onecategory = paysd.viewonePayment(categoryId);
        String categorygsonlist = paysd.viewPayment();
        ModelAndView mv = new ModelAndView("paymentticket", "paymentforticketp", onecategory);
        mv.addObject("onecategory", onecategory);
        mv.addObject("categorygsonlist", categorygsonlist);
        
        mv.addObject("check", "false");
        return mv;
    }
}
