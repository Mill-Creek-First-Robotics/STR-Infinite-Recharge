package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Hanger extends SubsystemBase {
    

  private final SpeedControllerGroup spools = new SpeedControllerGroup(
    new WPI_TalonSRX(Constants.MOTOR_SPOOLA), new WPI_TalonSRX(Constants.MOTOR_SPOOLB));
    SpeedController hook = new WPI_TalonSRX(Constants.MOTOR_TURNER);


  public Hanger() 
  {
    
  }


  public void extendHanger()
  {
    hook.set(Constants.kDrivetrainSpeedMultiplier);
    spools.set(-1 * Constants.kDrivetrainSpeedMultiplier);
  }

  public void stopHangerMotor()
  {
    hook.stopMotor();
    spools.stopMotor();
  }

  public void retractHanger()
  {
    hook.set(-1 * Constants.kDrivetrainSpeedMultiplier);
    spools.set(Constants.kDrivetrainSpeedMultiplier);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}