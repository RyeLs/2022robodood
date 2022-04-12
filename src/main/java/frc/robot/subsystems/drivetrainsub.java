// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//motor groupings for left and right drive
public class drivetrainsub extends SubsystemBase {
  Spark frontright = new Spark(Constants.frontRightDrive);
  Spark backright = new Spark (Constants.backRightDrive);
  MotorControllerGroup m_right = new MotorControllerGroup(frontright,backright);

  Spark frontleft = new Spark (Constants.frontLeftDrive);
  Spark backleft = new Spark (Constants.backLeftDrive);
  MotorControllerGroup m_left = new MotorControllerGroup(frontleft, backleft);
  
  DifferentialDrive drive = new DifferentialDrive(m_right,m_left);

  //encoders for drive (which we didnt use)
  private Encoder right =new Encoder (Constants.rightEncoder1, Constants.rightEncoder2);
  private Encoder left =new Encoder (Constants.leftEncoder1, Constants.leftEncoder2);

  
/** Creates a new drivetrainsub. */
  public drivetrainsub() {
    right.setDistancePerPulse(100);
    left.setDistancePerPulse(100);
  }
/**
 * Makes drive into tank drive
 * @param leftSpeed robots left side speed
 * @param rightSpeed robots right side speed
 */
public void tankdrive(double leftSpeed,double rightSpeed) {
  drive.tankDrive(-leftSpeed, rightSpeed,false);
}

//resets the encoder to 0
public void resetEncoder(){
  right.reset();
  left.reset();
}

//tells the distance of how far youve traveled
public double getDistance(){
  return Math.abs((right.getDistance()+left.getDistance())/2);
}

//command for autodrive
//also gradually increases break as you get closer to your destination so the robot stops exactly where you need it do
public void autoDrive(double distance) {
  while (getDistance()<distance){
    double brake = 1-getDistance()/distance;
    tankdrive(-Constants.autoDrive*brake, Constants.autoDrive*brake);
  }
}

public double getRotation(){
  return 1;
}

//command for autoturn
//same thing as autodrive but with degrees instead of distance
public void autoTurn(double degrees){
  while (getRotation()<degrees){
    double brake = 1-getRotation()/degrees;
    tankdrive(Constants.autoDrive*brake, Constants.autoDrive*brake);
  }
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public double distanceget() {
    return right.getDistance();
  }
}
