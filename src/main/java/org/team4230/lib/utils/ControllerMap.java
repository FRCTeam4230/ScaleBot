package org.team4230.lib.utils;

/**
 * Maps Controller buttons to human readable names to prevent wrangling
 * "magic numbers". These mappings are valid for standard Xbox xinput
 * compatible controllers
 *
 * @author Max Hahn
 */
public class ControllerMap {
    /**
     * Contains mappings for "pressable" button IDs
     */
    public static class buttons {
        public static int Y = 4;
        public static int X = 3;
        public static int A = 1;
        public static int B = 2;
        public static int LS = 5;
        public static int RS = 6;
        public static int left = 7;
        public static int right = 8;
        public static int lStick = 9;
        public static int rStick = 10;
    }

    /**
     * contains mappings for anlog input axis IDs
     */
    public static class analog {
        public static int LX = 0;
        public static int LY = 1;
        public static int LT = 2;
        public static int RT = 3;
        public static int RX = 4;
        public static int RY = 5;
    }
}