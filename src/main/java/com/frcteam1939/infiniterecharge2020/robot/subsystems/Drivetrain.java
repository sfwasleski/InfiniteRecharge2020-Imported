/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Drivetrain extends SubsystemBase {

  private static final double WHEEL_DIAMETER = 6.0;
  private static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
  private static final double MAX_TURN_OUTPUT = 0.25;

  private static final double MAX_SPEED = 0.0;

  private static final double CPR = 2048.0;

  private static final int MOTION_MAGIC_CRUISE_VELOCITY = 0;
  private static final int MOTION_MAGIC_ACCELERATION = 0;

  private static final int posIndex = 0;
  private static final double posP = 0;
  private static final double posI = 0;
  private static final double posD = 0;

	private static final double MAX_TURN_OUPUT = 0.25;
	private static final double turnF = 0;//= 0.071;
	private static final double turnP = 0.03;
	private static final double turnI = 0;
	private static final double turnD = 0;

  private TalonFX frontLeft = new TalonFX(RobotMap.leftFrontFalcon);
  private TalonFX backLeft = new TalonFX(RobotMap.leftBackFalcon);
  private TalonFX frontRight = new TalonFX(RobotMap.rightFrontFalcon);
  private TalonFX backRight = new TalonFX(RobotMap.rightBackFalcon);

  public CANSparkMax sidewinder = new CANSparkMax(RobotMap.sidewinderSpark, MotorType.kBrushless);
  private Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.sidewinderSolenoid);

  private AHRS navx;
  private PIDController posPID;
  private PIDController turnPID;

  private boolean controllerDriveMode = false;
  private boolean sidewinderDown = true; 
  /*
  private AHRS navx;
	public PIDController posPID;
  public PIDController turnPID;
  */

  // private AHRS navx;
  // public Limelight limelight = new Limelight();

  public Drivetrain(){
    setupMasterTalons();

    this.navx = new AHRS(Port.kMXP);
		this.turnPID = new PIDController(turnP, turnI, turnD);
    this.turnPID.enableContinuousInput(-180, 180);
		this.turnPID.setSetpoint(0);

    this.sidewinder.enableVoltageCompensation(12.0);
    
    SmartDashboard.putBoolean("Controller Mode", controllerDriveMode);

  }
  @Override
  public void periodic() {
  }

  // Get Methods 

  public double getLeftPosition(){
    double frontPosition = frontLeft.getSelectedSensorPosition() / CPR;
    double backPosition = backLeft.getSelectedSensorPosition() / CPR;
    return (frontPosition + backPosition) / 2.0;
  }

  public double getRightPosition(){
    double frontPosition = frontRight.getSelectedSensorPosition() / CPR;
    double backPosition = backRight.getSelectedSensorPosition() / CPR;
    return (frontPosition + backPosition) / 2.0;
  }

  public double getLeftVelocity(){
    double frontVelocity = frontLeft.getSelectedSensorVelocity();
    double backVelocity = backLeft.getSelectedSensorVelocity();
    return (frontVelocity + backVelocity) / 2.0;
  }

  public double getRightVelocity(){
    double frontVelocity = frontRight.getSelectedSensorVelocity();
    double backVelocity = backRight.getSelectedSensorVelocity();
    return (frontVelocity + backVelocity) / 2.0;
  }

  public double getLeftPercentOutput(){
    return frontLeft.getMotorOutputPercent();
  }

  public double getRightPercentOutput(){
    return frontRight.getMotorOutputPercent();
  }

  public double getLeftVoltage(){
    return frontLeft.getMotorOutputVoltage();
  }

  public double getRightVoltage(){
    return frontRight.getMotorOutputVoltage();
  }

  
  public double getHeading() {
		if (this.navx.isConnected()) return this.navx.getYaw();
		else return 0;
	}

	public double getTurnSpeed() {
		if (this.navx.isConnected()) return this.navx.getRate();
		else return 0;
  }
  

  // public double getHeading() {
	// 	if (navx.isConnected()) {
	// 		return navx.pidGet();
	// 	} else {
	// 		return 0;
	// 	}
	// }

	// public double getTurnSpeed() {
		// if (navx.isConnected()) {
		//	return navx.getRate();
	// 	} else {
	// 		return 0;
	// 	}
	// }

  public boolean getControllerDriveMode(){
    return controllerDriveMode;
  }

  // Set Methods

  public void toggleControllerDriveMode(){
    if(controllerDriveMode == true){
      controllerDriveMode = false;
    } else if(controllerDriveMode == false){
      controllerDriveMode = true;
    }
  }

  public void toggleSidewinder(){
    if(sidewinderDown == false){
      
      sidewinderDown();
      sidewinderDown = true;
    } else {
      sidewinderUp();
      sidewinderDown = false;
    }
  }

  public void enableControllerDriveMode(){
    controllerDriveMode = true;
  }

  public void disableControllerDriveMode(){
    controllerDriveMode = false;
  }

  public void setPercentOutput(double leftPercent, double rightPercent){
    frontLeft.set(ControlMode.PercentOutput, leftPercent);
    frontRight.set(ControlMode.PercentOutput, rightPercent);
  }

  public void setDistance(double value){
    frontLeft.set(ControlMode.MotionMagic, value);
    frontRight.set(ControlMode.MotionMagic, value);
  }

  public void stop(){
    setPercentOutput(0, 0);
  }

  public void zeroEncoders(){
    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);
  }

  public void sidewinderDown() {
		solenoid.set(true);
	}

	public void sidewinderUp() {
		solenoid.set(false);
  }
  
  public void strafe(double voltage) {
	  sidewinder.set(voltage);
  }

  public void resetGyro() {
		if (this.navx != null) {
			this.navx.reset();
		}
  }
  
  private boolean correcting = false;

  public void drive(double moveValue, double rotateValue, double strafeValue) {

    if (rotateValue == 0 && strafeValue != 0) {
			if (!this.correcting) {
				this.resetGyro();
				this.turnPID.reset();
				this.turnPID.setSetpoint(0);
				this.correcting = true;
			}
			rotateValue = this.turnPID.calculate(this.navx.getYaw()) + turnF * strafeValue;
      rotateValue = MathUtil.clamp(rotateValue, -MAX_TURN_OUPUT, MAX_TURN_OUPUT);
		} else if (this.correcting) {
			this.correcting = false;
    }

    strafe(-strafeValue);
    
		// Calculate left and right speeds from move and rotate values
		double leftMotorSpeed;
		double rightMotorSpeed;
		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}

		// Tell Drivetrain to move
    setPercentOutput(-leftMotorSpeed, -rightMotorSpeed);
    
		SmartDashboard.putNumber("Move Output", moveValue);
		SmartDashboard.putNumber("Turn Output", rotateValue);
  }

  public void enableBrakeMode(){
    frontLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    frontLeft.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    frontLeft.setNeutralMode(NeutralMode.Coast);
    backLeft.setNeutralMode(NeutralMode.Coast);
    frontRight.setNeutralMode(NeutralMode.Coast);
    frontLeft.setNeutralMode(NeutralMode.Coast);
  }

  public void setPositionPID(double P, double I, double D){
    frontLeft.selectProfileSlot(posIndex, 0);
    frontRight.selectProfileSlot(posIndex, 0);
    frontLeft.config_kP(posIndex, P);
    frontLeft.config_kI(posIndex, I);
    frontLeft.config_kD(posIndex, D);
    frontRight.config_kP(posIndex, P);
    frontRight.config_kI(posIndex, I);
    frontRight.config_kD(posIndex, D);
  }

  // Private Convenience Methods

  private void setupMasterTalons(){

    frontRight.setInverted(true);
    backRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    setPositionPID(posP, posI, posD);

    frontLeft.configNominalOutputForward(+0);
		frontLeft.configNominalOutputReverse(-0);
		frontLeft.configPeakOutputForward(+.7);
    frontLeft.configPeakOutputReverse(-.7);
    frontRight.configNominalOutputForward(+0);
		frontRight.configNominalOutputReverse(-0);
		frontRight.configPeakOutputForward(+.7);
    frontRight.configPeakOutputReverse(-.7);
    frontLeft.enableVoltageCompensation(true);
    frontRight.enableVoltageCompensation(true);

		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
		frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
    frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
    frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);
    frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);

    frontLeft.configMotionCruiseVelocity(MOTION_MAGIC_CRUISE_VELOCITY);
    frontLeft.configMotionAcceleration(MOTION_MAGIC_ACCELERATION);
    frontRight.configMotionCruiseVelocity(MOTION_MAGIC_CRUISE_VELOCITY);
    frontRight.configMotionAcceleration(MOTION_MAGIC_ACCELERATION);
    frontLeft.configOpenloopRamp(.5);
    frontRight.configOpenloopRamp(.5);

  }
}
