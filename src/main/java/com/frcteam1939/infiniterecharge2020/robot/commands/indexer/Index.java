/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Index extends SequentialCommandGroup {

  public Index() {

    addCommands(new PowerCellForward());
    addCommands(new SetIndexer(0));// Can Remove?
    addCommands(new PowerCellUp());
    addCommands(new WaitCommand(.6));
    addCommands(new SetIndexer(0));

    addCommands(new SecondPowerCellForward());
    addCommands(new SetIndexer(0));
    addCommands(new SecondPowerCellUp());
    addCommands(new WaitCommand(1));

    addCommands(new ThirdPowerCellForward());
    addCommands(new ThirdPowerCellUp());

    addCommands(new WaitCommand(.5));
    addCommands(new RunIndexerUntilDistance());
  
  }
}
