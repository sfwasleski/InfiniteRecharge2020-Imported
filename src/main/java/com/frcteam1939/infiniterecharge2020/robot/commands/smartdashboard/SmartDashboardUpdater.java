/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.smartdashboard;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SmartDashboardUpdater extends CommandBase {

  public SmartDashboardUpdater() {
    addRequirements(Robot.smartDashboardSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    SmartDashboard.putBoolean("Far Shot", Robot.shooter.far);
    SmartDashboard.putBoolean("Mid Shot", Robot.shooter.mid);
    SmartDashboard.putBoolean("Close Shot", Robot.shooter.close);


    SmartDashboard.putNumber("Indexer Current", Robot.indexer.getHorzCurrentDraw());
    SmartDashboard.putNumber("Indexer Encoder", Robot.indexer.getPosition());

    SmartDashboard.putNumber("Turret Encoder", Robot.turret.getPosition());
    SmartDashboard.putBoolean("Hall Effect - Clockwise", Robot.turret.isAtClockwiseLimit());
    SmartDashboard.putBoolean("Hall Effect - Counter Clockwise", Robot.turret.isAtCounterClockwiseLimit());
    SmartDashboard.putBoolean("Hall Effect - Climber", Robot.turret.isAtClimberPosition());

    //SmartDashboard.putString("Color", Robot.controlPanelManipulator.getColor());

    SmartDashboard.putNumber("Intake Current", Robot.intake.getCurrent());

    SmartDashboard.putNumber("Speed Shooter", Robot.shooter.getSpeed());
    SmartDashboard.putBoolean("Shooter is Ready", Robot.shooter.isReady());

    SmartDashboard.putNumber("Left Encoder", Robot.drivetrain.getLeftPosition());
    SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.getRightPosition());

    //SmartDashboard.putNumber("Climber Position", Robot.climber.getPosition());

    SmartDashboard.putNumber("Limelight - Horizontal Angle Error", Robot.limelightTurret.getHorizontalAngleError());
    SmartDashboard.putNumber("Limelight - Distance", Robot.limelightTurret.getTargetDistance());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
