package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.drivetrainsub;
import frc.robot.subsystems.intakesub;
import frc.robot.subsystems.shootersub;

public class AutonomousPhase extends SequentialCommandGroup{
    /** Autonomous #1: Shoot lower hub
     * Autonomous #2: Drive backwards 1 foot
     * Autonomous #3: turn 180 degrees
     */

    public AutonomousPhase(drivetrainsub drivetrainsub, shootersub shootersub, intakesub intakesub){
        addCommands(
            //number at the end is for how long the command runs (in seconds)
            new autoDrive(drivetrainsub, 2.6),
            new WaitCommand(1),
            new autoShooter(shootersub, intakesub, 4),
            new autoIntake(intakesub, 2),
            new shooterstop(shootersub),
            new WaitCommand(1),
            new autoDrive(drivetrainsub, .5),
            new WaitCommand(0),
            new autoTurn(drivetrainsub, 0)
        );
    }
}
