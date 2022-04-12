
package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.intakesub;
import frc.robot.subsystems.shootersub;

/*commented out lines are from the previously used shooter-intake autosequence
  putting intake & shooter in one command for autosequence 
*/
//current lines are for time-based autonomous

public class autoShooter extends CommandBase{

    private final shootersub m_Shooter;
    //private final intakesub m_Intake;
    private double startTime;
    private double duration;
    
    public autoShooter (shootersub shootersub, intakesub intakesub, double duration){
        m_Shooter = shootersub;
        //m_Intake = intakesub;
        this.duration = duration*1000;

    }
    
    // only goes once at beginning when command is called
    @Override
    public void initialize(){
        startTime = System.currentTimeMillis();
        /*System.out.println("shooter");
            line to test if code is working more or less
        */
    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        m_Shooter.shooterAuto();
        //new WaitCommand(2);
        //m_Intake.intakeAuto();
    }

    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted){
        //m_Shooter.shooterStop();
        //m_Intake.intakeStop();
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
