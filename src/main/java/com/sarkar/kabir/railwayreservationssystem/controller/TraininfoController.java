package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CompartmentSubTypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.CompartmenttypeService;
import com.sarkar.kabir.railwayreservationssystem.dao.FareChartService;
import com.sarkar.kabir.railwayreservationssystem.dao.PassengerinfoService;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationDetailsService;
import com.sarkar.kabir.railwayreservationssystem.dao.ReservationService;
import com.sarkar.kabir.railwayreservationssystem.dao.StationService;
import com.sarkar.kabir.railwayreservationssystem.dao.TraininfoService;
import com.sarkar.kabir.railwayreservationssystem.dao.Userservice;
import com.sarkar.kabir.railwayreservationssystem.model.CompartmentSubType;
import com.sarkar.kabir.railwayreservationssystem.model.Compartmenttype;
import com.sarkar.kabir.railwayreservationssystem.model.FareChart;
import com.sarkar.kabir.railwayreservationssystem.model.Passengerinfo;
import com.sarkar.kabir.railwayreservationssystem.model.Reservation;
import com.sarkar.kabir.railwayreservationssystem.model.ReservationDetails;
import com.sarkar.kabir.railwayreservationssystem.model.Traininfo;
import com.sarkar.kabir.railwayreservationssystem.model.User;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.enterprise.inject.Model;
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
public class TraininfoController {

