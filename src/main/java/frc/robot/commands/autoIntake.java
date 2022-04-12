
package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakesub;


public class autoIntake extends CommandBase{

    private final intakesub m_Intake;
    private double startTime;
    private double duration;
    
    public autoIntake (intakesub intakesub, double duration){
        m_Intake = intakesub;
        this.duration = duration*1000;

    }
    
    // only goes once at beginning when command is called
    @Override
    public void initialize(){
        startTime = System.currentTimeMillis();
    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        m_Intake.intakeOut();
    }

    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted){
        m_Intake.intakeStop();
    }

    //condition for the command to end on its own
    @Override
    public boolean isFinished(){
        if (System.currentTimeMillis()-startTime<duration){
            return false;
        }
        else {
            return true;
        }

    }





}