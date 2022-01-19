/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ThirdPowerCellForward extends CommandBase {
  double currentPos;
  public ThirdPowerCellForward() {
    addRequirements(Robot.indexer);
  }
  

  @Override
  public void initialize() {
    currentPos = Robot.indexer.getPosition();
  }

  @Override
  public void execute() {
      Robot.indexer.setHorizontal(Robot.indexer.INDEXER_HORIONTAL_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
   // Robot.indexer.setBalls(1);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (((Robot.indexer.getDistanceBottom() < Robot.indexer.DIST_ONE_BALL + 60) && (Robot.indexer.getDistanceBottom() > Robot.indexer.DIST_ONE_BALL - 60))|| Robot.indexer.getPosition()>currentPos+1.35);
  }
}
