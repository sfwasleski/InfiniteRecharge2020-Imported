/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIndexerUntilCurrent extends CommandBase {

  public RunIndexerUntilCurrent() {
    addRequirements(Robot.indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.indexer.setHorizontal(Robot.indexer.INDEXER_HORIONTAL_SPEED);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
  }

  @Override
  public boolean isFinished() {
    return Robot.indexer.getHorzCurrentDraw() > Robot.indexer.BALL_CURRENT;
  }
}
