/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {
  
  //private DigitalOutput lights1 = new DigitalOutput(RobotMap.ledStrip1);
  //private DigitalOutput lights2 = new DigitalOutput(RobotMap.ledStrip2);
  //private DigitalOutput lights3 = new DigitalOutput(RobotMap.ledStrip3);
  //private DigitalOutput lights4 = new DigitalOutput(RobotMap.ledStrip4);

  private int roborio_channel = 0;
  private final int NUM_ROBORIO_ONBOARD_DIGIO_PINS = 10;
  public final int MAX_NAVX_MXP_DIGIO_PIN_NUMBER = 9;

  private DigitalOutput lights1 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip1));
  private DigitalOutput lights2 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip2));
  private DigitalOutput lights3 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip3));
  private DigitalOutput lights4 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip4));

  public enum PinType {DigitalIO, PWM, AnalogIn, AnalogOut};

  public int getChannelFromPin(PinType type, int io_pin_number) {
    if ( io_pin_number < 0 ) {
      throw new IllegalArgumentException("Error:  navX MXP I/O Pin #");
    }
    if ( io_pin_number > MAX_NAVX_MXP_DIGIO_PIN_NUMBER ) {
      throw new IllegalArgumentException("Error:  Invalid navX MXP Digital I/O Pin #");
    }
    roborio_channel = io_pin_number + NUM_ROBORIO_ONBOARD_DIGIO_PINS + (io_pin_number > 3 ? 4 : 0);
    return roborio_channel;
  }

  public void fireBlue(){ //Disabled and Blue Alliance Default
    lights1.set(true);
    lights2.set(true);
    lights3.set(true);
    lights4.set(true);
  }

  public void meteorRain(){ //Auto
    lights1.set(true);
    lights2.set(true);
    lights3.set(true);
    lights4.set(false);
  }

  public void KITT(){ //
    lights1.set(true);
    lights2.set(true);
    lights3.set(false);
    lights4.set(true);
  }

  public void theaterCase(){ //Climbing
    lights1.set(true);
    lights2.set(false);
    lights3.set(true);
    lights4.set(true);
  }

  public void rainbowCycle(){ //5
    lights1.set(false);
    lights2.set(true);
    lights3.set(true);
    lights4.set(true);
  }

  public void strobeGreen(){ //
    lights1.set(false);
    lights2.set(false);
    lights3.set(true);
    lights4.set(true);
  }

  public void twinkle(){ //7
    lights1.set(true);
    lights2.set(true);
    lights3.set(false);
    lights4.set(false);
  }
  
  public void fadeGreen(){ //
    lights1.set(true);
    lights2.set(false);
    lights3.set(false);
    lights4.set(true);
  }

  public void green(){ //9 Done Indexing
    lights1.set(false);
    lights2.set(true);
    lights3.set(true);
    lights4.set(false);
  }

  public void yellow(){ //10 Indexing
    lights1.set(true);
    lights2.set(false);
    lights3.set(true);
    lights4.set(true);
  }

  public void red(){ //11
    lights1.set(false);
    lights2.set(true);
    lights3.set(false);
    lights4.set(true);
  }

  public void blue(){ //12
    lights1.set(false);
    lights2.set(false);
    lights3.set(false);
    lights4.set(true);
  }

  public void runningLights(){ //13 Shooter Ready and Limelight found target
    lights1.set(false);
    lights2.set(false);
    lights3.set(true);
    lights4.set(false);
  }

  public void fireRed(){ //14 Red Alliance Default
    lights1.set(false);
    lights2.set(true);
    lights3.set(false);
    lights4.set(false);
  }

  public void strobeYellow(){ //15
    lights1.set(true);
    lights2.set(false);
    lights3.set(false);
    lights4.set(false);
  }

  public void strobeRed(){ //16 
    lights1.set(false);
    lights2.set(false);
    lights3.set(false);
    lights4.set(false);
  }

  @Override
  public void periodic() {

  }
}
