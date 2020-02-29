package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends SubsystemBase {

  // TODO: rename later
  Solenoid gearBox;
  Solenoid colorWheelExtender;
  // Solenoid extra;

  // TODO: Split Pneumatics to their separate subsystems, so no commands conflict.
  public Pneumatics() {
    gearBox = new Solenoid(Constants.SOLENOID_GEARSWITCH);
    colorWheelExtender = new Solenoid(Constants.SOLENOID_ARM);
    // solo4 = new Solenoid(Constants.SOLENOID4);
  }

  public void initDefaultCommand() {

  }

  public void goToFastGear() {
    gearBox.set(true);
  }

  public void goToSlowGear() {
    gearBox.set(false);
  }

  public void gearSwitch() {
    if (!(gearBox.get())) {
      goToFastGear();
    } else {
      goToSlowGear();
    }
  }

  public void wheelUp() {
    colorWheelExtender.set(true);
  }

  public void wheelDown() {
    colorWheelExtender.set(false);
  }

  public void extendWheel() {
    if (!(colorWheelExtender.get())) {
      wheelUp();
    } else {
      wheelDown();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
