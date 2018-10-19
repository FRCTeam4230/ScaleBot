package org.usfirst.frc4230.ScaleBot.subsystems;

import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final WPI_TalonSRX IntakeL = RobotMap.cubeLiftIntakeL;
	private final WPI_TalonSRX IntakeR = RobotMap.cubeLiftIntakeR;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

