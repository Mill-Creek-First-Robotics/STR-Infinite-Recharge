package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.util.Color;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class WheelSensors extends SubsystemBase
{
  SpeedController wheelTurner = new WPI_TalonSRX(Constants.MOTOR_TURNER);
  final I2C.Port i2cPort = I2C.Port.kOnboard;
  final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  final ColorMatch colorMatcher = new ColorMatch();

  //colors on color wheel(probably should set confidence to semi-low)
  private final Color yellow = colorMatcher.makeColor(1, 2, 3);
  private final Color green = colorMatcher.makeColor(1, 2, 3);
  private final Color blue = colorMatcher.makeColor(1, 2, 3);
  private final Color red = colorMatcher.makeColor(1, 2, 3);

  public WheelSensors()
  {
    colorMatcher.addColorMatch(yellow);
    colorMatcher.addColorMatch(red);
    colorMatcher.addColorMatch(blue);
    colorMatcher.addColorMatch(green);

    //God help us all
    colorMatcher.setConfidenceThreshold(.5);
  }
  /** startTurning
   * starts turning the wheel based on the speed its given in the command
   * @param speed
   */
  public void startTurning(final double speed)
  {
    wheelTurner.set(speed);
  }

  public void stopTurning() {
    wheelTurner.stopMotor();
  }

  /**autoTurn
   * A method to rotating the color wheel 1 full rotation and, in theory,
   * ending on the color it started on.
   * 
   * "Future attempts to utilize game elements may be implemented, but don't count on it."
   * -Spencer
   */
  public void autoTurn()
  {

    Color currentColor = colorSensor.getColor();
    //utilizing while loop to make sure it makes a full rotation
    //don't worry, there will be a failsafe in case it doesn't sense a color change
    int colorChange = 0;
    //TODO: You can increase the speed here depending on how good the color sensor reads color changes for added efficency.
    wheelTurner.set(.25);
    
    while(colorChange < 9)
    {
      ColorMatchResult match = colorMatcher.matchClosestColor(colorSensor.getColor());
      //checks if the current color that is being sensed checks out with our stored 
      if(match != colorMatcher.matchClosestColor(currentColor))
      {
        colorChange++;
        currentColor = colorSensor.getColor();        
      }

    }
    wheelTurner.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
