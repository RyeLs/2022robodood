package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.hingesub;

public class hingedown extends CommandBase{
    private final hingesub m_Hinge;

    public hingedown (hingesub subsystem) {
        m_Hinge = subsystem;
        addRequirements(m_Hinge);
    }

     // only goes once at beginning when command is called
    @Override
    public void initialize(){
        
    }
    
    // keeps repeating until the command ends
    @Override
    public void execute(){
        m_Hinge.hingedown();   
    }
    
    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted){
    
    }
    
    //condition for the command to end on its own
    @Override
    public boolean isFinished(){

        return false;
    }

}