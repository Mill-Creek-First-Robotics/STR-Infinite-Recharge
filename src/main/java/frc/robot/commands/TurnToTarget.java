package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.TurnToAngle;

/**
 * An auto command turns to a vision target
 */
public class TurnToTarget extends SequentialCommandGroup {

    private double targetAngleDegrees;
    private NetworkTable cvNetworkTable;
    private NetworkTableEntry targetAngle;

    public TurnToTarget(DriveTrain drive) {
        cvNetworkTable = Robot.m_netTable.getTable(Constants.cvNetworkTableName);
        targetAngle = cvNetworkTable.getEntry(Constants.cvNetworkTableTargetAngleName);
        addCommands(
                // Drive forward the specified distance
                new TurnToAngle(targetAngle.getDouble(0.0), drive));
    }

}