package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shootersub;

public class shooterin extends CommandBase {

    private final shootersub m_Shooter;

    public shooterin(shootersub subsystem) {
        m_Shooter = subsystem;
        addRequirements(m_Shooter);
    }

    // only goes once at beginning when command is called
    @Override
    public void initialize() {
        
    }

    // keeps repeating until the command ends
    @Override
    public void execute() {
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
