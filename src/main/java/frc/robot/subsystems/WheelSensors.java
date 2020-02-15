package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class WheelSensors extends SubsystemBase {

  public WheelSensors() {
    // i2c port
    final I2C.Port i2cPort = I2C.Port.kOnboard;

    // declares color sensor
    final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
    final ColorMatch colorMatcher = new ColorMatch();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
