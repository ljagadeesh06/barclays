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
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.TrafficSignalApplicationTest
 * Description : Test class to test the traffic signal application that is implemented for Barclays design test
 */
public class TrafficSignalApplicationTests {
	@Test
	public void buildSignal() {

            Road northRoad = new Road("Snell Road", Constants.NORTH, "N");
            Road southRoad = new Road("Snell Road", Constants.SOUTH, "S");
            Road eastRoad = new Road("Weaver Road", Constants.EAST, "E");
            Road westRoad = new Road("Weaver Road", Constants.WEST, "W");
            List<Road> roads;
            roads = new ArrayList<>(4);
            roads.add(northRoad);
            roads.add(southRoad);
            roads.add(eastRoad);
            roads.add(westRoad);

            Intersection signal = IntersectionFactory.createIntersection("NSEW", roads);
            Assert.assertTrue(signal != null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void buildInvalidSignal() {

            Road northRoad = new Road("Snell Road", Constants.NORTH, "N");
            Road southRoad = new Road("Snell Road", Constants.SOUTH, "S");
            Road eastRoad = new Road("Weaver Road", Constants.EAST, "E");
            List<Road> roads;
            roads = new ArrayList<>(4);
            roads.add(northRoad);
            roads.add(southRoad);
            roads.add(eastRoad);
            IntersectionFactory.createIntersection("NSEW", roads);
    }

    @Test
    public void properInitialOutput(){
        String result = properOutput(1);
        Assert.assertEquals("N = 0; S = 0; E = 0; W = 0", result);
    }
    @Test
    public void properOutputAfter10Iterations(){
        String result = properOutput(11);
        Assert.assertEquals("N = 6; S = 6; E = 8; W = 8", result);
    }
    @Test
    public void properOutputAfter20Iterations(){
        String result = properOutput(21);
        Assert.assertEquals("N = 13; S = 13; E = 16; W = 16", result);
    }

    private String properOutput(int iterations){
        Road northRoad = new Road("Snell Road", Constants.NORTH, "N");
        Road southRoad = new Road("Snell Road", Constants.SOUTH, "S");
        Road eastRoad = new Road("Weaver Road", Constants.EAST, "E");
        Road westRoad = new Road("Weaver Road", Constants.WEST, "W");
        List<Road> roads;
        roads = new ArrayList<>(4);
        roads.add(northRoad);
        roads.add(southRoad);
        roads.add(eastRoad);
        roads.add(westRoad);

        Intersection signal = IntersectionFactory.createIntersection("NSEW", roads);
        int iter=0;
        while(iter<iterations) {
            signal.changeSignal();
            iter++;
        }
        return signal.reportStatus().trim();

    }

}
