package org.team4230.lib.utils;

import edu.wpi.first.wpilibj.Spark;

public class LedBlinkin {

    private Spark controller;
    public static class colors {
        public static double HOT_PINK   = 0.57;
        public static double DARK_RED   = 0.59;
        public static double RED        = 0.61;
        public static double RED_ORANGE = 0.63;
        public static double ORANGE     = 0.65;
        public static double GOLD       = 0.67;
        public static double YELLOW     = 0.69;
        public static double LAWN_GREEN = 0.71;
        public static double LIME       = 0.73;
        public static double DARK_GREEN = 0.75;
    }

    public LedBlinkin(int port) {
        controller = new Spark(port);
    }

    public void setColor(double color) {
        controller.setSpeed(color);
    }
}
