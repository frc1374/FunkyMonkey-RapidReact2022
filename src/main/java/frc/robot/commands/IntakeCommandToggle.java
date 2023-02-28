// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeCommandToggle extends InstantCommand {
  /** Creates a new IntakeCommand. */
  private final IntakeSubsystem m_intake;
  private static int onOff = 0;
  private static final double speed = 0.70;

  public IntakeCommandToggle(IntakeSubsystem intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intake = intake;
    //addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.Intake.intakeSpin(speed * onOff);

    if (onOff == 0) {
      onOff = 1;
      //Robot.Intake.intakeInitialize();
      // Robot.Intake.intakeInitialize();
      Robot.Intake.intakeRetract();
    } else if (onOff == 1) {
      onOff = 0;
      Robot.Intake.intakeInitialize();
    }
    //m_intake.intakeInitialize(0.5);
    //Robot.Intake.intakeSpin(-speed * onOff);
    // Robot.Intake.intakeToggle();
  }
}