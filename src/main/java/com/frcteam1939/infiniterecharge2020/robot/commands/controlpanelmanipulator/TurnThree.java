/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package com.frcteam1939.infiniterecharge2020.robot.commands.controlpanelmanipulator;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnThree extends CommandBase {

  double currentPos;
  
  public TurnThree() {
    addRequirements(Robot.controlPanelManipulator);

  }

  @Override
  public void initialize() {
    currentPos = Robot.controlPanelManipulator.getRotations();
  }

  @Override
  public void execute() {
    Robot.controlPanelManipulator.set(0.5);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.controlPanelManipulator.stop();
  }

  @Override
  public boolean isFinished() {
    return (Robot.controlPanelManipulator.getRotations() > currentPos+600);
  }
}
*/