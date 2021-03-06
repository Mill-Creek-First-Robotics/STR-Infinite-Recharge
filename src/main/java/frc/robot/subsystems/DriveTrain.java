/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  // The motors on the left side of the drive.
  private final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(
      new WPI_TalonSRX(Constants.LEFT_FRONT_MOTOR), new WPI_TalonSRX(Constants.LEFT_BACK_MOTOR));

  // The motors on the right side of the drive.
  private final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(
      new WPI_TalonSRX(Constants.RIGHT_FRONT_MOTOR), new WPI_TalonSRX(Constants.RIGHT_BACK_MOTOR));

  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  private Solenoid gearBox = new Solenoid(Constants.SOLENOID_GEARSWITCH);

  // The robot's gyro/AHRS
  private AHRS m_gyro;

  // // The left-side drive encoder
  // private final Encoder m_leftEncoder =
  // new Encoder(Constants.kLeftEncoderPorts[0], Constants.kLeftEncoderPorts[1],
  // Constants.kLeftEncoderReversed);

  // // The right-side drive encoder
  // private final Encoder m_rightEncoder =
  // new Encoder(Constants.kRightEncoderPorts[0], Constants.kRightEncoderPorts[1],
  // Constants.kRightEncoderReversed);

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveTrain() {
    // Sets the distance per pulse for the encoders
    // Disable Encoders
    // m_leftEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);
    // m_rightEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);
    try {
      m_gyro = new AHRS(SPI.Port.kMXP);
    } catch (RuntimeException ex) {
      DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
    }
  }

  // @Override
  public void initDefaultCommand() {
    SpeedControllerGroup m_leftMotorGroup = new SpeedControllerGroup(m_leftMotors);
    SpeedControllerGroup m_rightMotorGroup = new SpeedControllerGroup(m_rightMotors);

    DifferentialDrive m_Drive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);

  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }

  /**
   * Tank drive setting for robot coltrols
   * 
   * @param left  input for left joystick
   * @param right input for right joystick
   * @param speed input for low/high speed
   */
  public void tankDrive(double left, double right, boolean speed) {
    m_drive.tankDrive(left * Constants.kDrivetrainSpeedMultiplier, right * Constants.kDrivetrainSpeedMultiplier, true);
  }

  public void gearSwitch() {
    if (!(gearBox.get())) {
      gearBox.set(true);
    } else {
      gearBox.set(false);
    }
  }
  // /**
  // * Resets the drive encoders to currently read a position of 0.
  // */
  // public void resetEncoders() {
  // // m_leftEncoder.reset();
  // // m_rightEncoder.reset();
  // }

  // /**
  // * Gets the average distance of the two encoders.
  // *
  // * @return the average of the two encoder readings
  // */
  // public double getAverageEncoderDistance() {
  // // return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
  // return -1;
  // }

  // /**
  // * Gets the left drive encoder.
  // *
  // * @return the left drive encoder
  // */
  // public Encoder getLeftEncoder() {
  // return m_leftEncoder;
  // }

  // /**
  // * Gets the right drive encoder.
  // *
  // * @return the right drive encoder
  // */
  // public Encoder getRightEncoder() {
  // return m_rightEncoder;
  // }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more
   * slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }

  /**
   * Zeroes the heading of the robot.
   */
  public void zeroHeading() {
    m_gyro.reset();
  }

  /**
   * Returns the heading of the robot.
   *
   * @return the robot's heading in degrees, from 180 to 180
   */
  public double getHeading() {
    return Math.IEEEremainder(m_gyro.getYaw(), 360) * (Constants.kGyroReversed ? -1.0 : 1.0);
  }

  /**
   * Returns the turn rate of the robot.
   *
   * @return The turn rate of the robot, in degrees per second
   */
  public double getTurnRate() {
    return m_gyro.getRate() * (Constants.kGyroReversed ? -1.0 : 1.0);
  }

  @Override
  public void periodic() {
    // double yaw = m_gyro.getYaw();
    // double roll = m_gyro.getRoll();
    // double pitch = m_gyro.getPitch();
  }
}
