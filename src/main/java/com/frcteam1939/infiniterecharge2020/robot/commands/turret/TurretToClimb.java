/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.turret;

import com.frcteam1939.infiniterecharge2020.robot.Robot;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TurretToClimb extends SequentialCommandGroup {

  public TurretToClimb() {
    if (Robot.turret.getPosition() < -0.1){
      addCommands(new TurretClockwiseToClimber());
    }
    else if (Robot.turret.getPosition() > 0.1){
      addCommands(new TurretCounterclockwiseToClimber());
    }
    else {
      this.cancel();
    }
  }
}
