/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CompartmentSubTypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.CompartmenttypeService;
import com.sarkar.kabir.railwayreservationssystem.model.CompartmentSubType;
import javax.servlet.http.HttpServletRequest;
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
public class CompartmentSubTypeController {

    @Autowired
    CompartmentSubTypeService cstdao;
    @Autowired
    CompartmenttypeService ctsdao;

    @RequestMapping("/showcomsubtypepage")
    public ModelAndView showsubtypepage() {
        String comsubtypelist = cstdao.viewCompartmentSubType();
        String comtypelist = ctsdao.viewCompartmenttype();

        ModelAndView mv = new ModelAndView("addcomsubtype", "newcomsubtypeObject", new CompartmentSubType());
        mv.addObject("comsubtypelist", comsubtypelist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/comsubtypeadd", params = "Addsub")
    public String addproductpage(@ModelAttribute("newcomsubtypeObject") CompartmentSubType cs, HttpServletRequest request) {
        cstdao.insertCompartmentSubType(cs);

        return "redirect:/showcomsubtypepage";
    }

    @RequestMapping(value = "/comsubtypeadd", params = "Editsub")
    public String editProduct(@ModelAttribute("newcomsubtypeObject") CompartmentSubType cs, HttpServletRequest request) {
        cstdao.updateCompartmentSubType(cs.getComsubid(), cs);

        return "redirect:/showcomsubtypepage";
    }

    @RequestMapping("removingcomsubtype/{sid}")
    public String removeproduct(@PathVariable("sid") int sid) {
        cstdao.deleteCompartmentSubType(sid);
        return "redirect:/showcomsubtypepage";
    }

    @RequestMapping("/editingcomsubtype")
    public ModelAndView editproductpage(@RequestParam("getsid") int sid) {
        String comsubtypelist = cstdao.viewCompartmentSubType();
        String comtypelist = ctsdao.viewCompartmenttype();

        ModelAndView mv = new ModelAndView("addcomsubtype", "newcomsubtypeObject", cstdao.viewOneCompartmentSubType(sid));
        mv.addObject("comsubtypelist", comsubtypelist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("check", "false");
        return mv;
    }
}
