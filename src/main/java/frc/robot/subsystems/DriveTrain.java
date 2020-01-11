
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class DriveTrain extends PIDSubsystem
{
  WPI_TalonSRX leftFrontTalon;
  WPI_TalonSRX leftBackTalon;
  WPI_TalonSRX rightFrontTalon;
  WPI_TalonSRX rightBackTalon;
  public DifferentialDrive m_Drive;
  
  public DriveTrain()
  {
    super("Turn", 1.0, 0.0, 0.0);
  }

  @Override
  public void periodic()
  {
    // This method will be called once per scheduler run
  }
}
