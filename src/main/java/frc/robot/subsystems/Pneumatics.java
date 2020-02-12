package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  // TODO: rename later
  Solenoid gearBox1;
  Solenoid gearBox2;
  Solenoid colorWheelExtender;
  // Solenoid extra;

  public Pneumatics() {
    gearBox1 = new Solenoid(Constants.SOLENOID1);
    gearBox2 = new Solenoid(Constants.SOLENOID2);
    colorWheelExtender = new Solenoid(Constants.SOLENOID3);
    // solo4 = new Solenoid(Constants.SOLENOID4);
  }

  public void initDefaultCommand() {

  }

  public void gearSwitch() {
    if (!(gearBox1.get()) && !(gearBox2.get())) {
      gearBox1.set(true);
      gearBox2.set(true);
    } else {
      gearBox1.set(false);
      gearBox2.set(false);
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
