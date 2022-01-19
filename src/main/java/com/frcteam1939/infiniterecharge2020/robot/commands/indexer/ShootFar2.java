/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootFar2 extends SequentialCommandGroup {
  /**
   * Creates a new ShootFar2.
   */
  public ShootFar2() {
    boolean ball1 = true;
    boolean ball2 = false;
    boolean ball3 = false;
    boolean ball4 = false;
    boolean ball5 = false;

    if(Robot.shooter.isReady()&& ball1){
      addCommands(new FeedPowerCellFar());
      ball1 = false;
      ball2 = true;
      ball3 = false;
      ball4 = false;
      ball5 = false;
    }
    if(Robot.shooter.isReady()&& ball2){
      addCommands(new FeedPowerCellFar());
      ball1 = false;
      ball2 = false;
      ball3 = true;
      ball4 = false;
      ball5 = false;
    }
    if(Robot.shooter.isReady()&& ball3){
      addCommands(new FeedPowerCellFar());
      ball1 = false;
      ball2 = false;
      ball3 = false;
      ball4 = true;
      ball5 = false;
    }
     if(Robot.shooter.isReady()&& ball4){
      addCommands(new FeedPowerCellFar());
      ball1 = false;
      ball2 = false;
      ball3 = false;
      ball4 = false;
      ball5 = true;
    }
    if(Robot.shooter.isReady()&& ball5){
      addCommands(new FeedPowerCellFar());
      ball1 = false;
      ball2 = false;
      ball3 = false;
      ball4 = false;
      ball5 = false;
   
    }
  }
}
