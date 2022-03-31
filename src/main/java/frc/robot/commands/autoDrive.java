
package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrainsub;


public class autoDrive extends CommandBase{

    private final drivetrainsub m_Drive;
    //private final double distance;
    private double startTime;
    private double duration;
    
    public autoDrive (drivetrainsub subsystem, double distance){
        m_Drive = subsystem;
        //this.distance = distance;
        this.duration = duration*1000;

    }
    
    // only goes once at beginning when command is called
    @Override
    public void initialize(){
        //m_Drive.resetEncoder();
        startTime = System.currentTimeMillis();
    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        //m_Drive.autoDrive(distance);
        m_Drive.tankdrive(Constants.autodriveleft, Constants.autodriveright);
    }

    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted){
        m_Drive.tankdrive(0, 0);
    }

    //condition for the command to end on its own
    @Override
    public boolean isFinished(){
        /*if (m_Drive.getDistance()<distance) {
            return false;
        }
        else {
            return true;
        }
        */

        if (System.currentTimeMillis()-startTime<duration){
            return false;
        }
        else {
            return true;
        }
    }





}
