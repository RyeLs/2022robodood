package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakesub;
import frc.robot.subsystems.shootersub;

public class intakein extends CommandBase {

    private final intakesub m_Intake;
    private final shootersub m_Shooter;

    public intakein(intakesub intakesub, shootersub shootersub) {
        m_Intake = intakesub;
        m_Shooter = shootersub;
        addRequirements(m_Intake, m_Shooter);
    }



    // only goes once at beginning when command is called
    @Override
    public void initialize() {
        
    }

    // keeps repeating until the command ends
    @Override
    public void execute() {
        m_Intake.intakeIn();
        m_Shooter.shooterIn();
    }

    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted) {

    }

    //condition for the command to end on its own
    @Override
    public boolean isFinished() {

        return false;
    }
}
