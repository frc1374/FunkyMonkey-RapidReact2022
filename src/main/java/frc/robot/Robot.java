// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.auto.AutoDriveCommand;
import frc.robot.commands.auto.AutoSequence;
import frc.robot.commands.ClimberCommandMove;
import frc.robot.commands.ConveyorBeltCommandReverse;
import frc.robot.commands.ConveyorBeltCommandToggle;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommandToggle;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ConveyorBeltSubsystem;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  // private final Timer m_timer = new Timer();
  public static OI OI = new OI();

  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static DriveCommand DriveCommand = new DriveCommand();
  CommandScheduler commandScheduler = CommandScheduler.getInstance();

  // public static ConveyorBeltSubsystem ConveyorBelt = new ConveyorBeltSubsystem();
  // public static ConveyorBeltCommandForward ConveyorBeltForward = new ConveyorBeltCommandForward(ConveyorBelt);
  // public static ConveyorBeltCommandStop ConveyorBeltStop = new ConveyorBeltCommandStop(ConveyorBelt);


  public static IntakeSubsystem Intake = new IntakeSubsystem();
  public static IntakeCommandToggle IntakeCmd = new IntakeCommandToggle(Intake);

  public static ClimberSubsystem climber = new ClimberSubsystem();
  public static ClimberCommandMove ClimberCommand = new ClimberCommandMove(climber);

  public static ConveyorBeltSubsystem conveyor = new ConveyorBeltSubsystem();
  public static ConveyorBeltCommandReverse conveyorforward = new ConveyorBeltCommandReverse(conveyor);
  public static ConveyorBeltCommandToggle conveyorback = new ConveyorBeltCommandToggle(conveyor);
  //public static EmergencyClimberStop EmergencyClimberStop = new EmergencyClimberStop(climber);
  // public static ElevatorSubsystem ElevatorSubsystem = new ElevatorSubsystem();
  // public static ElevatorCommandExtend ElevatorCommand = new ElevatorCommandExtend();
  //private static Compressor compressor = new Compressor(9, PneumaticsModuleType.CTREPCM);


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Drive", "AutoDrive");
    m_chooser.addOption("DriveShoot", "AutoDriveandShoot");
    
    SmartDashboard.putData("Auto choices", m_chooser);

    CameraServer.startAutomaticCapture();
    //compressor.enableDigital();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {

    //String m_autoSelected = m_chooser.getSelected();
    commandScheduler.schedule(new AutoSequence());
    
    /**
    
    switch (m_autoSelected) {
      case "Auto Drive":
        commandScheduler.schedule(new AutoSequence());

        break;

      case "Auto Drive and Shoot":
        commandScheduler.schedule(new AutoSequence());

        break;
        
      default:
        commandScheduler.schedule(new AutoSequence());
    }
    */
    
    //System.out.println("Auto selected: " + m_autoSelected);


    //commandScheduler.schedule(new AutoSequence());
    /*
    System.out.println("Auto selected: " + m_autoSelected);
    switch (m_autoSelected) {
      case kCustomAuto:
        
        commandScheduler.schedule(new AutoSequence());
        break;

      case kDefaultAuto:

        commandScheduler.schedule(new AutoSequence());
        break;
    }

    */

    //commandScheduler.schedule(new AutoSequence());

    /*
    switch (m_autoSelected){
      
      case kCustomAuto:
        commandScheduler.schedule(new AutoSequence());

    }
    */
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    //System.out.println("Auto selected: " + m_autoSelected);

    //AutoDriveForward.();
    
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    //AutoCommand.start();
    //commandScheduler.schedule(new AutoSequence());

    /*
    switch (m_autoSelected) {
      case "Auto Drive":
        commandScheduler.schedule(new AutoSequence());

        break;

      case "Auto Drive and Shoot":
        commandScheduler.schedule(new AutoSequence());

        break;
        
      default:
        commandScheduler.schedule(new AutoSequence());
    }
    */
    commandScheduler.run();

    /*
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
      **/
    }
  

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    commandScheduler.run();
    DriveCommand.schedule();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}