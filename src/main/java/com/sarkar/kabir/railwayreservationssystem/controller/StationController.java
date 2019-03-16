/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.StationService;
import com.sarkar.kabir.railwayreservationssystem.model.Addstation;
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
public class StationController {
   @Autowired
    StationService sv;

    @RequestMapping("/stationpage")
    public ModelAndView showstationpage() {
        String categorygsonlist = sv.viewAddstation();
        ModelAndView mv = new ModelAndView("station", "addAddstationObject1", new Addstation());
        mv.addObject("addstationmodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingaddstation", params = "Addaddstation")
    public String addaddstation(@ModelAttribute("addAddstationObject1") Addstation cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        sv.insertAddstation(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/stationpage";
    }

    @RequestMapping(value = "/addingaddstation", params = "Editaddstation")
    public String editaddstation(@ModelAttribute("addAddstationObject1") Addstation ad) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        sv.updateAddstation(ad);
        return "redirect:/stationpage";
    }

    @RequestMapping("removeaddstation/{Id}")
    public String removeaddaddstation(@PathVariable("Id") int categoryId) {
        sv.deleteAddstation(categoryId);
        return "redirect:/stationpage";
    }

    @RequestMapping("/editaddstationbutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        Addstation onecategory = sv.viewoneAddstation(categoryId);
        String categorygsonlist = sv.viewAddstation();
        ModelAndView mv = new ModelAndView("station", "addAddstationObject1", onecategory);
        mv.addObject("addstationmodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    } 
}
