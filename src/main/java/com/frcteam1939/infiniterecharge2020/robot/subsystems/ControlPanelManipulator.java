/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*
package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;


import com.revrobotics.CANEncoder;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanelManipulator extends SubsystemBase {

  private CANSparkMax spark = new CANSparkMax(RobotMap.controlPanelSpark, MotorType.kBrushless);
  public CANEncoder sparkEncoder = spark.getEncoder();

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch m_colorMatcher = new ColorMatch();
  


  /*
  private double Blue_r = 0.143;
  private double Blue_g = 0.427;
  private double Blue_b = 0.429;

  private double Green_r = 0.197;
  private double Green_g = 0.561;
  private double Green_b = 0.240;

  private double Red_r = 0.561;
  private double Red_g = 0.232;
  private double Red_b = 0.114;

  private double Yellow_r = 0.361;
  private double Yellow_g = 0.524;
  private double Yellow_b = 0.113;

  private final Color kBlueTarget = ColorMatch.makeColor(Blue_r, Blue_g, Blue_b);
  private final Color kGreenTarget = ColorMatch.makeColor(Green_r, Green_g, Green_b);
  private final Color kRedTarget = ColorMatch.makeColor(Red_r, Red_g, Red_b);
  private final Color kYellowTarget = ColorMatch.makeColor(Yellow_r, Yellow_g, Yellow_b);
  
  
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  String gameData;

  public ControlPanelManipulator(){
   // spark.enableVoltageCompensation()
    //talon.enableVoltageCompensation(true);
    // talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); // Need to check
  }

  @Override
  public void periodic() {
  }

  // Positive is clockwise
  public void set(double value) { 
    spark.set(value);
  }

  public void stop(){
    set(0);
  }

  public double getRotations(){
    return sparkEncoder.getPosition();
  }
  
  /*
  public void resetEncoder(){
    spark.();
  }
  

  public void enableBrakeMode() {
    spark.setIdleMode(IdleMode.kBrake);
	}

	public void disableBrakeMode() {
    spark.setIdleMode(IdleMode.kCoast);
  }
  public String getColor(){
    
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);    
    
    Color detectedColor = m_colorSensor.getColor();

    String colorString;

    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    return colorString;
    }

  public boolean colorIsAligned(String color){
    if (Robot.controlPanelManipulator.getColor() == color){
      return true;
    }
    else {
      return false;
    }
  }

  public String colorFromFMS(){
    gameData = DriverStation.getGameSpecificMessage();
    if(gameData.length() > 0){
      switch (gameData.charAt(0)){
        case 'B' :
          return "Red";
        case 'G' :
          return "Yellow";
        case 'R' :
          return "Blue";
        case 'Y' :
          return "Green";
        default :
          return "Corrupt";
    }
  }   else {
      return "Unknown";
    }
  }

}
*/