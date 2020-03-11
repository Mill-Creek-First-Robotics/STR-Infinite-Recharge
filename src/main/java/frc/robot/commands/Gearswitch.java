package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Gearswitch extends CommandBase
{
    private final DriveTrain m_driveTrain;

    public Gearswitch(DriveTrain subsystem)
    {
        m_driveTrain = subsystem;

        addRequirements(m_driveTrain);
    }

    @Override
    public void initialize()
    {
        m_driveTrain.gearSwitch();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

}
