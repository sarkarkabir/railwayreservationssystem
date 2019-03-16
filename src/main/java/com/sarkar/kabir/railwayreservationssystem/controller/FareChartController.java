
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CompartmenttypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.FareChartService;
import com.sarkar.kabir.railwayreservationssystem.dao.PassengertypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.StationService;
import com.sarkar.kabir.railwayreservationssystem.dao.TraininfoService;
import com.sarkar.kabir.railwayreservationssystem.model.FareChart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FareChartController {
    @Autowired
    FareChartService fcdao; 
    @Autowired
    TraininfoService tidao;
    @Autowired
    CompartmenttypeService ctsdao;
    @Autowired
    PassengertypeService ptsdao;
    @Autowired
    StationService ssdao;
    
    
    
     @RequestMapping("/farechartpage")
    public ModelAndView showfareChartpage() {
        String farechartlist=fcdao.viewFareChart();
        String traininfolist = tidao.viewTraininfo();
        String comtypelist = ctsdao.viewCompartmenttype();
        String passengertypelist=ptsdao.viewPassengertype();
        String stationservlist=ssdao.viewAddstation();

        ModelAndView mv = new ModelAndView("fareamount", "newfarechartObject", new FareChart());
        mv.addObject("farechartlist", farechartlist);
        mv.addObject("traininfolist", traininfolist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("passengertypelist", passengertypelist);
        mv.addObject("stationservlist", stationservlist);
        mv.addObject("check", "true");
        return mv;
    }
     @RequestMapping("/farechartpageforuser")
    public ModelAndView showfareChartpages() {
        String farechartlist=fcdao.viewFareChart();
        String traininfolist = tidao.viewTraininfo();
        String comtypelist = ctsdao.viewCompartmenttype();
        String passengertypelist=ptsdao.viewPassengertype();
        String stationservlist=ssdao.viewAddstation();

        ModelAndView mv = new ModelAndView("fareamountforuser", "newfarechartObject", new FareChart());
        mv.addObject("farechartlist", farechartlist);
        mv.addObject("traininfolist", traininfolist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("passengertypelist", passengertypelist);
        mv.addObject("stationservlist", stationservlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/farechartvaluadd", params = "AddFare")
    public String addproductpage(@ModelAttribute("newfarechartObject") FareChart fc) {
        fcdao.insertFareChart(fc);
        
        return "redirect:/farechartpage";
    }

    @RequestMapping(value = "/farechartvaluadd", params = "EditFare")
    public String editProduct(@ModelAttribute("newfarechartObject") FareChart fc) {
        fcdao.updateFareChart(fc.getFareid(), fc);
       
        return "redirect:/farechartpage";
    }

    @RequestMapping("removingfarechart/{fid}")
    public String removeproduct(@PathVariable("fid") int fid) {
fcdao.deleteFareChart(fid);
        return "redirect:/farechartpage";
    }

  


    @RequestMapping("/editingfarechart")
    public ModelAndView editproductpage(@RequestParam("getfid") int fid) {
        String farechartlist=fcdao.viewFareChart();
        String traininfolist = tidao.viewTraininfo();
        String comtypelist = ctsdao.viewCompartmenttype();
        String passengertypelist=ptsdao.viewPassengertype();
         String stationservlist=ssdao.viewAddstation();
        ModelAndView mv = new ModelAndView("fareamount", "newfarechartObject", fcdao.viewOneFareChart(fid));
      mv.addObject("farechartlist", farechartlist);
        mv.addObject("traininfolist", traininfolist);
        mv.addObject("comtypelist", comtypelist);
        mv.addObject("passengertypelist", passengertypelist);
         mv.addObject("stationservlist", stationservlist);
        mv.addObject("check", "false");
        return mv;
    }
}
