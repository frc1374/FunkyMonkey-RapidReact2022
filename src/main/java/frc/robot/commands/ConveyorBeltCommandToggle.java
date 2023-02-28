// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.ConveyorBeltSubsystem;

public class ConveyorBeltCommandToggle extends InstantCommand {
  private final ConveyorBeltSubsystem m_conveyor;
  private static int onOff = 0;
  private static final double speed = 1.0;

  /** Creates a new ConveyorBeltCommand. */
  public ConveyorBeltCommandToggle(ConveyorBeltSubsystem ConveyorBelt) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_conveyor = ConveyorBelt;
    //addRequirements(m_conveyor);
    //this.speed = 0;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (onOff == 0) {
      onOff = 1;
    } else if (onOff == 1){
      onOff = 0;
    } else if (ConveyorBeltSubsystem.getBeamBrakeSensor() == true){
      onOff = 0;
    }
    //m_intake.intakeInitialize(0.5);
    Robot.conveyor.setMotorSpeedMove(
      speed * onOff);
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
}