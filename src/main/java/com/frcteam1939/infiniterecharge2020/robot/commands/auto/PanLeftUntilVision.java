/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.auto;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PanLeftUntilVision extends CommandBase {

  int pipeline;

  public PanLeftUntilVision(int pipeline) {
    this.pipeline = pipeline;
    addRequirements(Robot.turret);
  }

  @Override
  public void initialize() {
    Robot.limelightTurret.setPipeline(pipeline);
  }

  @Override
  public void execute() {
    Robot.turret.set(-0.5);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.turret.set(0);
  }

  @Override
  public boolean isFinished() {
    return Robot.limelightTurret.isTargetFound();
  }
}
