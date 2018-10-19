package org.usfirst.frc4230.ScaleBot.commands;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	double _speedL;
	double _speedR;
	double _angle;

    public Turn(double angle, double speedL, double speedR) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	_speedL = speedL;
    	_speedR = speedR;
    	_angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrainL1.set(ControlMode.Velocity, _speedL);
    	RobotMap.driveTrainR1.set(ControlMode.Velocity, _speedR);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(RobotMap.gyro.getAngle() - _angle) < 3.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.driveTrainL1.set(ControlMode.Velocity, 0.0);
    	RobotMap.driveTrainR1.set(ControlMode.Velocity, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
