package org.usfirst.frc4230.ScaleBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleOnlyR extends CommandGroup {

    public RightScaleOnlyR() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	addSequential(new DriveFwd(3000.0, 4000.0, 0.0));
    	addSequential(new correctAngle(0.0));
    	addSequential(new Intake(-0.4, 0.5));
    	addParallel(new Lift(-0.7, 50000, true));
    	addParallel(new Intake(-0.4, 10.0));
    	addSequential(new DriveFwd(3000, 85000.0, 0.0));
    	addSequential(new Turn(-15.0, -2000.0, 2000.0)); //This could be the turn??
    	addSequential(new DriveFwd(1500.0, 9000.0, 20.0));
    	addSequential(new Intake(0.4, 1.0));
    	addSequential(new DriveFwd(-2000, 7000.0, 0.0));
    	addSequential(new Lift(0.7, 40000, true)); //was 50000
    	

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
