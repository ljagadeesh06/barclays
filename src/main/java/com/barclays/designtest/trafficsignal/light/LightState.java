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
/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.light.LightState
 * Description : Interface to represent the state of a light at intersection
 */
public interface LightState {

    /**
     * Move the cars from intersection
     * @param carsCount number of cars present on a road
     * @return updated number of cars as per the light specific logic
     */
    int moveCars(int carsCount);

    /**
     * Changes signal light from one state to another
     * @return Newly applied state of the light
     */
    LightState changeSignal();
}
