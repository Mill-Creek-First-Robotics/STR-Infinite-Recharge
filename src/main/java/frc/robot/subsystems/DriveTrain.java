
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem {
  WPI_TalonSRX leftFrontTalon;
  WPI_TalonSRX leftBackTalon;
  WPI_TalonSRX rightFrontTalon;
  WPI_TalonSRX rightBackTalon;

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
