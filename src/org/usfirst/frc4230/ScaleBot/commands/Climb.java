package org.usfirst.frc4230.ScaleBot.commands;

import org.usfirst.frc4230.ScaleBot.Robot;
import org.usfirst.frc4230.ScaleBot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climb extends Command {
	boolean pressed;
	boolean limits = true;
	boolean set = true;

    public Climb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.climberR.set(ControlMode.PercentOutput, Robot.oi.operator.getRawAxis(5) * -1);
    	if (Robot.oi.operator.getRawButton(4)) {
    		if (!pressed) {
    			limits = !limits;
    		}
    		pressed = true;
    	} else {
    		pressed = false;
    	}
    	
    	if (limits) {
			if (!set) {
				RobotMap.climberR.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
						LimitSwitchNormal.NormallyClosed, 10);
				RobotMap.climberR.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
						LimitSwitchNormal.NormallyClosed, 10);
			}
			set = true;
		} else {
			if (set) {
				RobotMap.climberR.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
						LimitSwitchNormal.Disabled, 10);
				RobotMap.climberR.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,
						LimitSwitchNormal.Disabled, 10);
			}
			set = false;
		}
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
