/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.PassengertypeService;
import com.sarkar.kabir.railwayreservationssystem.model.Passengertype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class PassengertypeController {
    @Autowired
     PassengertypeService ps;

    @RequestMapping("/typepassengerpage")
    public ModelAndView showstationpage() {
        String categorygsonlist = ps.viewPassengertype();
        ModelAndView mv = new ModelAndView("passengertypeshow", "addPassengersObject1", new Passengertype());
        mv.addObject("passtypeshowmodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingpassengerty", params = "Addpassengertype")
    public String addaddstation(@ModelAttribute("addPassengersObject1") Passengertype cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        ps.insertPassengertype(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/typepassengerpage";
    }

    @RequestMapping(value = "/addingpassengerty", params = "Editpassengertype")
    public String editaddstation(@ModelAttribute("addPassengersObject1") Passengertype cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        ps.updatePassengertype(cm);
        return "redirect:/typepassengerpage";
    }

    @RequestMapping("removepassengerst/{Id}")
    public String removeaddaddstation(@PathVariable("Id") int categoryId) {
        ps.deletePassengertype(categoryId);
        return "redirect:/typepassengerpage";
    }

    @RequestMapping("/editremovepassengertbutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        Passengertype onecategory = ps.viewonePassengertype(categoryId);
        String categorygsonlist = ps.viewPassengertype();
        ModelAndView mv = new ModelAndView("passengertypeshow", "addPassengersObject1", onecategory);
        mv.addObject("passtypeshowmodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    } 
}
