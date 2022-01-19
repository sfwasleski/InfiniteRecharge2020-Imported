/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  
  private TalonSRX talonHorizontal = new TalonSRX(RobotMap.indexerHorizontalTalon);
  private TalonSRX talonVertical = new TalonSRX(RobotMap.indexerVerticalTalon);

  private DutyCycleEncoder encoder = new DutyCycleEncoder(RobotMap.indexerVerticalThroughBoreEncoder);
  // Banner sensor, through bore encoder

  private TimeOfFlight distanceSensorTop = new TimeOfFlight(RobotMap.indexerTopDistanceSensor);
  private TimeOfFlight distanceSensorBottom = new TimeOfFlight(RobotMap.indexerBottomDistanceSensor);

  public final double INDEXER_SHOOT_SPEED = 1.0;
  public final double INDEXER_HORIONTAL_SPEED = 0.7;
  public final double INDEXER_VERTICAL_SPEED = 0.4;

  public final double DIST_ONE_BALL = 80;// ranges from 30-130
  public final double DIST_DEFAULT_TOP = 200;
  public final double DIST_DEFAULT_BOTTOM = 250;
  public final double DIST_THIRD_BALL = .25;//changes from current position by .25 encoder ticks

  public final double BALL_CURRENT = 40;

  public boolean isIndexing = false;
  public boolean isDoneIndexing = false;

  public Indexer() {
    talonHorizontal.enableVoltageCompensation(true);
    talonVertical.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
  }

  public void set(double value){
    talonVertical.set(ControlMode.PercentOutput,value);
    talonHorizontal.set(ControlMode.PercentOutput,value);
  }
  public void stop(){
    talonVertical.set(ControlMode.PercentOutput,0);
    talonHorizontal.set(ControlMode.PercentOutput,0);
    isIndexing = false;
    Robot.lights.green();
  }

  // Positive is in
  public void setHorizontal(double value){
    talonHorizontal.set(ControlMode.PercentOutput,value);
  }

  // Positive is up
  public void setVertical(double value){
    talonVertical.set(ControlMode.PercentOutput,value);
  }

  public void enableBrakeMode(){
    talonVertical.setNeutralMode(NeutralMode.Brake);
    talonHorizontal.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    talonVertical.setNeutralMode(NeutralMode.Coast);
    talonHorizontal.setNeutralMode(NeutralMode.Coast);
  }

  public double getDistanceTop(){
    return distanceSensorTop.getRange();
  }

  public double getDistanceBottom(){
    return distanceSensorBottom.getRange();
  }

  public double getPosition(){
    return encoder.getDistance();
  }

  public void zeroEncoder(){
    encoder.reset();
  }
  public double getPositionChange(){
    return encoder.getPositionOffset();
  }

  public double getHorzCurrentDraw(){
    return talonHorizontal.getStatorCurrent();
  }
  public double getVertCurrentDraw(){
    return talonVertical.getStatorCurrent();
  }
  
  public boolean getIsDoneIndexing(){
    return isDoneIndexing;
  }
  public boolean getIsIndexing(){
    return isIndexing;
  }
}
