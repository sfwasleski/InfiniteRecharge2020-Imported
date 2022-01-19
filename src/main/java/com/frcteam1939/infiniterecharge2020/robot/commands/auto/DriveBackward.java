/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.auto;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveBackward extends CommandBase {

  public double initialTime;
  public double currentTime;

  public DriveBackward() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {
   initialTime = Timer.getFPGATimestamp();

    Robot.drivetrain.setPercentOutput(.3, .3);
  }

  @Override
  public void execute() {
    currentTime = Timer.getFPGATimestamp();
  }

  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return ((currentTime-initialTime)>.5);
  }
}
