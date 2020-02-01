/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Class for holding all constants for use throughout the robot code
 * 
 * Mainly hardware ports listed
 */

 /*NOTE 4 L8R
 motors are listed from front to back

 left side: 12 13
 right side: 3 2
 */
public final class Constants {

  //Pneumatic pistons
  public static final int SOLENOID1 = 4;
  public static final int SOLENOID2 = 5;
  public static final int SOLENOID3 = 6;
  public static final int SOLENOID4 = 7;
  public static final int SOLENOID54 = 8;

  //Motors corresponding to the drivetrain
  public static final int LEFT_FRONT_MOTOR = 0;
  public static final int LEFT_BACK_MOTOR = 1;
  public static final int RIGHT_FRONT_MOTOR = 2;
  public static final int RIGHT_BACK_MOTOR = 3;

  //Motors having to do with the shooting system
  public static final int MOTOR_LAUNCHER_LEFT = 4;
  public static final int MOTOR_LAUNCHER_RIGHT = 5;
  public static final int MOTOR_INTAKE_LEFT = 6;
  public static final int MOTOR_INTAKE_RIGHT = 7;
  public static final int MOTOR_CONVEYOR = 8;

  //encoder stuff - - Change names when needed
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
