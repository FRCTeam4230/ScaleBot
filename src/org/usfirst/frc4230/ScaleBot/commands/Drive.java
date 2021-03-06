package org.usfirst.frc4230.ScaleBot.commands;


import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double xValue;
		double yValue;
		double targetSpeedL;
		double targetSpeedR;
		double maxSpeed = 2700;
		
		
		xValue = -1 * Robot.oi.driver.getRawAxis(4);
		//xValue = xValue * xValue * xValue;
		yValue = -1 * Robot.oi.driver.getRawAxis(1);
		//yValue = yValue * yValue * yValue;

		targetSpeedL = yValue - (xValue);
		targetSpeedR = yValue + (xValue);

		double max = targetSpeedL;
		if (Math.abs(targetSpeedR) > Math.abs(max)) {
			max = targetSpeedR;
		}
		
		if (Math.abs(max) > 1) {
			targetSpeedL /= Math.abs(max);
			targetSpeedR /= Math.abs(max);
		}
		
		if (Robot.oi.driver.getRawAxis(3) > 0.25) {
			maxSpeed = 1500;
		} else if (Robot.oi.driver.getRawButton(1)) { 
			maxSpeed = 4000;
		} else  {
			maxSpeed = 2700;
		}
		
		
		
		RobotMap.driveTrainL1.selectProfileSlot(0, 0);
		RobotMap.driveTrainR1.selectProfileSlot(0, 0);
		RobotMap.driveTrainL1.set(ControlMode.Velocity, targetSpeedL * maxSpeed);
		RobotMap.driveTrainR1.set(ControlMode.Velocity, targetSpeedR * maxSpeed);
		
		SmartDashboard.putNumber("Speed Right", targetSpeedR);
		SmartDashboard.putNumber("Speed Left", targetSpeedL);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
