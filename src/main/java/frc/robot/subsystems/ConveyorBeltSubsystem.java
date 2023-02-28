// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DigitalInput;

public class ConveyorBeltSubsystem extends SubsystemBase {
  CANSparkMax motor;
  RelativeEncoder encoder;
  public static DigitalInput beambrakesensor;

  //double speedForward = 1.0;
  //double speedStop = 0.0;
  /** Creates a new ConveyorBeltSubsystem. */
  public ConveyorBeltSubsystem() {
    
    
    //need edit: 0
    motor = new CANSparkMax(RobotMap.ConveyorM, MotorType.kBrushless);
    beambrakesensor = new DigitalInput(RobotMap.beamBrake);
  

    //encoder = motor.getEncoder();
  }

  //input: desired speed for conveyor belt going forward
  public void setMotorSpeedMove(double speed) {
    motor.set(speed);
  }

  public static boolean getBeamBrakeSensor() {
    return beambrakesensor.get();
  }

  //public void setMotorSpeedStop(double)

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}