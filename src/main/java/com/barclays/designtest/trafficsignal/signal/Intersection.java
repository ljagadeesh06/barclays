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
package com.barclays.designtest.trafficsignal.signal;


import com.barclays.designtest.trafficsignal.core.Road;

import java.util.List;

/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.signal.Intersection
 * Description : Interface to represent any intersection with appropriate methods to act on
 */
public interface Intersection {

    /**
     * Changes signal in the intersection in a sequence
     */
    void changeSignal();

    /**
     * Initializes and builds intersection with appropriate road list and default traffic lights
     * @param roads List of roads that belong to this intersection
     * @throws IllegalArgumentException when road list is not sufficient as per intersection type
     */
    void populateSignals(List<Road> roads) throws IllegalArgumentException;

    /**
     * Returns the status of the signal. Combined status of all roads that are passing through this intersection
     * @return String representing current status (number of cars in each road) of this intersection
     */
    String reportStatus();

    /**
     * Initializes and starts the signal process
     */
    void startSignal();

}
