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
            new autoShooter(shootersub),
            new WaitCommand(2),
            new intakeout(intakesub),
            new WaitCommand(2),
            new shooterstop(shootersub),
            new intakestop(intakesub),
            new autoDrive(drivetrainsub, 2),
            new WaitCommand(1),
            new autoTurn(drivetrainsub, 1)
        );
    }
}
