/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FeedIndexer extends CommandBase {

  public FeedIndexer() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    if(Robot.shooter.isReady()&& (Robot.shooter.isReadyLimelight())){
      Robot.indexer.set(Robot.indexer.INDEXER_SHOOT_SPEED);
      //Robot.intake.extendIntake();
    }
    else{
      Robot.indexer.stop();
    }
  }

  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
    //Robot.intake.retractIntake();

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
