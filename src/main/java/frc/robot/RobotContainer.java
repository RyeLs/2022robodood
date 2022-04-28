// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final drivetrainsub m_Drive = new drivetrainsub ();
  Joystick xboxController = new Joystick(0);
  private final hingesub m_Hinge = new hingesub ();
  private final intakesub m_Intake = new intakesub ();
  private final liftsub m_Lift = new liftsub ();
  private final shootersub m_Shooter = new shootersub ();
  private final AutonomousPhase autonomous = new AutonomousPhase (m_Drive, m_Shooter, m_Intake);

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_Drive.setDefaultCommand(
    new DriveTank (m_Drive, ()-> xboxController.getRawAxis(1), ()-> xboxController.getRawAxis(5) ));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  //if you want to disable something, comment out the button line and the associating command (whenpressed & when released)
  private void configureButtonBindings() {
    Button A = new JoystickButton(xboxController, 1);
    Button B = new JoystickButton(xboxController, 2);
    Button X = new JoystickButton(xboxController, 3);
    Button Y = new JoystickButton(xboxController, 4);
    Button LB = new JoystickButton(xboxController, 5);
    Button RB = new JoystickButton(xboxController, 6);
    Button Back = new JoystickButton(xboxController, 7);
    Button Start = new JoystickButton(xboxController, 8);
    triggersub Ltrigger = new triggersub(xboxController, 2);
    triggersub Rtrigger = new triggersub(xboxController, 3);

    A.whenPressed(new hingedown(m_Hinge));
    A.whenReleased(new hingestop(m_Hinge));

    B.whenPressed(new hingeup(m_Hinge));
    B.whenReleased(new hingestop(m_Hinge));

    //X.whenPressed(new winchlower(m_Lift));
    //X.whenReleased(new winchstop(m_Lift));

    //Y.whenPressed(new liftraise(m_Lift));
    //Y.whenReleased(new liftstop(m_Lift));
    
    LB.whenPressed(new shooterout(m_Shooter));
    LB.whenReleased(new shooterstop(m_Shooter));

    //RB.whenPressed(new shooterin(m_Shooter));
    //RB.whenReleased(new shooterstop(m_Shooter));

    //Back.whenPressed(new liftlower(m_Lift));
    //Back.whenReleased(new liftstop(m_Lift));

    //Start.whenPressed(new winchraise(m_Lift));
    //Start.whenReleased(new winchstop(m_Lift));

    Ltrigger.whenPressed(new intakeout(m_Intake));
    Ltrigger.whenReleased(new intakestop(m_Intake, m_Shooter));

    Rtrigger.whenPressed(new intakein(m_Intake, m_Shooter));
    Rtrigger.whenReleased(new intakestop(m_Intake, m_Shooter));

    /*

      left drive: left joystick
      right drive: right joystick

      hinge up: A
      hinge down: B
      intake out: LT
      intake in: RT
      shooter in: RT
      shooter out: LB

      lift down: Back
      winch up: Start
      winch down: X
      lift up: Y
    
      
    */

    /*
    if(xboxController.getRawAxis(2)>0.5){
      new shooterout(m_Shooter);
    }
    else{
      new shooterstop(m_Shooter);
    }

    if(xboxController.getRawAxis(3)>0.5){
      new shooterin(m_Shooter);
    }
    else{
      new shooterstop(m_Shooter);
    }*/

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autonomous;
  }
}
