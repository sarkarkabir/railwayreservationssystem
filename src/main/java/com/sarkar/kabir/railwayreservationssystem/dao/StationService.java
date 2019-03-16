/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.Addstation;
import org.springframework.stereotype.Service;

/**
 *
 * @author C5
 */
@Service
public interface StationService {

    public String insertAddstation(Addstation cm);

    public String updateAddstation(Addstation cm);

    public Integer deleteAddstation(int id);

    public String viewAddstation();

    public Addstation viewoneAddstation(int id);
}
