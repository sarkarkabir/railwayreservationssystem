/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CompartmenttypeService;

import com.sarkar.kabir.railwayreservationssystem.model.Compartmenttype;
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
public class CompartmenttypeController {

    @Autowired
    CompartmenttypeService cts;

    @RequestMapping("/compartpage")
    public ModelAndView showstationpage() {
        String categorygsonlist = cts.viewCompartmenttype();        
        ModelAndView mv = new ModelAndView("compartmentinfo", "addCompartmentObject1", new Compartmenttype());
        mv.addObject("compartmentmodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingcompartment", params = "Addcompartmenttype")
    public String addaddstation(@ModelAttribute("addCompartmentObject1") Compartmenttype cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cts.insertCompartmenttype(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/compartpage";
    }

    @RequestMapping(value = "/addingcompartment", params = "Editcompartmenttype")
    public String editaddstation(@ModelAttribute("addCompartmentObject1") Compartmenttype cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cts.updateCompartmenttype(cm);
        return "redirect:/compartpage";
    }

    @RequestMapping("removecompartmenttype/{Id}")
    public String removeaddaddstation(@PathVariable("Id") int categoryId) {
        cts.deleteCompartmenttype(categoryId);
        return "redirect:/compartpage";
    }

    @RequestMapping("/editcompartmenttypebutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        Compartmenttype onecategory = cts.viewoneCompartmenttype(categoryId);
        String categorygsonlist = cts.viewCompartmenttype();
        ModelAndView mv = new ModelAndView("compartmentinfo", "addCompartmentObject1", onecategory);
        mv.addObject("compartmentmodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
