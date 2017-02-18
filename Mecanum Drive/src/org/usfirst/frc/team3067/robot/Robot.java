package org.usfirst.frc.team3067.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {//Test Comment for New Branch
	
	RobotInstance grunchBot;
	//RobotDrive myDrive = new RobotDrive(1,3,2,4);//frontleft, backleft, frontright, back right
	//myDrive.setInvertedMotor(myDrive.MotorType kFrontLeft, true);	// invert the left side motors
	//myDrive.setInvertedMotor(MotorType.kRearLeft, true);
	//RobotDrive robo = new RobotDrive
	public void robotInit(){ //asdfghjklqwertyuiop
		grunchBot  = new RobotInstance();
	}
	
	public void autonomousInit(){
		
	}
	
	public void autonomousPeriodic(){
		
	}
	
	public void teleopInit(){

	}
	
	public void teleopPeriodic(){
		grunchBot.update();
		SmartDashboard.putNumber("Gyro Angle", grunchBot.stickoBoyo.newgyro.getAngle());
		SmartDashboard.putNumber("Front Right", grunchBot.frontRight.get());
		SmartDashboard.putNumber("Front Left", grunchBot.frontLeft.get());
		SmartDashboard.putNumber("Back Right", grunchBot.backRight.get());
		SmartDashboard.putNumber("Back Left", grunchBot.backLeft.get());
		SmartDashboard.putBoolean("Shooter Input", grunchBot.stickoBoyo.getRawButton(1));
		SmartDashboard.putNumber("Motor Output", grunchBot.primaryShooter.get());
		}
}
