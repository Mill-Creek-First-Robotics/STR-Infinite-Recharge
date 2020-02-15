package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class WheelSensors extends SubsystemBase {

  public WheelSensors() {
      //declares color sensor
      public ColorSensorV3 colorSensor = new ColorSensorV3(port);
      public ColorMatch colorMatcher = new ColorMatch();


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
