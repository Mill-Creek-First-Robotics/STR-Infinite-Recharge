package frc.robot.commands;

import frc.robot.subsystems.BallShooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class StopShooting extends CommandBase
{
    private final BallShooter m_ballShooter;

    public StopShooting(BallShooter subsystem)
    {
        m_ballShooter = subsystem;

        addRequirements(m_ballShooter);
    }

    @Override
    public void initialize()
    {
        m_ballShooter.stopPew();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

}
