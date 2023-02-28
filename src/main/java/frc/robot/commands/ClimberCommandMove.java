// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberCommandMove extends InstantCommand {
  /** Creates a new ClimberCommand. */
  private final ClimberSubsystem m_climber;
  static boolean direction;

  public ClimberCommandMove(ClimberSubsystem climber) {
    m_climber = climber;
    // addRequirements(Robot.climber);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.climber.changeDirection();
    // System.out.println("Direction changed");
  }
}
