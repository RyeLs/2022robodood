package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.liftsub;

public class liftstop extends CommandBase{

    private final liftsub m_Lift;

    public liftstop (liftsub subsystem){
        m_Lift = subsystem;
        addRequirements(m_Lift);
    }
    
     // only goes once at beginning when command is called
    @Override
    public void initialize(){
        
    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        m_Lift.liftStop();
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
