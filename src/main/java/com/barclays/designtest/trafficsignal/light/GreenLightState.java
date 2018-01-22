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
 * Class Name : com.barclays.designtest.trafficsignal.light.GreenLightState
 * Description : State class that represents the Green Light state of the traffic signal
 */
public class GreenLightState implements LightState {
    private int timer;

    /**
     * Initializes Green light state object with specified timer.
     * @param timer Specify if timer should start from zero value or above delay
     */
    public GreenLightState(int timer){
        this.timer = timer;
    }

    /**
     * Allow the cars to move and crosses the intersection.
     * A delay of specified time (2 seconds) will be maintained before actually moving any car.
     * During this time new car will be added that is coming on to road
     * Car count will not change after the delay as new car will be coming at the same time
     * when existing car crosses intersection
     * @param carsCount number of cars present on a road
     * @return updated cars count after the signal is on and cars started crossing intersection
     */
    @Override
    public int moveCars(int carsCount){
        this.timer++;
//        Move the cars only after delaying for specified time
        if(timer >= Constants.GREEN_WAIT_TIME){
            return carsCount;
        }else{
            return ++carsCount;
        }
    }

    /**
     * Changes signal from Green to Red
     * @return LightState interface with RedLightState
     */
    @Override
    public LightState changeSignal(){
        return new RedLightState(1);
    }

}
