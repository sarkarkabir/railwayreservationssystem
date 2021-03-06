/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CompartmentSubTypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.FareChartService;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationDetailsService;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationService;
import com.sarkar.kabir.railwayreservationssystem.model.ReservationDetails;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhaka
 */
@Controller
public class ReservationDetailsController {
   
    
    @Autowired
    ReservationDetailsService rdsDao;
    @Autowired
    ReservationService  rsvDao ;
    @Autowired
    CompartmentSubTypeService cstsDao;
    @Autowired
    FareChartService fcsDao;
   
   @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "journeydate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    
    
     @RequestMapping("/reservationdetailspage")
    public ModelAndView showreservationpage() {
        String reservationdetaillist=rdsDao.viewReservationDetails();
        String reservationslist = rsvDao.viewReservation();
       String compartservicelist = cstsDao.viewCompartmentSubType();
       String farechartslist = fcsDao.viewFareChart();
//        User uu=new User();
//        uu.getEmailid();
        ModelAndView mv = new ModelAndView("addreservationdetails", "newreservationdetailsObject", new ReservationDetails());
        mv.addObject("reservationdetaillist", reservationdetaillist);
        mv.addObject("reservationslist", reservationslist);
        mv.addObject("compartservicelist", compartservicelist);
        mv.addObject("farechartslist", farechartslist);
        mv.addObject("check", "true");
        return mv;
    }
//
//    @RequestMapping(value = "/reservationDetailsadd", params = "AddReservationD")
//    public String addReservationpage(@ModelAttribute("newreservationdetailsObject") ReservationDetails rvds ) {
//        rdsDao.insertReservationDetails(rvds);
//        
//        return "redirect:/reservationdetailspage";
//    }

    @RequestMapping(value = "/reservationDetailsadd", params = "EditReservationD")
    public String editReservationDetails(@ModelAttribute("newreservationObject") ReservationDetails rvds ) {
        rdsDao.updateReservationDetails(rvds.getResdetid(), rvds);
       
        return "redirect:/reservationdetailspage";
    }

    @RequestMapping("removingreservationDet/{rdid}")
    public String removeproduct(@PathVariable("rdid") int rdid) {
rdsDao.deleteReservationDetails(rdid);
        return "redirect:/reservationdetailspage";
    }

  


    @RequestMapping("/editingreservationdet")
    public ModelAndView editreservardetailspage(@RequestParam("getrdid") int rdid) {
        String reservationdetaillist=rdsDao.viewReservationDetails();
        String reservationslist = rsvDao.viewReservation();
       String compartservicelist = cstsDao.viewCompartmentSubType();
       String farechartslist = fcsDao.viewFareChart();
       
        ModelAndView mv = new ModelAndView("addreservationdetails", "newreservationdetailsObject", rdsDao.viewOneReservationDetails(rdid));
      mv.addObject("reservationdetaillist", reservationdetaillist);
        mv.addObject("reservationslist", reservationslist);
        mv.addObject("compartservicelist", compartservicelist);
        mv.addObject("farechartslist", farechartslist);
        mv.addObject("check", "false");
        return mv;
    }
}
