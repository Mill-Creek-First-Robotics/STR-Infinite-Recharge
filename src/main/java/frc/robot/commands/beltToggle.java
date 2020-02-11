package frc.robot.commands;

import frc.robot.subsystems.BallShooter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

/**
 * An example command that uses an example subsystem.
 */
public class beltToggle extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final BallShooter m_ballShooter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  Joystick input;

  public beltToggle(BallShooter subsystem, Joystick joystick) {
    m_ballShooter = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballShooter);
    input = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ballShooter.beltfeed(input.getThrottle());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
