// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc4230.ScaleBot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

/**
 *
 */
public class liftCube extends Command {
	double liftSpeed = 0.0;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public liftCube() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.cubeLift);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		liftSpeed = Robot.oi.operator.getRawAxis(1);
		if (!RobotMap.LimitSwitchtop.get() && liftSpeed < 0.0) {
			liftSpeed = 0;
		} else if (!RobotMap.LimitSwitchbottom.get() && liftSpeed > 0.0) { 
			liftSpeed = 0;
		}
		RobotMap.cubeLiftSlider.set(ControlMode.PercentOutput, liftSpeed);
			
		SmartDashboard.putNumber("Lift Position", RobotMap.cubeLiftSlider.getSelectedSensorPosition(0));
		if (Robot.oi.driver.getRawAxis(2) > 0.7 || Robot.oi.driver.getRawButton(5)) {
			RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, 0.4);
			RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, 0.4);
		} else if (Robot.oi.operator.getRawButton(6)) {
			RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, -0.8);
			RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, -0.8);
		} else if (Robot.oi.operator.getRawAxis(3) > 0.7) {
			RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, -0.4);
			RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, -0.4);
		} else if (Robot.oi.driver.getRawButton(6)) {
			RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, -0.8);
			RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, -0.8);
		} else {
			RobotMap.cubeLiftIntakeL.set(ControlMode.PercentOutput, 0.0);
			RobotMap.cubeLiftIntakeR.set(ControlMode.PercentOutput, 0.0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}