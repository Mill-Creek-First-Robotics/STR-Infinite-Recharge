package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Hanger extends SubsystemBase {

  private SpeedController hook = new WPI_TalonSRX(Constants.MOTOR_HOOK);
  private SpeedController spool = new WPI_TalonSRX(Constants.MOTOR_SPOOL);

  public Hanger() {

  }

  public void extendHanger() {
    hook.set(Constants.kHangerSpeed);
    spool.set(-1 * Constants.kHangerSpeed);
  }

  public void stopHangerMotor() {
    hook.set(0);
    spool.set(0);
    hook.stopMotor();
    spool.stopMotor();
  }

  public void retractHanger() {
    hook.set(-1 * Constants.kHangerSpeed);
    spool.set(Constants.kHangerSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}