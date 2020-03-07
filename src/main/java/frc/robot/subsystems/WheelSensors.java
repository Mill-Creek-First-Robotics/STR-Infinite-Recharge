package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.util.Color;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class WheelSensors extends SubsystemBase {
  SpeedController wheelTurner = new WPI_TalonSRX(Constants.MOTOR_TURNER);
  final I2C.Port i2cPort = I2C.Port.kOnboard;
  final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  final ColorMatch colorMatcher = new ColorMatch();

  // colors on color wheel(probably should set confidence to semi-low)
  private Color yellow;
  private Color green;
  private Color blue;
  private Color red;
  public boolean colorDetectDebug = true;

  public WheelSensors() {
    yellow = ColorMatch.makeColor(3392, 1232, 5833);
    green = ColorMatch.makeColor(674, 941, 2206);
    blue = ColorMatch.makeColor(434, 1260, 1355);
    red = ColorMatch.makeColor(2325, 577, 1570);
    colorMatcher.addColorMatch(yellow);
    colorMatcher.addColorMatch(red);
    colorMatcher.addColorMatch(blue);
    colorMatcher.addColorMatch(green);

    // God help us all
    colorMatcher.setConfidenceThreshold(.5);

    System.out.println("WheelSensors Constructor Successful!");
  }

  /**
   * startTurning starts turning the wheel based on the speed its given in the
   * command
   * 
   * @param speed
   */
  public void startTurning(double speed) {
    wheelTurner.set(speed);
  }

  public void stopTurning() {
    wheelTurner.stopMotor();
  }

  /**
   * A method to rotating the color wheel 1 full rotation and, in theory, ending
   * on the color it started on.
   * 
   * 
   */
  public void turnOnce() {

    Color currentColor = colorSensor.getColor();
    int colorChange = 0;
    // TODO: You can increase the speed here depending on how good the color sensor
    // reads color changes for added efficency.
    wheelTurner.set(.25);

    while (colorChange < 9) {
      ColorMatchResult match = colorMatcher.matchClosestColor(colorSensor.getColor());
      // checks if the current color that is being sensed checks out with our stored
      if (match != colorMatcher.matchClosestColor(currentColor)) {
        colorChange++;
        currentColor = colorSensor.getColor();
      }

    }
    wheelTurner.stopMotor();
  }

  /**
   * Takes game information and turns the wheel to a specific color
   */
  public void turnToCorrectColor() {

    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    if (gameData.length() != 0) {
      Color colorNeeded;

      switch (gameData.charAt(0)) {
      case 'B':
        colorNeeded = blue;
        break;
      case 'G':
        colorNeeded = green;
        break;
      case 'R':
        colorNeeded = red;
        break;
      case 'Y':
        colorNeeded = yellow;
        break;
      default:
        colorNeeded = null;
        break;
      }

      boolean onColor = false;
      while (!onColor) {
        wheelTurner.set(0.4);
        ColorMatchResult result = colorMatcher.matchClosestColor(colorSensor.getColor());

        if (result == colorMatcher.matchClosestColor(colorNeeded)) {
          wheelTurner.stopMotor();
          onColor = true;
        }
        System.out.print(colorSensor.getRed() + " " + colorSensor.getBlue() + " " + colorSensor.getGreen());
      }

    }
  }

  @Override
  public void periodic() {
    if (colorDetectDebug) {
      System.out.println(colorSensor.getRed() + " " + colorSensor.getBlue() + " " + colorSensor.getGreen());
    }
  }
}
