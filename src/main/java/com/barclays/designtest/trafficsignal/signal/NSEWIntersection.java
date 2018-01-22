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

import com.barclays.designtest.trafficsignal.core.Constants;
import com.barclays.designtest.trafficsignal.core.Road;
import com.barclays.designtest.trafficsignal.light.GreenLightState;
import com.barclays.designtest.trafficsignal.light.RedLightState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.signal.NSEWIntersection
 * Description : Intersection class to represent the intersection with total four roads
 * (North and South bound, East and West bound roads)
 */
public class NSEWIntersection implements Intersection {

    private Map<Integer, List<Road>> roadMap;
    private Integer currentRoadMap;
    private Integer timer;


    public NSEWIntersection(){
        this.currentRoadMap = 1;
        this.timer = -1;
    }

    /**
     * Builds the intersection object with North and South bound roads as first roads to get Green signal
     * and East and West bound rounds next
     * @param roads List of roads that are passing through this intersection
     * @throws IllegalArgumentException when enough roads are not passed
     */
    @Override
    public void populateSignals(List<Road> roads) throws IllegalArgumentException{
        int MAX_ROADS = 4;
        if(roads==null || roads.size()!= MAX_ROADS){
            throw new IllegalArgumentException("Not Enough Roads");
        }
        int PARALLEL_ROADS = 2;
        roadMap = new HashMap<>(PARALLEL_ROADS);
        List<Road> roadMapList;
//        Builds a hash map with group of roads in each bucket that can be turned to green at a time
        for(Road road:roads){
//            Make North and South bound roads start with Green Light
            if(road.getDirection().equalsIgnoreCase(Constants.NORTH) || road.getDirection().equalsIgnoreCase(Constants.SOUTH)){
                roadMapList = roadMap.get(1)==null? new ArrayList<>(PARALLEL_ROADS): roadMap.get(1);
                road.setLightState(new GreenLightState(Constants.GREEN_MAX_TIME));
                roadMapList.add(road);
                roadMap.put(1, roadMapList);
            }
//            Make East and West bound roads start with Red Light
            if(road.getDirection().equalsIgnoreCase(Constants.EAST) || road.getDirection().equalsIgnoreCase(Constants.WEST)){
                roadMapList = roadMap.get(2)==null? new ArrayList<>(PARALLEL_ROADS): roadMap.get(2);
                road.setLightState(new RedLightState(Constants.SIGNAL_RESET));
                roadMapList.add(road);
                roadMap.put(2, roadMapList);
            }
        }
    }

    /**
     * Changes signal in the intersection in a sequence
     */
    @Override
    public void changeSignal(){
//        If the timer reaches the Green Light limit then change the signal to next one
        if(timer == Constants.GREEN_MAX_TIME) {
            roadMap.get(currentRoadMap).forEach(Road::changeSignal);
        }
//        If the timer reaches the Red light limit after Green Light then change the current road list
        if(timer == (Constants.GREEN_MAX_TIME + Constants.RED_MAX_TIME)) {
           currentRoadMap = currentRoadMap == 1? 2: 1;
//           Change signal of newly selected road list
           roadMap.get(currentRoadMap).forEach(Road::changeSignal);
           timer = Constants.SIGNAL_RESET;
        }
//        By default move the cars in intersection. Internally it depends on the traffic light
        timer++;
        roadMap.forEach((key,value) ->
            value.forEach(Road::moveCars));
    }

    /**
     * Returns the status of the signal. Combined status of all roads that are passing through this intersection
     * @return String representing current status (number of cars in each road) of this intersection
     */
    @Override
    public String reportStatus(){
       StringBuilder sb = new StringBuilder();
       for(Integer key:roadMap.keySet()){

           for(Road road:roadMap.get(key)){
               sb.append(road.reportStatus());
           }
       }
       sb.deleteCharAt(sb.length()-2);
       return sb.toString();
    }

    /**
     * Initializes and starts the signal process
     */

    @Override
    public void startSignal(){
        try {
            int i = 0;
            while (i < Constants.MAX_REPEATS) {
                changeSignal();
                System.out.println(i + ": " + reportStatus());
                i++;
                Thread.sleep(Constants.THREAD_SLEEP_TIME);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
