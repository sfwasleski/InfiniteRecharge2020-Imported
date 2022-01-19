/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package com.frcteam1939.infiniterecharge2020.robot.commands.controlpanelmanipulator;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnToColor extends CommandBase {
  String desiredColor;
  boolean isColorRed;
  boolean done;

  public TurnToColor() {
    addRequirements(Robot.controlPanelManipulator);
  }

  @Override
  public void initialize() {
    while (Robot.controlPanelManipulator.getColor() != "Red"){
      Robot.controlPanelManipulator.set(0.3);
    }
    isColorRed = true;
  }

  @Override
  public void execute() {
    desiredColor = Robot.controlPanelManipulator.colorFromFMS(); // Input from FMS
    //Robot.controlPanelManipulator.resetEncoder();
    if (isColorRed){
      if (desiredColor == "Blue"){
        while (Robot.controlPanelManipulator.getRotations() < 0.21){
          Robot.controlPanelManipulator.set(0.2);
          }
          done = true;
        }

      if (desiredColor == "Yellow"){
        while (Robot.controlPanelManipulator.getRotations() < 0.09){
          Robot.controlPanelManipulator.set(0.2);
        }
        done = true;
      }

      if (desiredColor == "Green"){
        while (Robot.controlPanelManipulator.getRotations() < 0.35){
          Robot.controlPanelManipulator.set(0.2);
        }
        done = true;
      }
      }  
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
   return done;

  }
}
*/
