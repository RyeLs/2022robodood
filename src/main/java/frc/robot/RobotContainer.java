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
  private final AutonomousPhase autonomous = new AutonomousPhase ();
  private final hingesub m_Hinge = new hingesub ();
  private final intakesub m_Intake = new intakesub ();
  private final liftsub m_Lift = new liftsub ();
  private final shootersub m_Shooter = new shootersub ();


  

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

    A.whenPressed(new intakeout(m_Intake));
    A.whenReleased(new intakestop(m_Intake));

    B.whenPressed(new intakein(m_Intake));
    B.whenReleased(new intakestop(m_Intake));

    X.whenPressed(new winchlower(m_Lift));
    X.whenReleased(new winchstop(m_Lift));

    Y.whenPressed(new winchraise(m_Lift));
    Y.whenReleased(new winchstop(m_Lift));

    LB.whenPressed(new hingedown(m_Hinge));
    LB.whenReleased(new hingestop(m_Hinge));

    RB.whenPressed(new hingeup(m_Hinge));
    RB.whenReleased(new hingestop(m_Hinge));

    Back.whenPressed(new liftlower(m_Lift));
    Back.whenReleased(new liftstop(m_Lift));

    Start.whenPressed(new liftraise(m_Lift));
    Start.whenReleased(new liftstop(m_Lift));

    Ltrigger.whenPressed(new shooterout(m_Shooter));
    Ltrigger.whenReleased(new shooterstop(m_Shooter));

    Rtrigger.whenPressed(new shooterin(m_Shooter));
    Rtrigger.whenReleased(new shooterstop(m_Shooter));

    /*
      out/down - left
      in/up - right

      left drive: left joystick
      right drive: right joystick

      hinge down: LB
      hinge up: RB
      intake out: A
      intake in: B
      shooter out: LT
      shooter in: RT

      lift down: back
      lift up: start
      winch down: X
      winch up: Y
      
    /*

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
