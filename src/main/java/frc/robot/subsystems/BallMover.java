package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallMover extends SubsystemBase {

    public enum RollerSpeedModeTypes {
        Slow, Fast, Reverse
    }

    // All motors declared

    private WPI_TalonSRX rollers = new WPI_TalonSRX(Constants.MOTOR_ROLLERS);

    private Solenoid ballHolder;

    private double[] rollerSpeedModes = { 0.4, 0.8, -0.2 };
    private int currentRollerSpeedMode;

    public BallMover() {
        ballHolder = new Solenoid(Constants.SOLENOID_STOPPER);
        lowerBallHolder(); // Should default to being up.
    }

    public double getCurrentRollerSpeed() {
        return rollerSpeedModes[currentRollerSpeedMode];
    }

    public int getCurrentRollerSpeedMode() {
        return currentRollerSpeedMode;
    }

    public void setCurrentRollerSpeedMode(int currentRollerSpeedMode) {
        // Loops the roller speed modes if the value is higher than 3
        this.currentRollerSpeedMode = currentRollerSpeedMode % (rollerSpeedModes.length + 1);
    }

    private boolean isBeltOn = false;

    // Uses speed modes
    public void startRollers() {
        rollers.set(getCurrentRollerSpeed());
        isBeltOn = !(isBeltOn);
    }

    public void startRollers(double speed) {
        rollers.set(-speed);
        isBeltOn = !(isBeltOn);
    }

    public void stopRollers() {
        rollers.stopMotor();
        isBeltOn = !(isBeltOn);
    }

    public void toggleRollers(double speed) {
        if (!isBeltOn) {
            startRollers(speed);
        } else {
            stopRollers();
        }
    }

    // Uses speed modes
    public void toggleRollers() {
        if (!isBeltOn) {
            startRollers();
        } else {
            stopRollers();
        }
    }

    public void toggleBallHolder() {
        if (!(ballHolder.get())) {
            raiseBallHolder();
        } else {
            lowerBallHolder();
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
