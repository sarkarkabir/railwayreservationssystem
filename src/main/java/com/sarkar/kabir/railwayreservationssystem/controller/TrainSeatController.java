/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CompartmenttypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.TrainSeatService;
import com.sarkar.kabir.railwayreservationssystem.dao.TraininfoService;
import com.sarkar.kabir.railwayreservationssystem.model.TrainSeat;
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
public class TrainSeatController {

    @Autowired
    TrainSeatService tdao;
    @Autowired
    TraininfoService tis;
    @Autowired
    CompartmenttypeService cts;

    @RequestMapping("/showtrainpage")
    public ModelAndView showproductpage() {
        String trainseatlist = tdao.viewTrainSeat();
        String traininfolist = tis.viewTraininfo();
        String comtypelist = cts.viewCompartmenttype();

        ModelAndView mv = new ModelAndView("addtrainseat", "newtrainObject", new TrainSeat());
        mv.addObject("trainseatlist", trainseatlist);
        mv.addObject("traininfolist", traininfolist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/trainseatadd", params = "Add")
    public String addproductpage(@ModelAttribute("newtrainObject") TrainSeat ts) {
        tdao.insertTrainSeat(ts);

        return "redirect:/showtrainpage";
    }

    @RequestMapping(value = "/trainseatadd", params = "Edit")
    public String editProduct(@ModelAttribute("newtrainObject") TrainSeat ts) {
        tdao.updateTrainSeat(ts.getSeatid(), ts);

        return "redirect:/showtrainpage";
    }

    @RequestMapping("removingtrainseat/{tid}")
    public String removeproduct(@PathVariable("tid") int tid) {
        tdao.deleteTrainSeat(tid);
        return "redirect:/showtrainpage";
    }

    @RequestMapping("/editingtrainseat")
    public ModelAndView editproductpage(@RequestParam("gettid") int tid) {
        String trainseatlist = tdao.viewTrainSeat();
        String traininfolist = tis.viewTraininfo();
        String comtypelist = cts.viewCompartmenttype();
        ModelAndView mv = new ModelAndView("addtrainseat", "newtrainObject", tdao.viewOneTrainSeat(tid));
        mv.addObject("trainseatlist", trainseatlist);
        mv.addObject("traininfolist", traininfolist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("check", "false");
        return mv;
    }

}
