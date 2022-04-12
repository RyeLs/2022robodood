package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrainsub;


public class DriveTank extends CommandBase{

    private final drivetrainsub m_Drive;
    private final DoubleSupplier leftSpeed;
    private final DoubleSupplier rightSpeed;
    
    public DriveTank (drivetrainsub subsystem, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed){
        m_Drive = subsystem;
        addRequirements(m_Drive);
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }
    
     // only goes once at beginning when command is called
    @Override
    public void initialize(){

    }

    // keeps repeating until the command ends
    @Override
    public void execute(){
        //m_Drive.tankdrive(Math.pow(leftSpeed.getAsDouble(), 3)/1.7, Math.pow(rightSpeed.getAsDouble(), 3)/1.7);
        if (leftSpeed.getAsDouble()*rightSpeed.getAsDouble()<0){
            m_Drive.tankdrive(leftSpeed.getAsDouble()/2, rightSpeed.getAsDouble()/2);
        }
        else {
            //Four changes
            m_Drive.tankdrive(-1.1/(1+Math.pow(2,-2*(-leftSpeed.getAsDouble()-.5)))+(1.1/3), 
            -1.1/(1+Math.pow(2,-2*(-rightSpeed.getAsDouble()-.5)))+(1.1/3));
        }
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
