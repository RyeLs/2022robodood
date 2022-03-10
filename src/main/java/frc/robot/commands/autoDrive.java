
package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrainsub;


public class autoDrive extends CommandBase{

    private final drivetrainsub m_Drive;
    private final double distance;
    
    public autoDrive (drivetrainsub subsystem, double distance){
        m_Drive = subsystem;
        this.distance = distance;

    }
    
    // only goes once at beginning when command is called
    @Override
    public void initialize(){
        m_Drive.resetEncoder();
    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        m_Drive.autoDrive(distance);
    }

    //only goes once at end when command is finishing
    @Override
    public void end(boolean inerrupted){
        m_Drive.tankdrive(0, 0);
    }

    //condition for the command to end on its own
    @Override
    public boolean isFinished(){
        if (m_Drive.getDistance()<distance) {
            return false;
        }
        else {
            return true;
        }
        

    }





}
