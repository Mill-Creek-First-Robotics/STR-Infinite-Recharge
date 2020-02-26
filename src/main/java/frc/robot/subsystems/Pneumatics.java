package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  // TODO: rename later
  Solenoid gearBox;
  Solenoid colorWheelExtender;
  // Solenoid extra;

  public Pneumatics() {
    gearBox = new Solenoid(Constants.SOLENOID_GEARSWITCH);
    colorWheelExtender = new Solenoid(Constants.SOLENOID_ARM);
    // solo4 = new Solenoid(Constants.SOLENOID4);
  }

  public void initDefaultCommand() {

  }

  public void gearSwitch() {
    if (!(gearBox.get())) {
      gearBox.set(true);
    } else {
      gearBox.set(false);
    }
  }

  public void extendWheel() {
    if (!(colorWheelExtender.get())) {
      colorWheelExtender.set(true);
    } else {
      colorWheelExtender.set(false);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
