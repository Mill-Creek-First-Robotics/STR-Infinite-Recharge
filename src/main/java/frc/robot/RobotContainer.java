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
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoForward;
import frc.robot.commands.BallHolderToggle;
import frc.robot.commands.ColorWheelStartTurning;
import frc.robot.commands.ExtendHanger;
import frc.robot.commands.Gearswitch;
import frc.robot.commands.RetractHanger;
import frc.robot.commands.SetIntakeSpeedMode;
import frc.robot.commands.StartIntake;
import frc.robot.commands.StopHanger;
import frc.robot.commands.StopIntake;
import frc.robot.commands.ToggleBallHolder;
import frc.robot.commands.TurnToColor;
import frc.robot.subsystems.BallMover;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hanger;
import frc.robot.subsystems.WheelSensors;

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
        private BallMover m_ballMover;
        private WheelSensors m_wheelSensor;
        // The driver's controller
        Joystick m_leftJoystick = new Joystick(Constants.LEFT_CONTROLLER);
        private Hanger m_hanger;
        static Joystick m_rightJoystick = new Joystick(Constants.RIGHT_CONTROLLER);

        /**
         * The container for the robot. Contains subsystems, OI devices, and commands.
         */
        public RobotContainer() {
                m_robotDrive = Robot.m_driveTrain;
                m_ballMover = Robot.m_ballMover;
                m_wheelSensor = Robot.m_wheelSensor;
                m_hanger = Robot.m_hanger;
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

                new JoystickButton(m_rightJoystick, 1).whenPressed(new StartIntake(m_ballMover, m_rightJoystick))
                                .whenReleased(new StopIntake(m_ballMover));
                new JoystickButton(m_rightJoystick, 11)
                                .whenPressed(new SetIntakeSpeedMode(m_ballMover, BallMover.RollerSpeedModeTypes.Slow));
                new JoystickButton(m_rightJoystick, 9)
                                .whenPressed(new SetIntakeSpeedMode(m_ballMover, BallMover.RollerSpeedModeTypes.Fast));
                new JoystickButton(m_rightJoystick, 7).whenPressed(
                                new SetIntakeSpeedMode(m_ballMover, BallMover.RollerSpeedModeTypes.Reverse));
                new JoystickButton(m_rightJoystick, 6).whenPressed(new ToggleBallHolder(m_ballMover).withTimeout(0.1));
                // Evan Hutchinson: I'd like this to engage when GetBalls stops running and
                // disengage when GetBalls starts running
                new JoystickButton(m_rightJoystick, 2).whenPressed(new Gearswitch(m_robotDrive).withTimeout(0.1));
                new JoystickButton(m_rightJoystick, 4)
                                .whenPressed(new ColorWheelStartTurning(m_wheelSensor, 0.4).withTimeout(0.5));

                new JoystickButton(m_rightJoystick, 3).whenPressed(new BallHolderToggle(m_ballMover).withTimeout(0.5));
                new JoystickButton(m_leftJoystick, 2).whenPressed(new TurnToColor(m_wheelSensor).withTimeout(0.5));
                new JoystickButton(m_leftJoystick, 11).whenPressed(new ExtendHanger(m_hanger).withTimeout(0.5))
                                .whenReleased(new StopHanger(m_hanger).withTimeout(0.5));
                new JoystickButton(m_leftJoystick, 12).whenPressed(new RetractHanger(m_hanger).withTimeout(0.5))
                                .whenReleased(new StopHanger(m_hanger).withTimeout(0.5));
                new JoystickButton(m_leftJoystick, 9).whenReleased(new StopHanger(m_hanger).withTimeout(0.5));

                // new JoystickButton(m_leftJoystick, 8).whenPressed(new
                // StopTurning(m_wheelSensor).withTimeout(0.5));

        }

        /**
         * Use this to pass the autonomous command to the main {@link Robot} class.
         *
         * @return the command to run in autonomous
         */
        public Command getAutonomousCommand() {
                // no auto
                return new AutoForward(m_robotDrive).withTimeout(2.0);
        }
}
