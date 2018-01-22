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
package com.barclays.designtest.trafficsignal.core;

import com.barclays.designtest.trafficsignal.light.LightState;

/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.core.Road
 * Description : Road class to hold information about each road at a traffic signal
 */
public class Road {
//    Holds present lightstate like green or red for road
    private LightState lightState;

    private final String direction;
    private final String displayName;
//    Number of cars on this road at given moment
    private int carsCount;

    public Road(String name, String direction, String displayName){
        this.direction = direction;
        this.displayName = displayName;
        this.carsCount = 0;
    }

    public String getDirection() {
        return direction;
    }


    public void setLightState(LightState lightState) {
        this.lightState = lightState;
    }

    /**
     * Move the cars so that they can cross the intersection.
     * Internally it depends on the light state. Green light allows car to cross whereas Red light doesn't
     */
    public void moveCars(){
        this.carsCount = lightState.moveCars(this.carsCount);
    }

    /**
     * Return the status of this road at given moment
     * @return String with the display name of road and number of cars in the specified display format
     */
    public String reportStatus(){
        return displayName + " = " + carsCount + "; ";
    }

    /**
     * Changes the signal from green to red or the other way
     * Internally depends on the light state to change the signal
     */
    public void changeSignal(){
        this.lightState = lightState.changeSignal();
    }

}
