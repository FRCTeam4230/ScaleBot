package org.usfirst.frc4230.ScaleBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleOnlyL extends CommandGroup {

    public RightScaleOnlyL() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new DriveFwd(3000.0, 105000.0, 0.0));
    	addParallel(new Intake(-0.5, 10.0));
    	addSequential(new Turn(-70.0, -3000.0, 3000.0));
    	addParallel(new Lift(-0.8, 15000, true));
    	addSequential(new DriveFwd(3000, 94000.0, -80.0));
    	addSequential(new Turn(-20.0, 3000.0, -3000.0));
    	addSequential(new Lift(-0.9, 25000, false));
    	addSequential(new Lift(-0.7, 50000, true));
    	addSequential(new DriveFwd(1000, 7000.0, 0.0));
    	addSequential(new Intake(0.25, 1.0));
    	addSequential(new DriveFwd(-3000, 5000.0, 0.0));
    	addSequential(new Lift(0.8, 35000, true));
    }
}
