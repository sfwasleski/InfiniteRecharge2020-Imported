/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FeedPowerCellFar extends CommandBase {
  /**
   * Creates a new FeedPowerCellFar.
   */
  boolean wasWait = false;
  double currentPos;
  public FeedPowerCellFar() {
    addRequirements(Robot.indexer);
    addRequirements(Robot.indexer);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentPos = Robot.indexer.getPosition();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   // if(!wasWait){
    Robot.indexer.setVertical(.4);
   // Timer.delay(.5);
    Robot.indexer.setHorizontal(.4);
   // wasWait = true;
   // }
    /*else{
      Robot.indexer.setVertical(.4);
      Robot.indexer.setHorizontal(.3);
    }
*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.set(0);
    Robot.intake.retractIntake();
    Robot.intake.setRoller(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Robot.indexer.getPosition()>currentPos+1.5);
  }
}
