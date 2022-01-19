/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.intakeSolenoid);
  private TalonSRX talon = new TalonSRX(RobotMap.intakeTalon);

  public Intake(){
    talon.enableVoltageCompensation(true);
    talon.setInverted(true);
    disableBrakeMode();
  }

  @Override
  public void periodic() {
  }

  public void extendIntake(){
    solenoid.set(true);
  }

  public void retractIntake(){
    solenoid.set(false);
  }

  // Positive is in
  public void setRoller(double value){
    talon.set(ControlMode.PercentOutput, value);
  }

  public void enableBrakeMode(){
    talon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    talon.setNeutralMode(NeutralMode.Coast);
  }

  public double getCurrent(){
    return talon.getSupplyCurrent();
  }
}