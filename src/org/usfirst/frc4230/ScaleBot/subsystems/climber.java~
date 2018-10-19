package org.usfirst.frc4230.ScaleBot.subsystems;

import org.usfirst.frc4230.ScaleBot.RobotMap;
import org.usfirst.frc4230.ScaleBot.commands.Climb;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final WPI_TalonSRX R = RobotMap.climberR;
	private final WPI_TalonSRX L = RobotMap.climberL;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Climb());
    }
}

