// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;
import java.util.HashMap;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /* Controllers */
  private final Joystick driver = new Joystick(0);


  /* Driver Buttons */
  private final JoystickButton intake = new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton shootButton = new JoystickButton(driver, XboxController.Button.kB.value);
  private final JoystickButton shooterUp = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
  private final JoystickButton shooterDown = new JoystickButton(driver, XboxController.Button.kRightBumper.value);




  public final Shooter m_Shooter;
  /* Subsystems */
  public final IntakeSubsystem s_IntakeSubsystem;
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() { 
    s_IntakeSubsystem = new IntakeSubsystem();
    m_Shooter = new Shooter();

    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* Driver Buttons */
    intake.onTrue(new InstantCommand(() -> s_IntakeSubsystem.intake(SmartDashboard.getNumber("Intake Speed", 0.60))));
    intake.onFalse(new InstantCommand(() -> s_IntakeSubsystem.intake(0.0)));
    shootButton.whileTrue(new InstantCommand(m_Shooter::Shoot));
    shootButton.onFalse(new InstantCommand(m_Shooter::StopShoot));
    shooterUp.onTrue(new InstantCommand(() -> m_Shooter.ShooterActuator(SmartDashboard.getNumber("Linear Actuator Speed", 0.3))));
    shooterDown.onTrue(new InstantCommand(() -> m_Shooter.ShooterActuator(-SmartDashboard.getNumber("Linear Actuator Speed", 0.3))));
    shooterUp.onFalse(new InstantCommand(m_Shooter::StopActuator));
    shooterDown.onFalse(new InstantCommand(m_Shooter::StopActuator));

  
  }

  /*
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
  