
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import static frc.robot.Constants;

public class DriveTrain extends PIDSubsystem
{
  WPI_TalonSRX kLeftMotor1;
  WPI_TalonSRX kLeftMotor2;
  WPI_TalonSRX kRightMotor1;
  WPI_TalonSRX kRightMotor2;
  public DifferentialDrive m_Drive;
  private double m_MotorSens = -0.8f;
  
  public DriveTrain()
  {
    super("Turn", 1.0, 0.0, 0.0);
    kLeftMotor1 = new WPI_TalonSRX(kLeftMotor1Port);
    kLeftMotor2 = new WPI_TalonSRX(kLeftMotor2Port);
    kRightMotor1 = new WPI_TalonSRX(kRightMotor1Port);
    kRightMotor2 = new WPI_TalonSRX(kRightMotor2Port);
    
    // setPercentTolerance(5.0);
  }
  
  @Override
  public void initDefaultCommand()
  {
      SpeedControllerGroup m_leftMotorGroup = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
      SpeedControllerGroup m_rightMotorGroup = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);
      
      m_Drive = new DifferentialDrive(m_leftMotorGroup, m_rightMotorGroup);

      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
      setDefaultCommand(new Drive());
   }
   
  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }
}
