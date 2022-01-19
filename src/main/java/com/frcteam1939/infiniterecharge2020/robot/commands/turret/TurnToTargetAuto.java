/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToTargetAuto extends CommandBase {

  int pipeline;

  public TurnToTargetAuto(int pipeline) {
    this.pipeline = pipeline;
    addRequirements(Robot.turret);
  }

  @Override
  public void initialize() {
    Robot.limelightTurret.setPipeline(pipeline);
    Robot.turret.anglePID.reset();
    Robot.turret.anglePID.setSetpoint(0);
  }

  @Override
  public void execute() {

    double output = -Robot.turret.anglePID.calculate(Robot.limelightTurret.getHorizontalAngleError());
    
    Robot.turret.set(output);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.turret.set(0);
  }

  @Override
  public boolean isFinished() {
    return false; // Math.abs(Robot.oi.xboxController.getLeftStickX()) > 0.5 ;
  }
}
