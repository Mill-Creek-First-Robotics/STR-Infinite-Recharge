package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallMover;

/**
 * An example command that uses an example subsystem.
 */
public class StartIntake extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final BallMover m_ballMover;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  Joystick input;

  public StartIntake(BallMover subsystem, Joystick joystick) {
    m_ballMover = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ballMover);
    input = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // TODO: Make speeds on presets
    m_ballMover.startRollers();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO: Test this on sim, may cause issues or fix dynamic roller speed setting
    return false;
  }
}
