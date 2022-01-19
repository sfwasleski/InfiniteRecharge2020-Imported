/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootMid extends CommandBase {
  /**
   * Creates a new ShootMid.
   */
  boolean wasWait = false;
  public ShootMid() {
    addRequirements(Robot.indexer);
    addRequirements(Robot.intake);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!wasWait){
      Robot.intake.extendIntake();
      Robot.indexer.setVertical(.5);
      Robot.indexer.setHorizontal(.3);
      Robot.intake.setRoller(.5);
      wasWait= true;
    }
    else{
      Robot.intake.extendIntake();
      Robot.indexer.setVertical(.5);
      Robot.indexer.setHorizontal(.3);
      Robot.intake.setRoller(.5);
    }
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
    Robot.intake.setRoller(0);
    Robot.intake.retractIntake();


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
