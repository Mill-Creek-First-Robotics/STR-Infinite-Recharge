/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// THIS CLASS IS BASICALLY OI
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.Constants;
import frc.robot.commands.ColorWheelArm;
import frc.robot.commands.Gearswitch;
import frc.robot.commands.GetBalls;
import frc.robot.commands.ToggleBallHolder;
import frc.robot.commands.TurnToAngle;
import frc.robot.commands.TurnToAngleProfiled;
import frc.robot.commands.BeltToggle;
import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Pneumatics;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
        // The robot's subsystems
        private DriveTrain m_robotDrive;
        private BallShooter m_BallShooter;
        private Pneumatics m_Pneumatics;

        // The driver's controller
        Joystick m_leftJoystick = new Joystick(Constants.LEFT_CONTROLLER);
        static Joystick m_rightJoystick = new Joystick(Constants.RIGHT_CONTROLLER);

        /**
         * The container for the robot. Contains subsystems, OI devices, and commands.
         */
        public RobotContainer() {
                m_robotDrive = Robot.m_driveTrain;
                m_BallShooter = Robot.m_ballShooter;
                m_Pneumatics = Robot.m_pneumatics;
                // Configure the button bindings
                configureButtonBindings();

                // Configure default commands
                // Set the default drive command to split-stick arcade drive
                m_robotDrive.setDefaultCommand(
                                // A split-stick arcade command, with forward/backward controlled by the left
                                // hand, and turning controlled by the right.
                                new RunCommand(() -> m_robotDrive.arcadeDrive(
                                                Math.signum(-m_rightJoystick.getY()) * m_rightJoystick.getY()
                                                                * m_rightJoystick.getY(),
                                                Math.signum(m_rightJoystick.getZ()) * m_rightJoystick.getZ()
                                                                * m_rightJoystick.getZ()),
                                                m_robotDrive));

        }

        /**
         * Use this method to define your button->command mappings. Buttons can be
         * created by instantiating a {@link GenericHID} or one of its subclasses
         * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
         * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
         */
        private void configureButtonBindings() {
                // Drive at half speed when the 2 button is held
                new JoystickButton(m_rightJoystick, 2).whenPressed(() -> m_robotDrive.setMaxOutput(0.5))
                                .whenReleased(() -> m_robotDrive.setMaxOutput(1));

                // // Stabilize robot to drive straight with gyro when 2 button is held
                // new JoystickButton(m_rightJoystick, 2).whenHeld(new PIDCommand(
                // new PIDController(Constants.kStabilizationP, Constants.kStabilizationI,
                // Constants.kStabilizationD),
                // // Close the loop on the turn rate
                // m_robotDrive::getTurnRate,
                // // Setpoint is 0
                // 0,
                // // Pipe the output to the turning controls
                // output ->
                // m_robotDrive.arcadeDrive(m_rightJoystick.getY(GenericHID.Hand.kLeft),
                // output),
                // // Require the robot drive
                // m_robotDrive));

                // Turn to 90 degrees when the '3' button is pressed, with a 5 second timeout
                // new JoystickButton(m_rightJoystick, 5).whenPressed(new TurnToAngle(90,
                // m_robotDrive).withTimeout(5));

                // Turn to -90 degrees with a profile when the '4' button is pressed, with a 5
                // second timeout
                // new JoystickButton(m_rightJoystick, 6)
                // .whenPressed(new TurnToAngleProfiled(-90, m_robotDrive).withTimeout(5));

                new JoystickButton(m_rightJoystick, 3).whenPressed(new GetBalls(m_BallShooter).withTimeout(5));

                new JoystickButton(m_leftJoystick, 5)
                                .whenPressed(new BeltToggle(m_BallShooter, m_rightJoystick).withTimeout(0.1));
                new JoystickButton(m_leftJoystick, 6).whenPressed(new ToggleBallHolder(m_BallShooter).withTimeout(0.1));

                new JoystickButton(m_rightJoystick, 4).whenPressed(new Gearswitch(m_Pneumatics).withTimeout(0.1));
                new JoystickButton(m_leftJoystick, 10).whenPressed(new ColorWheelArm(m_Pneumatics).withTimeout(0.5));

        }

        /**
         * Use this to pass the autonomous command to the main {@link Robot} class.
         *
         * @return the command to run in autonomous
         */
        public Command getAutonomousCommand() {
                // no auto
                return new InstantCommand();
        }
}
