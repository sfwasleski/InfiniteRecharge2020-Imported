/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.shooter;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.robot.commands.turret.TurnToTargetTeleop;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class InitiationLineShooterSetup extends ParallelCommandGroup {
  /**
   * Creates a new InitiationLineShooterSetup.
   */
  public InitiationLineShooterSetup() {
    // Add your commands in the super() call.  Add the deadline first.
    super(
        //new TurnToTargetTeleop(RobotMap.turretClosePipeline),
        new SetShooterClose()
    );
  }
}
