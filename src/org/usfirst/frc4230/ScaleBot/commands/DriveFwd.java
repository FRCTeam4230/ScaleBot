package org.usfirst.frc4230.ScaleBot.commands;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveFwd extends Command {
	double _speed;
	double _distance;
	double _angle;
	final double TURN_ERROR = 38;

    public DriveFwd(double speed, double distance, double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	_speed = speed;
    	_distance = distance;
    	_angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrainL1.setSelectedSensorPosition(0, 0, 10);
		RobotMap.driveTrainR1.setSelectedSensorPosition(0, 0, 10);
		Timer.delay(0.1);
    	RobotMap.driveTrainL1.set(ControlMode.Velocity, _speed);
    	RobotMap.driveTrainR1.set(ControlMode.Velocity, _speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.driveTrainL1.set(ControlMode.Velocity, _speed - (RobotMap.gyro.getAngle()-_angle)*TURN_ERROR);
    	RobotMap.driveTrainR1.set(ControlMode.Velocity, _speed + (RobotMap.gyro.getAngle()-_angle)*TURN_ERROR);
    	SmartDashboard.putNumber("SpeedL",  _speed - (RobotMap.gyro.getAngle()-_angle)*TURN_ERROR);
    	SmartDashboard.putNumber("SpeedR",  _speed + (RobotMap.gyro.getAngle()-_angle)*TURN_ERROR);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(RobotMap.driveTrainL1.getSelectedSensorPosition(0))>_distance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.driveTrainL1.set(ControlMode.Velocity, 0.0);
    	RobotMap.driveTrainR1.set(ControlMode.Velocity, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
