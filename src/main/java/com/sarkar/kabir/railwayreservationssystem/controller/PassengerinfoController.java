/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.PassengerinfoService;
import com.sarkar.kabir.railwayreservationssystem.model.Passengerinfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
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
public class PassengerinfoController {

    @Autowired
    PassengerinfoService pis;
    

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "passdob", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    @InitBinder
    public void myInitBinder1(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "regdate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    @RequestMapping("/passengerpage")
    public ModelAndView showstationpage() {
        String categorygsonlist = pis.viewPassengerinfo();
        ModelAndView mv = new ModelAndView("passengerinfodetails", "addPassengerinfoObject1", new Passengerinfo());
        mv.addObject("passinfomodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingpassengerinfo", params = "AddPassengerinfo")
    public String addaddstation(@ModelAttribute("addPassengerinfoObject1") Passengerinfo cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        
        pis.insertPassengerinfo(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/passengerpage";
    }
    @RequestMapping(value = "/addingpassengerinfo", params = "EditPassengerinfo")
    public String editaddstation(@ModelAttribute("addPassengerinfoObject1") Passengerinfo ad,HttpSession session) {
    
        //ModelAndView mv =new ModelAndView("AddCategory");
        pis.updatePassengerinfo(ad);
        return "redirect:/passengerpage";
    }

    

    @RequestMapping("removepassengerinfoid/{Id}")
    public String removeaddaddstation(@PathVariable("Id") int passengerinfoId) {
        pis.deletePassengerinfo(passengerinfoId);
        return "redirect:/passengerpage";
    }

    @RequestMapping("/editpassengerinfobutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int passengerinfoId) {

       Passengerinfo onecategory = pis.viewonePassengerinfo(passengerinfoId);
        String categorygsonlist = pis.viewPassengerinfo();
        ModelAndView mv = new ModelAndView("passengerinfodetails", "addPassengerinfoObject1", onecategory);
        mv.addObject("passinfomodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    } 
}
