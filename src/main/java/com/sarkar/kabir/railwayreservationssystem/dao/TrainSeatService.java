/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkar.kabir.railwayreservationssystem.dao;

import com.sarkar.kabir.railwayreservationssystem.model.TrainSeat;
import org.springframework.stereotype.Service;

/**
 *
 * @author dhaka
 */
@Service
public interface TrainSeatService {

    public String insertTrainSeat(TrainSeat ts);

    public String updateTrainSeat(int seat_id, TrainSeat ts);

    public String deleteTrainSeat(int seat_id);

    public String viewTrainSeat();

    public TrainSeat viewOneTrainSeat(int seat_id);
}
