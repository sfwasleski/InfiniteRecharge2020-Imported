/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.SetShooterClose;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.SetShooterCloseAuto;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class InitiationLineShooterSetupAuto extends ParallelDeadlineGroup {

  public InitiationLineShooterSetupAuto() {
    super(
        //new TurnToTargetTeleop(RobotMap.turretClosePipeline),
        new ShootCloseWait(),
        new SetShooterCloseAuto()
        //new DriveBackwardWait()
    );
  }
}
