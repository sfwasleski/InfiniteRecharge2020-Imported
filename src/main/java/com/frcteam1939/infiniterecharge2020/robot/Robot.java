/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot;

import com.frcteam1939.infiniterecharge2020.robot.commands.drivetrain.DriveByJoystick;
import com.frcteam1939.infiniterecharge2020.robot.commands.auto.ShootThreeTurnBackup;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.IndexerGamepadControl;
import com.frcteam1939.infiniterecharge2020.robot.commands.smartdashboard.SmartDashboardUpdater;
import com.frcteam1939.infiniterecharge2020.robot.commands.turret.TurretGamepadControl;
//import com.frcteam1939.infiniterecharge2020.robot.subsystems.Climber;
//import com.frcteam1939.infiniterecharge2020.robot.subsystems.ControlPanelManipulator;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.Drivetrain;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.Indexer;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.Intake;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.Shooter;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.Turret;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.Lights;
import com.frcteam1939.infiniterecharge2020.robot.subsystems.SmartDashboardSubsystem;
import com.frcteam1939.infiniterecharge2020.util.Limelight;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {

  //public static Climber climber;
  //public static ControlPanelManipulator controlPanelManipulator;
  public static Drivetrain drivetrain;
  public static Intake intake;
  public static Indexer indexer;
  public static Shooter shooter;
  public static Turret turret;
  public static Lights lights;
  public static OI oi;
  public static SmartDashboardSubsystem smartDashboardSubsystem;
  public static DriverStation driverStation;


  public static Limelight limelightTurret;
  public static Limelight limelightBase;

  public static boolean isAutoRunning;

  // private static final String kDefaultAuto = "Default";
  // private static final String kCustomAuto = "My Auto";
  // private String m_autoSelected;
  // private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private CommandBase autonomousCommand;

  static {
		try {
      driverStation = DriverStation.getInstance();
      //climber = new Climber();
      //controlPanelManipulator = new ControlPanelManipulator();
      drivetrain = new Drivetrain();
      intake = new Intake();
      indexer = new Indexer();
      shooter = new Shooter();
      turret = new Turret();
      oi = new OI();
      lights = new Lights();
      smartDashboardSubsystem = new SmartDashboardSubsystem();
      limelightTurret = new Limelight("limelight-turret");
      limelightBase = new Limelight("limelight-base");
		} catch (Exception e) {
			e.printStackTrace();
		}
  };
  
  @Override
  public void robotInit() {
    
    limelightTurret.setPipeline(RobotMap.turretOffPipeline);
    limelightBase.setPipeline(RobotMap.baseDriverPipeline);

    //Robot.climber.zeroEncoder();
    //Robot.climber.climberBrakeRetract();
    //Robot.climber.enableBrakeModeClimber();
    
    drivetrain.setDefaultCommand(new DriveByJoystick());
    indexer.setDefaultCommand(new IndexerGamepadControl());
    turret.setDefaultCommand(new TurretGamepadControl());
    smartDashboardSubsystem.setDefaultCommand(new SmartDashboardUpdater().perpetually());
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }



  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

    //Robot.climber.enableBrakeModeClimber();
    //Robot.controlPanelManipulator.enableBrakeMode();
    Robot.drivetrain.enableBrakeMode();
    Robot.indexer.enableBrakeMode();
    Robot.turret.enableBrakeMode();
    //Robot.lights.theaterCase();
    autonomousCommand = new ShootThreeTurnBackup();
    //autonomousCommand = new InitiationLineBackUp();

    autonomousCommand.schedule();
    isAutoRunning = true;
    // m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    // System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    /*switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }*/
  }

  @Override
  public void teleopInit() {
    isAutoRunning = false;
    
    limelightTurret.setPipeline(RobotMap.turretOffPipeline);
    limelightBase.setPipeline(RobotMap.baseDriverPipeline);
    
    //Robot.drivetrain.strafe(0.5);
    //Robot.climber.enableBrakeModeClimber();
    //Robot.controlPanelManipulator.enableBrakeMode();
    Robot.drivetrain.enableBrakeMode();
    Robot.indexer.enableBrakeMode();
    Robot.turret.enableBrakeMode();
    //Robot.climber.zeroEncoder();
    //Robot.climber.climberBrakeRetract();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void disabledInit() {
    //Robot.climber.enableBrakeModeClimber();
    Robot.intake.retractIntake();
    Robot.intake.setRoller(0);
    Robot.shooter.hoodDown();
    Robot.limelightTurret.setPipeline(RobotMap.turretOffPipeline);
    Robot.limelightBase.setPipeline(RobotMap.baseDriverPipeline);
    //Robot.climber.disableBrakeModeClimber();
    //Robot.controlPanelManipulator.disableBrakeMode();
    Robot.drivetrain.disableBrakeMode();
    Robot.indexer.disableBrakeMode();
    Robot.turret.disableBrakeMode();
  }
  @Override
  public void testPeriodic() {
  }

  //Returns true when the alliance is Red and return False when Alliance is Blue
  public static boolean getAllianceColor(){
    if(driverStation.getAlliance() == Alliance.Blue){
      return true;
    }
    else{
      return false;
    }
    
  }
}
