/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot;

import com.frcteam1939.infiniterecharge2020.robot.commands.drivetrain.ControllerMode;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.FeedIndexer;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.Index;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.ShootClose;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.ShootFar3;
import com.frcteam1939.infiniterecharge2020.robot.commands.indexer.ShootMid;
import com.frcteam1939.infiniterecharge2020.robot.commands.intake.DeployIntake;
import com.frcteam1939.infiniterecharge2020.robot.commands.intake.DeployIntakeReverse;
import com.frcteam1939.infiniterecharge2020.robot.commands.intake.IntakeIn;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.FrontTrenchShooterSetup;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.HoodDown;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.InitiationLineShooterSetup;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.LongShooterSetup;
import com.frcteam1939.infiniterecharge2020.robot.commands.shooter.MidLongShooterSetup;
import com.frcteam1939.infiniterecharge2020.util.Gamepad;
import com.frcteam1939.infiniterecharge2020.util.XboxController2;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class OI {
  public final Joystick left;
  public final Joystick right;
  public final XboxController xboxController;
  public final Gamepad gamepad;
  public final JoystickButton deployIntake;
  public final JoystickButton index;
  public final JoystickButton shooterClose;
  public final JoystickButton shooterMid;
  public final JoystickButton shooterMidFar;
  public final JoystickButton shooterFar;
  public final JoystickButton shoot;
  public final JoystickButton intakeReverse;
  public final JoystickButton climberUp;
  public final JoystickButton climberDown;
  public final JoystickButton extendBrake;
  public final JoystickButton intake;
  public final JoystickButton hoodDown;
  public final JoystickButton stopIndexer;
  public final JoystickButton turnThree;
  public final JoystickButton controllerMode;




  //public final Gamepad gamepad = new Gamepad(2);

  public OI() {
    left  = new Joystick(1);
    right = new Joystick(0);
    xboxController = new XboxController(2);
    gamepad = new Gamepad(3);

    
    climberUp = new JoystickButton(left, 3);
    climberDown = new JoystickButton(left, 2);
    extendBrake = new JoystickButton(left, 5);
    controllerMode = new JoystickButton(right, 2);

    deployIntake = new JoystickButton(gamepad, 8);
    shooterClose = new JoystickButton(gamepad, 4);//y
    shooterMid = new JoystickButton(gamepad, 3);//b
    shooterMidFar = new JoystickButton(gamepad, 2);//a
    shooterFar = new JoystickButton(gamepad, 1);//x
    shoot = new JoystickButton(gamepad, 6);
    intakeReverse = new JoystickButton(gamepad, 9);
    intake = new JoystickButton(gamepad, 7);
    index = new JoystickButton(gamepad, 5);
    hoodDown = new JoystickButton(gamepad, 10);
    stopIndexer = new JoystickButton(gamepad, 11);
    turnThree = new JoystickButton(gamepad, 11);

    /*
    deployIntake = new JoystickButton(xboxController, XboxController2.X_BUTTON);
    shooterClose = new JoystickButton(xboxController, XboxController2.Y_BUTTON);
    shooterMid = new JoystickButton(xboxController, XboxController2.B_BUTTON);
    shooterFar = new JoystickButton(xboxController, XboxController2.A_BUTTON);
    shoot = new JoystickButton(xboxController, XboxController2.RIGHT_BUTTON);
    intakeReverse = new JoystickButton(xboxController, XboxController2.BACK_BUTTON);
    intake = new JoystickButton(xboxController, XboxController2.LEFT_TRIGGER);
    index = new JoystickButton(xboxController, XboxController2.LEFT_BUTTON);
    hoodDown = new JoystickButton(xboxController, XboxController2.START_BUTTON);
    stopIndexer = new JoystickButton(xboxController, XboxController2.LEFT_JOYSTICK_BUTTON);
    turnThree = new JoystickButton(xboxController, XboxController2.LEFT_JOYSTICK_BUTTON);
    */

    //controllerMode.whileHeld(new ControllerMode());
    //public final Trigger leftTrigger = new Trigger();
    //public final Trigger rightTrigger = new Trigger();

    hoodDown.whenPressed(new HoodDown());
    //stopIndexer.toggleWhenActive(command, interruptible)
    //fstopIndexer.cancelWhenPressed(new Index());
    shoot.whileHeld(new FeedIndexer());
    /*shoot.whileHeld(new ConditionalCommand(
      new ShootClose(),
        new ConditionalCommand(new ShootMid(),
          new ConditionalCommand(new ShootFar3(),
              new DoNothing(), 
              ()->Robot.shooter.far), 
        ()->Robot.shooter.mid),
      () -> Robot.shooter.close));*/

    //shoot.whenPressed(new ConditionalCommand(new ShootClose(), new ShootFar3(), )

    shooterClose.whileHeld(new InitiationLineShooterSetup());
    shooterMid.whileHeld(new FrontTrenchShooterSetup());
    shooterMidFar.whileHeld(new MidLongShooterSetup());
    shooterFar.whileHeld(new LongShooterSetup());

    //intakeReverse.whileHeld(new shoot)
    //intakeReverse.whenPressed(new DeployIntake());
    //intakeReverse.whenReleased(new IntakeIn());
    index.toggleWhenActive(new Index());
    //deployIntake.whenPressed(new DeployIntake());
    //deployIntake.whenReleased(new IntakeIn());
    deployIntake.toggleWhenActive(new DeployIntake());
    //*****index.toggleWhenActive(new Index());
    //index.whenPressed(new Index());
    //intake.whenPressed(new DeployIntake());
    intake.whenReleased(new IntakeIn());
  
    //deployIntake.whenReleased(new IntakeIn());  

    //climberUp.whileHeld(new MoveClimber(1));
    //climberDown.whileHeld(new MoveClimberDown());
    //extendBrake.whileHeld(new ExtendBrake());
    //turnThree.whenPressed(new TurnThree());


  







    //deployIntake = new JoystickButton(xboxController, XboxController2.getLeftTriggerButton();

    
  }
}