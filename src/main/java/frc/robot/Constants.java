// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //the number is the pwm channel that the spark is attached to :)
    public static int frontRightDrive = 2;
    public static int backRightDrive = 3;
    public static int frontLeftDrive = 0;
    public static int backLeftDrive = 1; 
    public static int leftIntake = 4; 
    public static int rightIntake = 5;
    public static int leftShooter = 6;
    public static int rightShooter = 7;

    //the number is the CAN ID that the spark max is attached to :)
    public static int hinge = 1;
    public static int lift = 2;
    public static int winch = 3;

    //setting the voltage (power) for the motors
    public static double hingevolt = 5; //change this later when figuring out the voltage for the robo
    public static double intakevolt = 7;
    public static double liftvoltup = 4;
    public static double liftvoltdown = -2;
    public static double shootervoltout = 9;
    public static double shootervoltin = 6;
    public static double autoDrive = .3;
    public static double winchvolt = 5;

    //list of dio ports for sensors
    public static int rightEncoder1 = 0;
    public static int rightEncoder2 = 1;
    public static int leftEncoder1 = 8;
    public static int leftEncoder2 = 9;

    //setting the voltage for autonomous 
    public static double shooterauto = 8;
    public static double intakeauto = 7;
    public static double autodriveleft = .3;
    public static double autodriveright = .3;
}
