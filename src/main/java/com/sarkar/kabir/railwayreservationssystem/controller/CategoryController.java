/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.controller;

import com.sarkar.kabir.railwayreservationssystem.dao.CategoryService;
import com.sarkar.kabir.railwayreservationssystem.model.Category;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService cat;
    @Autowired
    private ServletContext servletContext;
    

    @RequestMapping("/showingcategorypage")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewCategory();
        ModelAndView mv = new ModelAndView("addcategory", "addCategoryObject1", new Category());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingcategory", params = "Addcategory")
    public String addcategory(@ModelAttribute("addCategoryObject1") Category cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertCategory(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        System.out.println(servletContext.getContextPath()+".......");
        String p=servletContext.getContextPath();
         p = "E:\\softwar\\railwayreservationssystem\\src\\main\\webapp\\resources\\pimage\\"+String.valueOf(cm.getCatid()) + "" + ".jpg" ; 
         System.out.println(p);
        MultipartFile filedet = cm.getPimage();
        if (!filedet.isEmpty()) {
            try {
                byte[] bytes = filedet.getBytes();
                System.out.println(bytes.length);
                FileOutputStream fos = new FileOutputStream(new File(p));
                BufferedOutputStream bs = new BufferedOutputStream(fos); 
                bs.write(bytes);
                bs.close();
                fos.close();
                Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
            } catch (Exception e) {
                System.out.println("Exception Arised" + e);
            }
        } else {
            System.out.println("File is Empty not Uploaded");
        }
         
         
        return "redirect:/showingcategorypage";
    }

    @RequestMapping(value = "/addingcategory", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCategoryObject1") Category cm,HttpServletRequest request) {

        //ModelAndView mv =new ModelAndView("AddCategory");
         String p=servletContext.getContextPath();
         p = "E:\\softwar\\railwayreservationssystem\\src\\main\\webapp\\resources\\pimage\\"+String.valueOf(cm.getCatid()) + "" + ".jpg" ; 
          System.out.println(request.getSession().getServletContext());
        cat.updateCategory(cm);
        return "redirect:/showingcategorypage";
    }

    @RequestMapping("removecategory/{Id}")
    public String removecategory(@PathVariable("Id") String categoryId) {
        cat.deleteCategory(categoryId);
        return "redirect:/showingcategorypage";
    }

    @RequestMapping("/editcategorybutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") String categoryId) {

        Category onecategory = cat.viewOneCategory(categoryId);
        String categorygsonlist = cat.viewCategory();
        ModelAndView mv = new ModelAndView("addcategory", "addCategoryObject1", onecategory);
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
