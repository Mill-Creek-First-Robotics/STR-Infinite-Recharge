package frc.robot.commands;

import frc.robot.subsystems.WheelSensors;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class TurnToColor extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private WheelSensors m_colorSensor;
  private double m_speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnToColor(WheelSensors subsystem) {

    m_colorSensor = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_colorSensor.startTurning(m_speed);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
