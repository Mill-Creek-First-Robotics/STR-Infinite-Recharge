package frc.robot.commands;

import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Gearswitch extends CommandBase {
    private final Pneumatics m_pneumatics;

    public Gearswitch(Pneumatics subsystem) {
        m_pneumatics = subsystem;

        addRequirements(m_pneumatics);
    }

    @Override
    public void initialize() {
        m_pneumatics.goToFastGear();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_pneumatics.goToSlowGear();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
