/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SecondPowerCellUp extends CommandBase {
  double currentPos;
  boolean tooFar;
  int excecuteCount = 0;
  public SecondPowerCellUp() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
   // Robot.indexer.zeroEncoder();
  }

  @Override
  public void execute() {

    if(excecuteCount ==0){
      Robot.indexer.zeroEncoder();
     // currentPos = Math.abs(Robot.indexer.getPosition());
      excecuteCount = 1;
    }
    Robot.indexer.setVertical(Robot.indexer.INDEXER_VERTICAL_SPEED);
    //Robot.indexer.setHorizontal(-.1);

    if((Robot.indexer.getPosition()>currentPos+1.35)||(Robot.indexer.getPosition()<currentPos+1.35)){
      tooFar = false;
    }

  }

  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
  }

  @Override
  public boolean isFinished() {
    return (Robot.indexer.getPosition())>1.264;
    //return (((!((Robot.indexer.getDistanceBottom() < Robot.indexer.DIST_ONE_BALL + 60) && (Robot.indexer.getDistanceBottom() > Robot.indexer.DIST_ONE_BALL - 60))) && ((Robot.indexer.getDistanceTop() < Robot.indexer.DIST_ONE_BALL + 60) && (Robot.indexer.getDistanceTop() > Robot.indexer.DIST_ONE_BALL - 60)))|| Robot.indexer.getPosition()>currentPos+1);
  }
  
}