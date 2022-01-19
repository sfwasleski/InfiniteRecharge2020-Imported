/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.util.XboxController2;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretGamepadControl extends CommandBase {

    public TurretGamepadControl() {
      addRequirements(Robot.turret);
    }
  
    @Override
    public void initialize() {
    }
  
    @Override
    public void execute() {
      if(Robot.shooter.getIsShooting()){
        double value = Robot.oi.gamepad.getRawAxis(0)*.2;
        Robot.turret.set(value);
      }
      else{
        double value = Robot.oi.gamepad.getRawAxis(0);
        Robot.turret.set(value);
      }
      /*
      if(!Robot.drivetrain.getControllerDriveMode()){
        if(Robot.shooter.getIsShooting()){
          double value = Robot.oi.xboxController.getRawAxis(XboxController2.LEFT_X)*.2;
          Robot.turret.set(value);
        }
        else{
          double value = Robot.oi.xboxController.getRawAxis(XboxController2.LEFT_X);
          Robot.turret.set(value);
        }
      }
      */
    }
  
    @Override
    public void end(boolean interrupted) {
    }
  
    @Override
    public boolean isFinished() {
      return false;
    }
  }
  