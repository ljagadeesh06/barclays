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
 * Class Name : com.barclays.designtest.trafficsignal.signal.IntersectionFactory
 * Description : Factory class to create appropriate intersection type based on the parameters
 */
public class IntersectionFactory {

    /**
     * Create an intersection with appropriate type
     * @param roadsType type of intersection
     * @param roads List of roads that are passing through this intersection
     * @return newly created Intersection object
     * @throws IllegalArgumentException when sufficient roads are not provided
     */
    public static Intersection createIntersection(String roadsType, List<Road> roads) throws IllegalArgumentException{
        Intersection intersection = null;
//        Creates and populates intersection with North-South bound and East-West bound roads
        if(roadsType.equalsIgnoreCase("NSEW")){
             intersection = new NSEWIntersection();
             intersection.populateSignals(roads);
        }
        return intersection;
    }


}
