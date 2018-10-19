package org.usfirst.frc4230.ScaleBot.subsystems;

import org.usfirst.frc4230.ScaleBot.RobotMap;
import org.usfirst.frc4230.ScaleBot.commands.Climb;
import org.usfirst.frc4230.ScaleBot.commands.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class driveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final WPI_TalonSRX R1 = RobotMap.driveTrainR1;
	private final WPI_TalonSRX R2 = RobotMap.driveTrainR2;
	private final WPI_TalonSRX L1 = RobotMap.driveTrainL1;
	private final WPI_TalonSRX L2 = RobotMap.driveTrainL2;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
}

