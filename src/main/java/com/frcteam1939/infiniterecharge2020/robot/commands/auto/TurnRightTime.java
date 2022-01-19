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

public class TurnRightTime extends CommandBase {

  double time = 0;
  double initialTime;

  public TurnRightTime(double wait) {
    time = wait;
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {
    initialTime = Timer.getFPGATimestamp();
    System.out.println("initialized auto");
  }

  @Override
  public void execute() {
    System.out.println("Ran Drivetrain");
    Robot.drivetrain.setPercentOutput(.2, -.2);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp()>initialTime+time);
  }
}
