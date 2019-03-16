package com.sarkar.kabir.railwayreservationssystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sarkar.kabir.railwayreservationssystem.reportmodel.CompartmentReport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import com.sarkar.kabir.railwayreservationssystem.daoImpl.JasperReportDAO;
import com.sarkar.kabir.railwayreservationssystem.reportmodel.Farechartreport;
import com.sarkar.kabir.railwayreservationssystem.reportmodel.Paymentreport;
import com.sarkar.kabir.railwayreservationssystem.reportmodel.Reservationreports;
import com.sarkar.kabir.railwayreservationssystem.reportmodel.Reservebyptn;
/**
 *
 * @author User
 */
@Controller
public class ReportController {
    
    @RequestMapping(value = "/reportoneView", method = RequestMethod.GET)
    public String loadSurveyPg(
            @ModelAttribute("reportInputForm") CompartmentReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "report";
    }
    
    @RequestMapping(value = "/reportoneView", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") CompartmentReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "report1";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String compartname = reportInputForm.getCompartname();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("compartname", compartname);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
    
    @RequestMapping(value = "/reportreservation", method = RequestMethod.GET)
    public String loadSurveyPgReservation(
            @ModelAttribute("reportInputForm") Reservationreports reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "reportreservnone";
    }
    
    @RequestMapping(value = "/reportreservation", method = RequestMethod.POST)
    public String generateReportone(@ModelAttribute("reportInputForm") Reservationreports reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "reportreserv";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String tno = reportInputForm.getTno();
            String tdate = reportInputForm.getTdate();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("tno", tno);
            hmParams.put("tdate", tdate);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    @RequestMapping(value = "/reservationfareamt", method = RequestMethod.GET)
    public String loadSurveyPgdfd(
            @ModelAttribute("reportInputForm") Farechartreport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "farereport";
    }
    
    @RequestMapping(value = "/reservationfareamt", method = RequestMethod.POST)
    public String generateReportgsd(@ModelAttribute("reportInputForm") Farechartreport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "farereportamount";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String fromst = reportInputForm.getFromst();
            String tost = reportInputForm.getTost();
            String comn = reportInputForm.getComn();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("fromst", fromst);
            hmParams.put("tost", tost);
            hmParams.put("comn", comn);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
     @RequestMapping(value = "/paymetfareamt", method = RequestMethod.GET)
    public String loadSurveypay(
            @ModelAttribute("reportInputForm") Paymentreport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "payonereport";
    }
    
    
    @RequestMapping(value = "/paymetfareamt", method = RequestMethod.POST)
    public String generateReportgsd(@ModelAttribute("reportInputForm") Paymentreport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "payreport";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            String resid = reportInputForm.getResid();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("resid", resid);
          
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    @RequestMapping(value = "/ReservebyptnNumber", method = RequestMethod.GET)
    public String ReservebyptnNumb( @ModelAttribute("reportInputForm") Reservebyptn reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "ptnreservation";
    }
    
    
    @RequestMapping(value = "/ReservebyptnNumber", method = RequestMethod.POST)
    public String Reservebypt(@ModelAttribute("reportInputForm") Reservebyptn reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "reservationbyptn";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int ptn = reportInputForm.getPtn();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("ptn", ptn);
          
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
}
