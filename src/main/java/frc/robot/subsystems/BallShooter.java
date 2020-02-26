package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
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

    private Solenoid ballHolder;

    public BallShooter() {
        ballHolder = new Solenoid(Constants.SOLENOID3);
        raiseBallHolder(); // Should default to being up.
    }

    /**
     * Method that turns on shooter motors, shooting the ball
     */
    public void pew() {
        lowerBallHolder();
        // dunno which way these should go so test them later
        spitLeft.set(1);
        spitRight.set(-1);
    }

    public void stopPew() {
        spitLeft.stopMotor();
        spitRight.stopMotor();
    }

    public void succ(double sped) {
        if (!(isSuccOn)) {

            succer.set(-sped);

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
            lowerBallHolder();

            beltFeed.set(-((sped + 1) / 2));

            isBeltOn = !(isBeltOn);
        } else {
            raiseBallHolder();
            beltFeed.stopMotor();

            isBeltOn = !(isBeltOn);
        }
    }

    public void toggleBallHolder() {
        if (!(ballHolder.get())) {
            ballHolder.set(true);
        } else {
            ballHolder.set(false);
        }
    }

    public void lowerBallHolder() {
        ballHolder.set(false);
    }

    public void raiseBallHolder() {
        ballHolder.set(true);
    }

    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
