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

    /*
    This might look weird but hear me out...
    The Color class cannot be changed after it's been initialized, this poses a problem for sensing color change.
    My solution is to use an array list and add/remove Colors as they're being used to sense color changes.
    Is there a better solution? Probably, but this is the best solution I can come up with as of 2/18/20.
    */
    ArrayList<Color> change = new ArrayList<Color>();
    change.add(colorSensor.getColor());
    //utilizing while loop to make sure it makes a full rotation
    //don't worry, they'll be a failsafe in case it doesn't sense a color change
   
    int colorChange = 0;

    //TODO: You can increase the speed here depending on how good the color sensor reads color changes for added efficency.
    wheelTurner.set(.25);
    
    while(colorChange < 9)
    {
      ColorMatchResult match = colorMatcher.matchClosestColor(colorSensor.getColor());
      //checks if the current color that is being sensed checks out with our stored 
      if(match != colorMatcher.matchClosestColor(change.get(0)))
      {

        colorChange++;
        /*
          Now this is how these next two lines work:
          first the current color being sensed is being assigned to index 1 in the array list.
          second, the color at index 0 is being removed, thus moving the color from index 1 to index 0.
          This prepare us for the next time the loop runs
        */
        change.add(colorSensor.getColor());
        change.remove(0);
      }

    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
