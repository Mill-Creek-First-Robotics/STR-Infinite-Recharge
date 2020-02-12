package frc.robot.commands;

import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

/**
 * An example command that uses an example subsystem.
 */
public class ColorWheelArm extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Pneumatics m_pneumatics;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ColorWheelArm(Pneumatics subsystem) {
    m_pneumatics = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_pneumatics.extendWheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
