/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretToClimb2 extends CommandBase {
  /**
   * Creates a new TurretToClimb2.
   */

  private boolean done;

  public TurretToClimb2() {
    addRequirements(Robot.turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.turret.getPosition() > 0.1){
      Robot.turret.set(-.2);
      done = false;
    }
    else if (Robot.turret.getPosition() < -0.1){
      Robot.turret.set(.2);
      done = false;
    }
    else if (Robot.turret.isAtClimberPosition()){
      Robot.turret.set(0);
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.turret.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
