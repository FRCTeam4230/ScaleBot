package org.team4230.ScaleBot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import org.team4230.ScaleBot.RobotMap;
import org.team4230.ScaleBot.commands.DriveTeleop;

import java.util.Map;


public class DriveTrain extends Subsystem {

    private DifferentialDrive drive;
    // Multiplier control for the speed/turn input mappings
    private int iMult;
    private double multMap[] = {0.75, 0.55};
    private NetworkTableEntry confSpd;
    private NetworkTableEntry confRot;

    public DriveTrain() {
        ShuffleboardTab tab = Shuffleboard.getTab("SmartDashboard");
        confSpd = tab.add("Speed Multiplier", 0.75)
                .withWidget(BuiltInWidgets.kNumberSlider)
                .withProperties(Map.of("min", -1, "max", 1))
                .getEntry();
        confRot = tab.add("Rotation Multiplier", 0.75)
                .withWidget(BuiltInWidgets.kNumberSlider)
                .withProperties(Map.of("min", -1, "max", 1))
                .getEntry();

        WPI_TalonSRX l1 = new WPI_TalonSRX(RobotMap.driveTrainL1);
        WPI_TalonSRX l2 = new WPI_TalonSRX(RobotMap.driveTrainL2);
        WPI_TalonSRX r1 = new WPI_TalonSRX(RobotMap.driveTrainR1);
        WPI_TalonSRX r2 = new WPI_TalonSRX(RobotMap.driveTrainR2);
        WPI_TalonSRX[] motors = {l1, l2, r1, r2};
        // the default talon speedcontroller .set() implementations uses the "percentOutput" controlmode
        // subclass it and change it if you want to use something like hardware PID
        SpeedControllerGroup left = new SpeedControllerGroup(l1, l2);
        SpeedControllerGroup right = new SpeedControllerGroup(r1, r2);
        for(WPI_TalonSRX  motor : motors) {
            motor.configOpenloopRamp(1);
        }
        drive = new DifferentialDrive(left, right);
        iMult = 0;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTeleop());
    }

    public void drive(double speed, double rotation) {
        double spd = confSpd.getDouble(0.75);
        double rot = confRot.getDouble(0.75);
        drive.arcadeDrive(speed*spd, rotation*rot, true);
    }

    public void shiftSpeedSet() {
        iMult = (iMult + 1) % 2;
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
}
