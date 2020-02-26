package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Hanger extends SubsystemBase {
    
  private SpeedController hook = new WPI_TalonSRX(Constants.MOTOR_HOOK);
  private SpeedController spool = new WPI_TalonSRX(Constants.MOTOR_SPOOL);


  public Hanger() 
  {
    
  }


  public void extendHanger()
  {
    hook.set(Constants.kDrivetrainSpeedMultiplier);
    spool.set(-1 * Constants.kDrivetrainSpeedMultiplier);
  }

  public void stopHangerMotor()
  {
    hook.stopMotor();
    spool.stopMotor();
  }

  public void retractHanger()
  {
    hook.set(-1 * Constants.kDrivetrainSpeedMultiplier);
    spool.set(Constants.kDrivetrainSpeedMultiplier);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}