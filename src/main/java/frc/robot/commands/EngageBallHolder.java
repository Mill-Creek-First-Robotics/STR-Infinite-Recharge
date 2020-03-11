package frc.robot.commands;

import frc.robot.subsystems.BallMover;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class EngageBallHolder extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final BallMover m_ballMover;

  public EngageBallHolder(BallMover subsystem) {
    m_ballMover = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballMover);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ballMover.raiseBallHolder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
