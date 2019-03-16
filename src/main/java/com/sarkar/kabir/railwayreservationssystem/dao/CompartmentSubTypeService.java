/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.CompartmentSubType;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface CompartmentSubTypeService {
     public String insertCompartmentSubType(CompartmentSubType cst);

    public String updateCompartmentSubType(int comsub_id, CompartmentSubType cst);

    public String deleteCompartmentSubType(int comsub_id);

    public String viewCompartmentSubType();

    public CompartmentSubType viewOneCompartmentSubType(int comsub_id);
    public CompartmentSubType viewOneCompartmentSubName(String  comsu);
}
