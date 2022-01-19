/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ThirdPowerCellUp extends CommandBase {
  double encoderPos;
  int excecuteCount;
  public ThirdPowerCellUp() {
    addRequirements(Robot.indexer);
  }

  @Override
  public void initialize() {
    encoderPos = Robot.indexer.getPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(excecuteCount ==0){
      Robot.indexer.zeroEncoder();
     // currentPos = Math.abs(Robot.indexer.getPosition());
      excecuteCount = 1;
    }
    Robot.indexer.setVertical(Robot.indexer.INDEXER_VERTICAL_SPEED);
    //Robot.indexer.setHorizontal(-.1);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Robot.indexer.getPosition())>.25;
    //return ((Robot.indexer.getPosition() < encoderPos-.55) || (Robot.indexer.getPosition() < encoderPos-.55));
  }
}
