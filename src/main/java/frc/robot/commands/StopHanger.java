/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Hanger;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class StopHanger extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final Hanger m_hanger;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public StopHanger(Hanger subsystem) {
    m_hanger = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_hanger);


  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_hanger.stopHangerMotor();

  }



  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
