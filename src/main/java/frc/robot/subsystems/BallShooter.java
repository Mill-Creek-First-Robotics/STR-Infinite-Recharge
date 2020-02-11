package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallShooter extends SubsystemBase {

    // All motors declared
    // TODO: probably should rename these
    private SpeedController succer = new WPI_TalonSRX(Constants.MOTOR_INTAKE);

    private SpeedController spitLeft = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_LEFT);
    private SpeedController spitRight = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_RIGHT);

    private SpeedController beltFeed = new WPI_TalonSRX(Constants.MOTOR_CONVEYOR);

    private boolean isSuccOn = false;

    public BallShooter() {

    }

    /**
     * Method that turns on shooter motors, shooting the ball
     */
    public void pew() {
        // dunno which way these should go so test them later
        spitLeft.set(3);
        spitRight.set(-3);
    }

    public void stopPew() {
        spitLeft.stopMotor();
        spitRight.stopMotor();
    }

    public void succ() {
        if (!(isSuccOn)) {
            succer.set(3);

            // sets boolean to true
            isSuccOn = !(isSuccOn);
        } else {
            succer.stopMotor();

            // sets boolean to false
            isSuccOn = !(isSuccOn);
        }
    }

    public void beltfeed(double sped) {
        beltFeed.set(sped);
    }

    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
