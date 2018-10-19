package org.usfirst.frc4230.ScaleBot.commands;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {
		double _speed;
    	double _time;
    	double _startTime;
    public Intake(double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.intake);
    	_speed = speed;
    	_time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	_startTime = Timer.getFPGATimestamp();
    	RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, _speed);
    	RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, _speed);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Timer.getFPGATimestamp() - _startTime) > _time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, 0.0);
    	RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
