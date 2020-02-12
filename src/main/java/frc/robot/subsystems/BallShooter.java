package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallShooter extends SubsystemBase {

    // All motors declared
    // TODO: probably should rename these
    private WPI_TalonSRX succer = new WPI_TalonSRX(Constants.MOTOR_INTAKE);

    private WPI_TalonSRX spitLeft = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_LEFT);
    private WPI_TalonSRX spitRight = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_RIGHT);

    private WPI_TalonSRX beltFeed = new WPI_TalonSRX(Constants.MOTOR_CONVEYOR);

    private boolean isSuccOn = false;

    public BallShooter() {

    }

    /**
     * Method that turns on shooter motors, shooting the ball
     */
    public void pew() {
        // dunno which way these should go so test them later
        spitLeft.set(1);
        spitRight.set(-1);
    }

    public void stopPew() {
        spitLeft.stopMotor();
        spitRight.stopMotor();
    }

    public void succ() {
        if (!(isSuccOn)) {
            succer.setInverted(false);
            succer.set(0.1);

            // sets boolean to true
            isSuccOn = !(isSuccOn);
        } else {
            succer.stopMotor();

            // sets boolean to false
            isSuccOn = !(isSuccOn);
        }
    }

    private boolean isBeltOn = false;

    public void beltfeed(double sped) {
        if (!isBeltOn) {
            beltFeed.setInverted(false);
            beltFeed.set(-sped);

            isBeltOn = !(isBeltOn);
        } else {
            beltFeed.stopMotor();

            isBeltOn = !(isBeltOn);
        }
    }

    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
