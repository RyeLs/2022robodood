package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrainsub;

public class autoTurn extends CommandBase {
    private final drivetrainsub m_Drive;
    private final double degrees;
    
    public autoTurn (drivetrainsub subsystem, double degrees){
        m_Drive = subsystem;
        this.degrees = degrees;

    }
    
    // only goes once at beginning when command is called
    @Override
    public void initialize(){
        
    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        m_Drive.autoTurn(degrees);
    }

    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted){
        m_Drive.tankdrive(0, 0);
    }

    //condition for the command to end on its own
    @Override
    public boolean isFinished(){
        if (m_Drive.getRotation()<degrees) {
            return false;
        }
        else {
            return true;
        }
        

    }

}
