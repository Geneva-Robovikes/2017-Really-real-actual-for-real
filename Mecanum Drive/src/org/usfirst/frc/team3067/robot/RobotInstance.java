package org.usfirst.frc.team3067.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RobotInstance {//where everything is instantiated
	Servo gearDoorServo;//servo that controls the gear door
	RoboStick stickoBoyo;//the joystick
	Talon frontRight;//motor controllers below! :)
	Talon frontLeft;
	Talon backRight;
	Talon backLeft;
	Talon primaryShooter;
	Talon secondaryShooter;
	Talon winch;
	//SmartDashboard myDash;
	//AnalogGyro slickGyro;
	
	
	public RobotInstance() {
		stickoBoyo  = new RoboStick(5);
		frontRight = new Talon(1);
		frontLeft = new Talon(0);
		backRight = new Talon(3);
		backLeft = new Talon(2);
		winch = new Talon(5);
		primaryShooter = new Talon(6);
		secondaryShooter = new Talon(7);
		gearDoorServo = new Servo(4);//Maybe change the port later.
		//myDash = new SmartDashboard();
		//slickGyro = new AnalogGyro(0);
	}

	public void update() {//called in Robot.java, where every function that directly talks to the robot is called
		setMotor();
		//stickoBoyo.gyroDashboard();
	}
	
	public void setMotor(){
		/*
		frontRight.set(stickoBoyo.returnY() + stickoBoyo.returnX() + stickoBoyo.returnZ());
		frontLeft.set(-stickoBoyo.returnY() + stickoBoyo.returnX() + stickoBoyo.returnZ());
		backLeft.set(-stickoBoyo.returnY() - stickoBoyo.returnX() + stickoBoyo.returnZ());
		backRight.set(stickoBoyo.returnY() - stickoBoyo.returnX() + stickoBoyo.returnZ());
		*/
		frontRight.set(stickoBoyo.getDY() + stickoBoyo.getDX() + stickoBoyo.getDZ());
		frontLeft.set(-stickoBoyo.getDY() + stickoBoyo.getDX() + stickoBoyo.getDZ());
		backLeft.set(-stickoBoyo.getDY() - stickoBoyo.getDX() + stickoBoyo.getDZ());
		backRight.set(stickoBoyo.getDY() - stickoBoyo.getDX() + stickoBoyo.getDZ());
		
		if(stickoBoyo.getRawButton(1)){
			primaryShooter.set(stickoBoyo.getRawAxis(3));
			//secondaryShooter.set(1);
		}
		else{
			primaryShooter.set(0);
			//secondaryShooter.set(-1);
		}
		//Tells motors for each wheel what to do
		/*frontRight.set(stickoBoyo.returnY() + stickoBoyo.returnX() + stickoBoyo.returnZ());
		frontLeft.set(-stickoBoyo.returnY() + stickoBoyo.returnX() + stickoBoyo.returnZ());
		backLeft.set(-stickoBoyo.returnY() - stickoBoyo.returnX() + stickoBoyo.returnZ());
		backRight.set(stickoBoyo.returnY() - stickoBoyo.returnX() + stickoBoyo.returnZ());
		*/
		if (stickoBoyo.getWinchButton())
			winch.set(1);
		else
			winch.set(0);
	}
	public void setServos(){
		if(stickoBoyo.getTrigger()){//COME BACK WHEN YOU HAVE SERVO VALUES!!!!!!!!
			//servo for gear but wouldnt shooter work better for trigger?
		}
	}
	
	
	
}


