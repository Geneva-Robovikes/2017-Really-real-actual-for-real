package org.usfirst.frc.team3067.robot;

import edu.wpi.first.wpilibj.*; 
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
//import java.math.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

public class RoboStick extends Joystick {

	double dead;
	SmartDashboard myDash;
	boolean buttonState[];
	ADXRS450_Gyro newgyro;
	String bigGuy;
	public RoboStick(int port) {
		super(port);
		buttonState = new boolean[12];
		myDash = new SmartDashboard();
		newgyro = new ADXRS450_Gyro(Port.kOnboardCS0);
		newgyro.calibrate();//need to end calibration before autonomousInit
		newgyro.reset();
		newgyro.calibrate();
		for(int i = 0; i < buttonState.length; i++){
			buttonState[i] = false;
		}
		
	}

	public double deadZone(double input) {
		dead = .30;
		if (input < dead && input > -dead)
			return 0;
		else 
			return input;
	}
	
	public double getDX(){
		return deadZone(this.getRawAxis(0));
	}
	
	public double getDY(){
		return deadZone(this.getRawAxis(1));
	}
	
	public double getDZ(){
		return .7 * deadZone(this.getRawAxis(2));
	}
	
	public double returnX(){
		double angle = newgyro.getAngle();
		return deadZone((this.getRawAxis(1) * Math.sin(angle) )
				+ (this.getRawAxis(0) * Math.cos(angle)));
	}
	
	public double returnY(){
		double angle = newgyro.getAngle();
		return -deadZone( (this.getRawAxis(1) * Math.cos(angle)) 
				+ (this.getRawAxis(0) * Math.sin(angle)));
	}
	
	public double returnZ(){
		return deadZone(this.getRawAxis(2));
	}
	
	public boolean returnTrigger(){//I hardly know her
		/*if(this.getRawButton(0) && !buttonState[0]){
			buttonState[0] = true;
			return true;
		}*/
		if(!this.getRawButton(0) && !buttonState[0]){
			buttonState[0] = false;
			return false;
		}
		return false;
	}
	
	public boolean getWinchButton(){
		if(this.getRawButton(2) && !buttonState[2]){
			buttonState[2] = true;
			return true;
		}
		if(!this.getRawButton(2) && !buttonState[2]){
			buttonState[2] = false;
			return false;
		}
		return false;
	}
	
	public void gyroDashboard(){
		//bigGuy = bigGuy + String(newgyro.getAngle());
	}
}