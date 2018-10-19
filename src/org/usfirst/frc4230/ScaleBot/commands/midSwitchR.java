package org.usfirst.frc4230.ScaleBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class midSwitchR extends CommandGroup {

    public midSwitchR() {
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
    	addSequential(new Intake(-0.6, 1.0));
    	addParallel(new Intake(-0.3, 5.0));
    	addSequential(new Turn(20.0, 2000.0, -2000.0));
    	addParallel(new Lift(-0.7, 18000, true));
    	addSequential(new DriveFwd(3000.0, 36000.0, 20.0));
    	addSequential(new Intake(0.4, 10.0));
    	
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
