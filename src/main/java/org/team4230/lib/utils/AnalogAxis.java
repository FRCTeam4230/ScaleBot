package org.team4230.lib.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * Implementation of the trigger subclass for analog axis
 *
 * This class implements a simple threshold type trigger. The object is
 * set to be active once the axis is advanced beyond the threshold point.
 *
 * @author Max Hahn
 */
public class AnalogAxis extends Trigger {

    private GenericHID input;
    private int axis;
    private double threshold;

    /**
     * Constructs a AnalogAxis object set to a certain threshold.
     * @param input a controller input object
     * @param analogAxis a axis ID (see controller specific documentation for this)
     * @param threshold a threshold (between 0 and 1) for when the input
     *                  should be marked as active
     */
    public AnalogAxis(GenericHID input, int analogAxis, double threshold) {
        this.input = input;
        this.axis = analogAxis;
        this.threshold = threshold;
    }

    /**
     * Gets whether the threshold has been reached or not.
     *
     * @return whether the threhold has been reached or not
     */
    @Override
    public boolean get() {
        if (input.getRawAxis(axis) >= threshold) {
            return true;
        } else {
            return false;
        }
    }
}