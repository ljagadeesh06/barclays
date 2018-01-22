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
    int GREEN_WAIT_TIME = 2;
    int GREEN_MAX_TIME = 3;
    int RED_MAX_TIME = 1;
    int SIGNAL_RESET = 0;
    int MAX_REPEATS = 21;
    int THREAD_SLEEP_TIME = 1000;

}
