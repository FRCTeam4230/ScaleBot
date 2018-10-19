package org.usfirst.frc4230.ScaleBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class midSwitchL extends CommandGroup {

    public midSwitchL() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	addSequential(new DriveFwd(4000.0, 4000.0, 0.0));
    	addSequential(new Intake(-0.6, 1.0));
    	addParallel(new Intake(-0.3, 5.0));
    	addSequential(new Turn(-30.0, -2500.0, 2500.0));
    	addParallel(new Lift(-0.7, 21000, true));
    	addSequential(new DriveFwd(3000.0, 40000.0, -30.0));
    	addSequential(new Intake(-0.8, 0.5));
    	addSequential(new correctAngle(0.0));
    	addParallel(new Intake(0.3, 10.0));
    	addSequential(new DriveFwd(3000.0, 1500.0, 0.0));
    	addSequential(new Intake(0.4, 10.0));

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
