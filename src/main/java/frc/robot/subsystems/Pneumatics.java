package frc.robot.subsystems;

import robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  //TODO: rename later
  Solenoid solo1;
  Solenoid solo2;
  Solenoid solo3;
  Solenoid solo4;

  public Pneumatics() {
      solo1 = new Solenoid(frc.robot.Constants.SOLENOID1);
      solo2 = new Solenoid(frc.robot.Constants.SOLENOID2);
      solo3 = new Solenoid(frc.robot.Constants.SOLENOID3);
      solo4 = new Solenoid(frc.robot.Constants.SOLENOID4);
  } 

  public void initDefaultCommand()
  {

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
