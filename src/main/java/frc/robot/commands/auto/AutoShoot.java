// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
//import frc.robot.subsystems.ConveyorBeltSubsystem;

public class AutoShoot extends CommandBase {
  /** Creates a new AutoShoot. */
  long startTime;
  long endTime;

  public AutoShoot(long time) {
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(Robot.ConveyorBeltSubsystem);
    endTime = time;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    endTime = endTime + startTime;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.conveyor.setMotorSpeedMove(0.75);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.conveyor.setMotorSpeedMove(0.0);
    System.out.println("Shoot Command has ended");

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (System.currentTimeMillis() >= (startTime + endTime)) {
      return true;
    }
    
    return false;

  }
}
