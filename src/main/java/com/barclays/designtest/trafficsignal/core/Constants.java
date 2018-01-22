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

/**
 * Created for BarclayCardsUS
 * User       : Jagadeesh Lakkasani (ljagadeesh@live.com)
 * Date       : 01/21/18
 * Class Name : com.barclays.designtest.trafficsignal.core.Constants
 * Description : Constants interface to hold the frequently accessed values
 */
public interface Constants {
    String NORTH = "N";
    String SOUTH = "S";
    String EAST  = "E";
    String WEST = "W";
//    Time taken by the first car to move after green light - in seconds
    int GREEN_WAIT_TIME = 2;
//    Max time for Green light - in seconds
    int GREEN_MAX_TIME = 3;
//    Max time for Red light - in seconds
    int RED_MAX_TIME = 1;
    int SIGNAL_RESET = 0;
//    Number of times a traffic update needs to be repeated
    int MAX_REPEATS = 21;
//    Time delay between each traffic update - in milliseconds
    int THREAD_SLEEP_TIME = 1000;

}
