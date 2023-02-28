// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.ConveyorBeltSubsystem;

public class ConveyorBeltCommandReverse extends InstantCommand {
double speed;
private final ConveyorBeltSubsystem m_conveyor;

  /** Creates a new ConveyorBeltCommand. */
  public ConveyorBeltCommandReverse(ConveyorBeltSubsystem conveyor) {
    m_conveyor = conveyor;
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(conveyor);
    //this.speed = 1;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.conveyor.setMotorSpeedMove(-0.5);
  
  }

  /**
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Robot.ConveyorBeltSubsystem.setMotorSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  */
  //change
}