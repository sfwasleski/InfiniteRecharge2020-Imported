/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.shooter;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.util.XboxController2;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetShooterMid extends CommandBase {

  public SetShooterMid() {
    addRequirements(Robot.shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.shooter.close = false;
    Robot.shooter.mid = true;
    Robot.shooter.far = false;
    Robot.shooter.hoodMiddleLow();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double value = Robot.oi.xboxController.getRawAxis(XboxController2.LEFT_X);
    Robot.turret.set(value);
    double speedShooter = Robot.shooter.getSpeed();

    if (speedShooter < 11700){
      Robot.shooter.set(1);
      Robot.shooter.setReady(false);

    } 
    else if (speedShooter > 11700 && speedShooter < 12700){
      Robot.shooter.setReady(true);
      Robot.shooter.set(0.37);
    }
    else {
      Robot.shooter.setReady(false);
      Robot.shooter.set(0.29);
    }

      } 
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.shooter.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

