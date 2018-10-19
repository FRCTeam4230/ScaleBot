package org.usfirst.frc4230.ScaleBot.commands;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class correctAngle extends Command {
	double _angle;
    public correctAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	_angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrainL1.set(ControlMode.Velocity, -70 * RobotMap.gyro.getAngle());
    	RobotMap.driveTrainR1.set(ControlMode.Velocity, 70 * RobotMap.gyro.getAngle());
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