    @Autowired
    TraininfoService tis;
    @Autowired
    StationService svv;
    @Autowired
    ReservationService rss;
    @Autowired
    CompartmenttypeService cms;
    @Autowired
    PassengerinfoService psdao;
    @Autowired
    Userservice userdao;
    @Autowired
    FareChartService faredao;
     @Autowired
     ReservationDetailsService resdetdao;
     @Autowired
     CompartmentSubTypeService cstsdao;
     

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "d", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    @InitBinder
    public void myInitBinder1(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "resdate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }

    @RequestMapping("/availabletrainpage")
    public ModelAndView SearchPagejj(HttpSession session) {

        String traininforlist = tis.viewTraininfo();
        String stationserlist = svv.viewAddstation();
        ModelAndView mv = new ModelAndView("trainsearch", "addsearchoneObject", new Traininfo());
        mv.addObject("traininforlist", traininforlist);
        mv.addObject("stationserlist", stationserlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping("/availableforaddtrainpage")
    public ModelAndView SearchPagejj(@ModelAttribute("addsearchoneObjectttt") Traininfo traininfo, HttpSession session) {

        String dd = new SimpleDateFormat("yyyy/MM/dd").format(traininfo.getD());
        session.setAttribute("d", dd);
        session.setAttribute("trainnumber", traininfo.getTrainnumber());
        session.setAttribute("trainids", traininfo.getTrainid());
        session.setAttribute("fromstationid", traininfo.getFromstationid());
        session.setAttribute("tostationid", traininfo.getTostationid());
        session.setAttribute("depaturetime", traininfo.getDepaturetime());
        session.setAttribute("arivaltime", traininfo.getArivaltime());
        session.setAttribute("dayoff", traininfo.getDayoff());
        System.out.println(session.getAttribute("fromstationid")+"++++++++++++++++");

        String a = tis.searchtrain(traininfo);
        ModelAndView mv = new ModelAndView("viewdestination", "addsearchoneObject", new Traininfo());
        mv.addObject("Traininforlist", a);
        mv.addObject("check", "true");
        return mv;
    }
    //view destination page
    @RequestMapping("/viewTrain")
    public ModelAndView showTrainview() {
        ModelAndView mv = new ModelAndView("viewdestination", "viewtrainlistc", new Traininfo());
        // mv.addObject("traininforlist",traininforlist);
        mv.addObject("check", "true");
        return mv;

    }

    //buy ticket page//
    @RequestMapping("/buyticet")
    public ModelAndView showreservepagebyserchtrain(@RequestParam("gettid") int traininfoId) {
        //String ab=tis.buyticketreservation(res.getAdult(),res.getChild());
        String traininforlist = tis.viewTraininfo();
        String reservartionslist = rss.viewReservation();
        String compartmentlist = cms.viewCompartmenttype();
        String stationserlist = svv.viewAddstation();
        Traininfo traininforlistsp = tis.buyticket(traininfoId);

        
        ModelAndView mv = new ModelAndView("buyticketpassenger", "viewtrainlistc", new Reservation());
        mv.addObject("traininforlist", traininforlist);
        mv.addObject("traininforlistsp", traininforlistsp);
        mv.addObject("reservartionslist", reservartionslist);
        mv.addObject("compartmentlist", compartmentlist);
        mv.addObject("stationserlist", stationserlist);
        mv.addObject("check", "true");
        return mv;

    }
//01953597400
    //show reservation page
    @RequestMapping("/reservationpage")
    public ModelAndView showreservationpage(@ModelAttribute("viewtrainlistc") Reservation re, HttpSession session) {
        String traininforlist = tis.viewTraininfo();
      
        String compartmentlist = cms.viewCompartmenttype();
        String reservationlist = rss.viewReservation();
        String comsublist=cstsdao.viewCompartmentSubType();
        int adltage = re.getAdult();
        // int passengrId=(Integer)session.getAttribute("PassId");
        session.setAttribute("adltseat", adltage);
        System.out.println("adult seat no  " + adltage);
        int childs = re.getChild();
        session.setAttribute("childs", childs);
        session.setAttribute("trainsid", re.getTrainid());
        session.setAttribute("trainnum", re.getTrainnumber());
        session.setAttribute("trainname", re.getTrainname());
        session.setAttribute("dtime", re.getDepaturetime());
        session.setAttribute("atime", re.getArivaltime());
        System.out.println(re.getTrainid());
        System.out.println(re.getDepaturetime());
        User user = userdao.viewUser(session.getAttribute("UserEmail").toString());
        System.out.println("-------------------" + session.getAttribute("UserEmail").toString());
        Passengerinfo p = psdao.viewonePassengerbyEmail(user.getEmailid());
        session.setAttribute("pasid", p.getPassid());
//        Compartmenttype t=new Compartmenttype();
//       session.setAttribute("comtone", t.getComname());
//        System.out.println("");
//        int comtype = re.getComtypeid();
//        session.setAttribute("comtypeii", comtype);
//          String com=re.getComname();
//          session.setAttribute("comname", com);
    //Compartmenttype r=new Compartmenttype();
    //session.setAttribute("comname", r.getComname());
  
        ModelAndView mv = new ModelAndView("addreservation", "newreservationObject", new Reservation());
        mv.addObject("traininforlist", traininforlist);
        mv.addObject("compartmentlist", compartmentlist);
        mv.addObject("reservationlist", reservationlist);
        mv.addObject("comsublist", comsublist);
//        mv.addObject("passerngerinfolist", passerngerinfolist);
//            mv.addObject("traininfolist", traininfolist);
        mv.addObject("check", "true");
        return mv;
    }

//    
    @RequestMapping(value = "/reservationadd", params = "AddReser")
    public String addReservationpage(@ModelAttribute("newreservationObject") Reservation rv, HttpSession session, CompartmentSubType cst,FareChart fc) {

        rv.setPassid(Integer.parseInt(session.getAttribute("pasid").toString()));
        rv.setPtn((int) (Math.random() * 100000));
        //System.out.println(session.getAttribute("tostationid").toString()+"////////////////////");
        rv.setFromstationid(session.getAttribute("fromstationid").toString());
        rv.setTostationid(session.getAttribute("tostationid").toString());
        //rv.setComname(session.getAttribute(name));
        //rv.setComname(session.getAttribute("comname").toString());
        rv.setDepaturetime(session.getAttribute("dtime").toString());
        rv.setArivaltime(session.getAttribute("atime").toString());
       //rv.setComtypeid(session.getAttribute("comtone").toString());
       tis.insertReservation(rv);
       //today
        String vv=session.getAttribute("fromstationid").toString();
        String tt=session.getAttribute("tostationid").toString();
        String ss=fc.getComname();
        
        System.out.println("tttttttttttttt "+vv);
        System.out.println(""+tt);
        System.out.println(""+ss);
        
       FareChart farechart=faredao.viewOneFareChartbyStation(vv, tt, ss);
        System.out.println("Bangladesh is a agriculture country her population "+farechart);
        //CompartmentSubType cst=cstsdao.viewOneCompartmentSubName(0)
             String tp=cst.getComsubname();
       CompartmentSubType st=cstsdao.viewOneCompartmentSubName(tp);
       
       
    ArrayList<ReservationDetails> list = new  ArrayList<ReservationDetails>(); 
    int x=rv.getAdult()+rv.getChild();
        for (int i = 0; i <x; i++) {
           
           ReservationDetails details=new ReservationDetails();
           details.setResdetid(details.getResdetid());
            details.setResid(rv.getResid());
            details.setFareid(farechart.getFareid());
           details.setComsubid(st.getComsubid());
           
           //details.setSeatno(details.getSeatno());
           //rv.setPtn((int) (Math.random() * 100000));
           details.setSeatno((int)(Math.random() * 100));
          
           list.add(details);
        }
        
           
            
            resdetdao.insertReservationDetails(list);
        
        return "redirect:/reservationpage";
    }
@RequestMapping("/editingreservation")
    public ModelAndView editproductpage(@RequestParam("getrid") int rid) {
        String reservationlist=rss.viewReservation();
        String passerngerinfolist = psdao.viewPassengerinfo();
       String traininfolist = tis.viewTraininfo();
        ModelAndView mv = new ModelAndView("addreservation", "newreservationObject", rss.viewOneReservation(rid));
      mv.addObject("reservationlist", reservationlist);
        mv.addObject("passerngerinfolist", passerngerinfolist);
        mv.addObject("traininfolist", traininfolist);
        mv.addObject("check", "false");
        return mv;
    }
//    user reservation start //////////////////////////////////////
   

//    user reservation End//////////////////////////////////////////////////////////////
    //reserve method
    @RequestMapping("/traininformationpage")
    public ModelAndView showcatpage() {
        String traininforlist = tis.viewTraininfo();
        String stationserlist = svv.viewAddstation();
        ModelAndView mv = new ModelAndView("traininformation", "addtraininfoObject1", new Traininfo());
        mv.addObject("traininforlist", traininforlist);
        mv.addObject("stationserlist", stationserlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingtraininfo", params = "AddTrain")
    public String addcategory(@ModelAttribute("addtraininfoObject1") Traininfo ti) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        tis.insertTraininfo(ti);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/traininformationpage";
    }

    @RequestMapping(value = "/addingtraininfo", params = "EditTrain")
    public String editcategory(@ModelAttribute("addtraininfoObject1") Traininfo ti) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        tis.updateTraininfo(ti.getTrainid(), ti);
        return "redirect:/availabletrainpage";
    }

    @RequestMapping("removetraininfo/{Id}")
    public String removecategory(@PathVariable("Id") int traininfoId) {
        tis.deleteTraininfo(traininfoId);
        return "redirect:/traininformationpage";
    }

    @RequestMapping("/edittrainfobutton")
    public ModelAndView passingonecategory(@RequestParam("gettid") int traininfoId) {

        String traininforlist = tis.viewTraininfo();
        String stationserlist = svv.viewAddstation();
        ModelAndView mv = new ModelAndView("traininformation", "addtraininfoObject1", tis.viewoneTraininfo(traininfoId));
        mv.addObject("traininforlist", traininforlist);
        mv.addObject("stationserlist", stationserlist);
        mv.addObject("check", "false");
        return mv;
    }

    
    
     @RequestMapping("/blogpost")
    public ModelAndView blogoe(HttpSession session) {

        
        ModelAndView mv = new ModelAndView("blog", "addsearchoneObject", new Traininfo());
        
        mv.addObject("check", "true");
        return mv;
    }
    //for payment
    
    
    
}
