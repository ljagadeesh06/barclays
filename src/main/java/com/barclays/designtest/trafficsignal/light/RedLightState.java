/*
 * **************************************************************************
 *  *
 *  *
 *  *
 *  *  *****************************************************
 *  *  https://www.barclaycardus.com/
 *  *  *****************************************************
 *  *
 *  ************************************************************
 */
package com.barclays.designtest.trafficsignal.light;

import com.barclays.designtest.trafficsignal.core.Constants;
/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.light.RedLightState
 * Description : State class that represents the Red Light state of the traffic signal
 */
public class RedLightState implements LightState {
    private int timer;

    /**
     * Initializes Red light state object with specified timer.
     * @param timer To differentiate if the state is called first time after initializing the signal or called subsequently with state change
     */
    public RedLightState(int timer){
        this.timer = timer;
    }

    /**
     * Do not allow the cars to move from the signal. At the same time append new cars that are coming in to the road
     * @param carsCount number of cars present on a road
     * @return updated cars count after the signal is on and cars started crossing intersection
     */
    @Override
    public int moveCars(int carsCount){
        if(timer==0) {
            timer = 1;
            return carsCount;
        }else{
            return ++carsCount;
        }
    }
    /**
     * Changes signal from Red to Green
     * @return LightState interface with GreenLightState
     */
    @Override
    public LightState changeSignal(){
        return new GreenLightState(Constants.SIGNAL_RESET);
    }
}
