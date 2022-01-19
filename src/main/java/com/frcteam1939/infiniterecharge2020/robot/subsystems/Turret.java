/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Turret extends SubsystemBase {
  
  private double P = 0.0425;//.05
  private double I = 0.065;//.05
  private double D = 0.0005;

  private TalonSRX talon = new TalonSRX(RobotMap.turretTalon);
  
  public PIDController anglePID = new PIDController(P, I, D);

  private DutyCycleEncoder encoder = new DutyCycleEncoder(RobotMap.turretThroughBoreEncoder);

  private DigitalInput hallEffectClockwise = new DigitalInput(RobotMap.turretClockwiseStopHallEffect);
  private DigitalInput hallEffectCounterClockwise = new DigitalInput(RobotMap.turretCounterclockwiseStopHallEffect);
  private DigitalInput hallEffectClimber = new DigitalInput(RobotMap.turretClimberHallEffect);

  public static final double POSITIVE_LIMIT = 2.6; // Clockwise Hall Effect
  public static final double NEGATIVE_LIMIT = -2.82; // Counterclockwise Hall Effect

  public Turret(){
    talon.enableVoltageCompensation(true);
    // anglePID.setTolerance(.5);
  }

  @Override
  public void periodic() {

  }

  // Positive is clockwise
  public void set(double value){
    if ((isAtClockwiseLimit() || getPosition() > POSITIVE_LIMIT) && value > 0){
      value = 0;
    }

    if ((isAtCounterClockwiseLimit() || getPosition() < NEGATIVE_LIMIT) && value < 0){
      value = 0;
    }

    talon.set(ControlMode.PercentOutput, value);
  }

  public void setInitial(double value){
    talon.set(ControlMode.PercentOutput, value);
  }

  public void enableBrakeMode(){
    talon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    talon.setNeutralMode(NeutralMode.Coast);
  }

  public void zeroEncoder(){
    encoder.reset();
  }

  public double getPosition(){
    return encoder.getDistance();
  }

  public boolean isAtClockwiseLimit(){
    return !hallEffectClockwise.get();
  }

  public boolean isAtCounterClockwiseLimit(){
    return !hallEffectCounterClockwise.get();
  }

  public boolean isAtClimberPosition(){
    return !hallEffectClimber.get();
  }

  public double getMotorOutput(){
    return talon.getMotorOutputPercent();
  }
}