package frc.robot.commands;

import frc.robot.subsystems.BallMover;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleBallHolder extends CommandBase {
    private final BallMover m_ballShooter;

    public ToggleBallHolder(BallMover subsystem) {
        m_ballShooter = subsystem;

        addRequirements(m_ballShooter);
    }

    @Override
    public void initialize() {
        m_ballShooter.toggleBallHolder();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
