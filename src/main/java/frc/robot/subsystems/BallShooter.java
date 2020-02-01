package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class BallShooter extends SubsystemBase
{
    
    //All motors declared
    //TODO: probably should rename these
    private SpeedController succLeft = new WPI_TalonSRX(Constants.MOTOR_INTAKE_LEFT);
    private SpeedController succRight = new WPI_TalonSRX(Constants.MOTOR_INTAKE_RIGHT);

    private SpeedController spitLeft = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_LEFT);
    private SpeedController spitRight = new WPI_TalonSRX(Constants.MOTOR_LAUNCHER_RIGHT);
    
    private SpeedController beltFeed = new WPI_TalonSRX(Constants.MOTOR_CONVEYOR);
    public BallShooter() 
    {
        
    }

    /**
     * Method that turns on shooter motors, shooting the ball
     */
    public void pew()
    {
        //dunno which way these should go so test them later
        spitLeft.set(3);
        spitRight.set(-3);
    }

    public void succ()
    {
        //same with these
        succLeft.set(3);
        succRight.set(-3);
    }

    public void beltOn()
    {
        beltFeed.set(2);
    }

    public void initDefaultCommand()
    {

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
