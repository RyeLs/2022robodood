
package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrainsub;


public class autoDrive extends CommandBase{

    private final drivetrainsub m_Drive;
    private final DoubleSupplier leftSpeed;
    private final DoubleSupplier rightSpeed;
    private final double distance;
    
    public autoDrive (drivetrainsub subsystem, DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, double distance){
        m_Drive = subsystem;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.distance = distance;

    }
    
    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        m_Drive.autoDrive(distance);
    }

    @Override
    public void end(boolean inerrupted){

    }

    @Override
    public boolean isFinished(){

        return false;

    }





}
