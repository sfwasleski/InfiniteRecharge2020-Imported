/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class XboxController2 extends Joystick {
    
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON= 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;//3
    public static final int LEFT_BUTTON = 5;//4
    public static final int RIGHT_BUTTON = 6;
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    public static final int LEFT_JOYSTICK_BUTTON = 9;
    public static final int RIGHT_JOYSTICK_BUTTON = 10;
    
    public static final int LEFT_X = 0;
    public static final int LEFT_Y = 1;
    public static final int LEFT_TRIGGER = 2;
    public static final int RIGHT_TRIGGER = 3;
    public static final int RIGHT_X = 4;
    public static final int RIGHT_Y = 5;
    
    public XboxController2(int port) {
        super(port);
    }
    public final JoystickButton x = new JoystickButton(this, X_BUTTON);
	public final JoystickButton a = new JoystickButton(this, A_BUTTON);
	public final JoystickButton b = new JoystickButton(this, B_BUTTON);
	public final JoystickButton y = new JoystickButton(this, Y_BUTTON);
	public final JoystickButton leftButton = new JoystickButton(this, LEFT_BUTTON);
	public final JoystickButton rightButton = new JoystickButton(this, RIGHT_BUTTON);
	public final JoystickButton back = new JoystickButton(this, BACK_BUTTON);
	public final JoystickButton start = new JoystickButton(this, START_BUTTON);
	public final JoystickButton leftJoystick = new JoystickButton(this, LEFT_JOYSTICK_BUTTON);
    public final JoystickButton rightJoystick = new JoystickButton(this, RIGHT_JOYSTICK_BUTTON);
    
    public final Trigger leftTrigger = new Trigger(this::getLeftTriggerButton);
    public final Trigger rightTrigger = new Trigger(this::getRightTriggerButton);




    //public final Button trigger = new JoystickButton(() -> this.getRawAxis(2) > 0.5);

    
    /**
     * Read the value of the right joystick's X axis.
     * @return the value of the right joystick's X axis.
     */
    public double getRightStickX() {
        return getRawAxis(RIGHT_X);
    }

    /**
     * Read the value of the right joystick's Y axis.
     * @return the value of the right joystick's Y axis.
     */
    public double getRightStickY() {
        return getRawAxis(RIGHT_Y);
    }

    /**
     * Read the value of the left joystick's X axis.
     * @return the value of the left joystick's X axis.
     */
    public double getLeftStickX() {
        return getRawAxis(LEFT_X);
    }

    /**
     * Read the value of the left joystick's Y axis.
     * @return the value of the left joystick's Y axis.
     */
    public double getLeftStickY() {
        return getRawAxis(LEFT_Y);
    }
    
    /**
     * Read the value of the d-pad's X axis.
     * @return the value of the d-pad's X axis.
     */

    /**
     * Read the value of the d-pad's Y axis.
     * @return the value of the d-pad's Y axis.
     */
  

    /**
     * Read the state of the A button.
     * @return the state of the A button.
     */
    public boolean getAButton() {
        return getRawButton(A_BUTTON);
    }

    /**
     * Read the state of the B button.
     * @return the state of the B button.
     */
    public boolean getBButton() {
        return getRawButton(B_BUTTON);
    }

    /**
     * Read the state of the X button.
     * @return the state of the X button.
     */
    public boolean getXButton() {
        return getRawButton(X_BUTTON);
    }

    /**
     * Read the state of the Y button.
     * @return the state of the Y button.
     */
    public boolean getYButton() {
        return getRawButton(Y_BUTTON);
    }

    /**
     * Read the state of the back button.
     * @return the state of the back button.
     */
    public boolean getBackButton() {
        return getRawButton(BACK_BUTTON);
    }

    /**
     * Read the state of the start button.
     * @return the state of the start button.
     */
    public boolean getStartButton() {
        return getRawButton(START_BUTTON);
    }

    /**
     * Read the state of the right bumper button.
     * @return the state of the right bumper button.
     */
    public boolean getRightBumperButton() {
        return getRawButton(RIGHT_BUTTON);
    }

    /**
     * Read the state of the left bumper button.
     * @return the state of the left bumper button.
     */
    public boolean getLeftBumperButton() {
        return getRawButton(LEFT_BUTTON);
    }

    /**
     * Read the state of the left stick button.
     * @return the state of the left stick button.
     */
    public boolean getLeftStickButton() {
        return getRawButton(LEFT_JOYSTICK_BUTTON);
    }

    /**
     * Read the state of the right stick button.
     * @return the state of the right stick button.
     */
    public boolean getRightStickButton() {
        return getRawButton(RIGHT_JOYSTICK_BUTTON);
    } 
        
    /**
     * Read the state of the right trigger.
     * @return the state of the right trigger.
     */
    public double getRightTrigger() {
        return Math.max(getRawAxis(RIGHT_TRIGGER), 0);
    }

    public boolean getRightTriggerButton() {
        if((Math.max(getRawAxis(RIGHT_TRIGGER), 0)) > .5){
            return true;
        }
        else {
            return false;
        }
    }


    public double getLeftTrigger() {
        return Math.max(getRawAxis(LEFT_TRIGGER), 0);
    }

    
    public boolean getLeftTriggerButton() {
        if((Math.max(getRawAxis(LEFT_TRIGGER), 0))>.5){
            return true;
        }
        else {
            return false;
        }
    }

    public void vibrate(int controller, double power, int times) {
		double delay = 0.1;
		for (int i = 0; i < times; i++) {
			setRumble(power);
			Timer.delay(delay);
			setRumble(0);
			Timer.delay(delay);
		}
    }
    
    public void setRumble(double power) {
		this.setRumble(GenericHID.RumbleType.kLeftRumble, power);
		this.setRumble(GenericHID.RumbleType.kRightRumble, power);
	}
}
