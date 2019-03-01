package org.team4230.lib.sensor;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Class to read from a single MAxSonar HRLV series sensor
 * in analog, untriggered mode.
 * <p>
 * see <a href="https://www.maxbotix.com/tutorials1/031-using-multiple-ultrasonic-sensors.htm">
 *     this page</a> for more info on using multiple sensors
 */
public class MaxSonar implements SensorI{

    private AnalogInput port;

    public MaxSonar(int analogPort) {
        port = new AnalogInput(analogPort);
    }

    /**
     * Get the distance from the sensor in centimeters
     * <p>
     * See <a href="https://www.maxbotix.com/documents/HRLV-MaxSonar-EZ_Datasheet.pdf">Datasheet</a>
     * @return distance from the ultrasonic sensor in millimeters
     */
    @Override
    public double getValue() {
        return 0.0009770212*port.getVoltage() + 300;
    }
}
