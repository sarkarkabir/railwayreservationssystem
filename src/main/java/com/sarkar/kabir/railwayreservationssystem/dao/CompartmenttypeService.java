/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Compartmenttype;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface CompartmenttypeService {
     public String insertCompartmenttype(Compartmenttype cm);

    public String updateCompartmenttype(Compartmenttype cm);

    public Integer deleteCompartmenttype(int id);

    public String viewCompartmenttype();

    public Compartmenttype viewoneCompartmenttype(int id); 
    public Compartmenttype viewoneCompartmenttypeComname(String comn);
    
}
