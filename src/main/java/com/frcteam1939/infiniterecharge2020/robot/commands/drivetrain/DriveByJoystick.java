/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.commands.drivetrain;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.util.Gamepad;
import com.frcteam1939.infiniterecharge2020.util.XboxController2;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveByJoystick extends CommandBase {

  private static double DEAD_BAND = 0.1;
  private static double ROTATE_DEAD_BAND = 0.15;
  double move;
  double strafe;
  double rotate;
  double moveLeft;
  double moveRight;
  double strafe2;
  boolean turbo;
  boolean turbo2;
  boolean toggle;
  boolean sidewinderToggle;
  boolean sidewinderDrive;

  public DriveByJoystick() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

	if(!Robot.drivetrain.getControllerDriveMode()){
		move = Robot.oi.left.getY();
		rotate = Robot.oi.right.getX();
		strafe = 0;//Robot.oi.left.getX();

		turbo = Robot.oi.left.getRawButton(1) || Robot.oi.right.getRawButton(1);
	} else if(Robot.drivetrain.getControllerDriveMode()){

		/*
		moveLeft = Robot.oi.gamepad.
		moveRight = Robot.oi.gamepad.getRawAxis(8);
		move = moveLeft - moveRight;
		

		rotate = Robot.oi.gamepad.getLeftX();
		strafe = Robot.oi.gamepad.getRightX();

		turbo = Robot.oi.gamepad.rightButton.get();
		turbo2 = Robot.oi.gamepad.leftButton.get();
		*/

		moveLeft = Robot.oi.xboxController.getRawAxis(XboxController2.LEFT_TRIGGER);
		moveRight = Robot.oi.xboxController.getRawAxis(XboxController2.RIGHT_TRIGGER);
		move = moveLeft - moveRight;

		rotate = Robot.oi.xboxController.getRawAxis(XboxController2.LEFT_X);
		strafe = Robot.oi.xboxController.getRawAxis(XboxController2.RIGHT_X);

		turbo = Robot.oi.xboxController.getRawButton(XboxController2.RIGHT_BUTTON);
		turbo2 = Robot.oi.xboxController.getRawButton(XboxController2.LEFT_BUTTON);

		strafe2 = Robot.oi.right.getY();

	}

	if (Math.abs(move) < DEAD_BAND) {
		move = 0;
	} else {
		if (turbo) {
			move = map(move, 0, 0.75);
		} else if(turbo2){
			move = map(move, 0, 1.0);
		} else{
			move = map(move, 0, 0.5);
		}
	}
	if (Math.abs(rotate) < ROTATE_DEAD_BAND) {
		rotate = 0;
	} else {
		if (turbo) {
			rotate = map(rotate, 0, 0.6);
		} else if(turbo2) {
			move = map(move, 0, 0.6);
		} else {
			rotate = map(rotate, 0, 0.3);
		}
	}
	if (Math.abs(strafe) < 0.5) {
		Robot.drivetrain.sidewinderUp();
		strafe = 0;
	} else {
		Robot.drivetrain.sidewinderDown();
		if (turbo) {
			strafe = map(strafe, 0.5, 1.0, 0.3, 1.0); 
		} else {
			strafe = map(strafe, 0.5, 1.0, 0.3, 0.7);
		}
	}
	/*
	if (Math.abs(strafe2) < 0.5) {
		Robot.drivetrain.sidewinderUp();
	} else {
		Robot.drivetrain.sidewinderDown();
	} */
	
	/*
	if (Math.abs(strafe2) > 0.5) {
		Robot.drivetrain.sidewinderDown();
	}
	*/
	/*
	if (Math.abs(strafe2) < 0.5) {
		Robot.drivetrain.sidewinderUp();
	} else {
		Robot.drivetrain.sidewinderDown();
	} */
	


	Robot.drivetrain.drive(move, rotate, strafe);
	
	/*
	boolean slowDown = Robot.oi.left.getRawButton(1) || Robot.oi.right.getRawButton(1);
	boolean shooter = Robot.oi.right.getRawButton(8) || Robot.oi.right.getRawButton(9);

    if (Math.abs(move) < DEAD_BAND) {
			move = 0;
		} else {
			if (slowDown) {
				move = map(move, 0, 0.5);
			} else {
				move = map(move, 0, 1.0);
			}
		}

		if (Math.abs(rotate) < ROTATE_DEAD_BAND) {
			rotate = 0;
		} else {
			if (slowDown) {
				rotate = map(rotate, 0, 0.3);
			} else {
				rotate = map(rotate, 0, 0.45);
			}
		}

		if (Math.abs(strafe) < 0.3) {
			//Robot.drivetrain.sidewinderUp();
			strafe = 0;
		} else {
			//Robot.drivetrain.sidewinderDown();
			if (slowDown) {
				strafe = map(strafe, 0.5, 1.0, 0.3, 1.0);
			} else {
				strafe = map(strafe, 0.5, 1.0, 0.3, 0.7);
			}
		}

		Robot.drivetrain.drive(move, rotate, strafe);
		*/
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
  
	private static double map(double x, double out_min, double out_max) {
		return map(x, DEAD_BAND, 1.0, out_min, out_max);
	}

	private static double map(double x, double in_min, double in_max, double out_min, double out_max) {
		boolean negative = x < 0;
		double newValue = (Math.abs(x) - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
		if (negative) {
			return -newValue;
		} else {
			return newValue;
		}
	}
}
