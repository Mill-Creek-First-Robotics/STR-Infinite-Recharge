package frc.robot.commands;

import frc.robot.subsystems.BallMover;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class GetBalls extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final BallMover m_ballShooter;
  private Double speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public GetBalls(BallMover subsystem, double spd) {
    m_ballShooter = subsystem;
    speed = spd;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ballShooter.succ(speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
