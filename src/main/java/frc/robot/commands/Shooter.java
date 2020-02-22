package frc.robot.commands;

import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter extends CommandBase {
    private final BallShooter m_ballShooter;
    private final Pneumatics m_pneumatics;

    public Shooter(BallShooter bsSubsystem, Pneumatics pnSubsystem) {
        m_ballShooter = bsSubsystem;
        m_pneumatics = pnSubsystem;

        addRequirements(m_ballShooter);
        addRequirements(m_pneumatics);

    }

    @Override
    public void initialize() {
        m_ballShooter.pew();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
