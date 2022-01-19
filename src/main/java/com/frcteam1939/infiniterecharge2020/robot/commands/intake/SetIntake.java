/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.intake;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SetIntake extends InstantCommand {
  double value;

  public SetIntake(double value) {
    addRequirements(Robot.intake);
    this.value = value;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.intake.setRoller(value);
  }
}
