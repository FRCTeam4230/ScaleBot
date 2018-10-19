package org.usfirst.frc4230.ScaleBot.commands;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lift extends Command {
	double _speed;
	double _distance;
	boolean _stop;
	boolean limit;

	public Lift(double speed, double distance, boolean stop) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.cubeLift);
		_speed = speed;
		_distance = distance;
		_stop = stop;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.cubeLiftSlider.setSelectedSensorPosition(0, 0, 10);
		RobotMap.cubeLiftSlider.set(ControlMode.PercentOutput, _speed);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	} 

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(RobotMap.cubeLiftSlider.getSelectedSensorPosition(0)) > _distance) {
			return true;
		} else if ((!RobotMap.LimitSwitchtop.get() && _speed < 0.0)
				|| (!RobotMap.LimitSwitchbottom.get() && _speed > 0.0)) {
			limit = true;
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		if (_stop || limit) {
			RobotMap.cubeLiftSlider.set(ControlMode.PercentOutput, 0.0);
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
