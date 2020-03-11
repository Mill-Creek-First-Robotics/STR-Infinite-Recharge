package frc.robot.commands;

import frc.robot.subsystems.BallMover;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class SetIntakeSpeedMode extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final BallMover m_ballMover;
  private final int chosenMode;

  public SetIntakeSpeedMode(BallMover subsystem, int chosenMode) {
    m_ballMover = subsystem;
    this.chosenMode = chosenMode;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballMover);

  }

  public SetIntakeSpeedMode(BallMover subsystem, BallMover.RollerSpeedModeTypes chosenMode) {
    m_ballMover = subsystem;
    this.chosenMode = chosenMode.ordinal();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballMover);

  }

  public SetIntakeSpeedMode(BallMover subsystem) {
    m_ballMover = subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballMover);
    this.chosenMode = m_ballMover.getCurrentRollerSpeedMode() + 1;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_ballMover.setCurrentRollerSpeedMode(chosenMode);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
