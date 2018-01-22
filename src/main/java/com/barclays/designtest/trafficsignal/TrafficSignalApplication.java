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
package com.barclays.designtest.trafficsignal;


import com.barclays.designtest.trafficsignal.core.Constants;
import com.barclays.designtest.trafficsignal.core.Road;
import com.barclays.designtest.trafficsignal.signal.Intersection;
import com.barclays.designtest.trafficsignal.signal.IntersectionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.TrafficSignalApplication
 * Description : Main class to run the traffic signal application that is implemented for Barclays design test
 */

public class TrafficSignalApplication {

	public static void main(String[] args) {
	    try {

//	        Create the list of roads that are present at a signal intersection.
            List<Road> roads;
            roads = new ArrayList<>(4);
            roads.add(new Road("Snell Road", Constants.NORTH, "N"));
            roads.add(new Road("Snell Road", Constants.SOUTH, "S"));
            roads.add(new Road("Weaver Road", Constants.EAST, "E"));
            roads.add(new Road("Weaver Road", Constants.WEST, "W"));

//          Create signal object with roads and the type of signal that is served
            Intersection intersection = IntersectionFactory.createIntersection("NSEW", roads);
//          Start the signal process at this intersection
            intersection.startSignal();
        }catch(Exception ex){
	        ex.printStackTrace();
        }

	}
}
