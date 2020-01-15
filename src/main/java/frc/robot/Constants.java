/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 /*NOTE 4 L8R
 motors are listed from front to back

 left side: 12 13
 right side: 3 2
 */
public final class Constants {
  
  public static final int LEFT_FRONT_MOTOR = 0;
  public static final int LEFT_BACK_MOTOR = 1;
  public static final int RIGHT_FRONT_MOTOR = 2;
  public static final int RIGHT_BACK_MOTOR = 3;

  public static final int[] kLeftEncoderPorts = new int[]{0, 1};
  public static final int[] kRightEncoderPorts = new int[]{2, 3};
  public static final boolean kLeftEncoderReversed = false;
  public static final boolean kRightEncoderReversed = true;

  public static final int kEncoderCPR = 1024;
  public static final double kWheelDiameterInches = 6;
  public static final double kEncoderDistancePerPulse =
        // Assumes the encoders are directly mounted on the wheel shafts
      (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;

  public static final boolean kGyroReversed = false;

  public static final double kStabilizationP = 1;
  public static final double kStabilizationI = 0.5;
  public static final double kStabilizationD = 0;

  public static final double kTurnP = 1;
  public static final double kTurnI = 0;
  public static final double kTurnD = 0;

  public static final double kMaxTurnRateDegPerS = 100;
  public static final double kMaxTurnAccelerationDegPerSSquared = 300;

  public static final double kTurnToleranceDeg = 5;
  public static final double kTurnRateToleranceDegPerS = 10; // degrees per second
  
  //ports for joysticks
  public static final int LEFT_CONTROLLER = 0;
  public static final int RIGHT_CONTROLLER = 1;
}
