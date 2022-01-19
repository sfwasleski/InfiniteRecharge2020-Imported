/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootFar extends CommandBase {
  /**
   * Creates a new ShootFar.
   */

  boolean wasWait = false;

  public ShootFar() {
    addRequirements(Robot.indexer);
    addRequirements(Robot.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.intake.extendIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    
    if(!wasWait && Robot.shooter.isReady()){
      Robot.intake.extendIntake();
      Robot.indexer.set(.5);
      Robot.intake.setRoller(.5);
      wasWait= true;
    }
    else if(Robot.shooter.isReady()){
      Robot.intake.extendIntake();
      Robot.indexer.set(.5);
      Robot.intake.setRoller(.5);
    }
    else if(!Robot.shooter.isReady()){
      Robot.intake.extendIntake();
      Robot.indexer.set(-.3);
      Robot.intake.setRoller(.5);
    }
    else
    {
      Robot.intake.extendIntake();
      Robot.indexer.stop();
      Robot.intake.setRoller(.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.indexer.stop();
    Robot.intake.retractIntake();
    Robot.intake.setRoller(0);
    wasWait = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
