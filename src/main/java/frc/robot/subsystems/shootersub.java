package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class shootersub extends SubsystemBase {
    private final Spark left;
    private final Spark right;
    
    public shootersub() {
        left = new Spark(Constants.leftShooter);
        right = new Spark(Constants.rightShooter); 
    }

    //ball goes in
    //for ball to go in, motors need to go in opposite directions
    //as long as the neg/pos voltages are opposite from the other direction
    public void shooterIn (){
        left.setVoltage(-Constants.shootervoltin);
        right.setVoltage(-Constants.shootervoltin);
    }   

    //ball goes out
    //for ball to go out, motors need to go in opposite directions
    //as long as the neg/pos voltages are opposite from the other direction
    public void shooterOut (){
        left.setVoltage(Constants.shootervoltout);
        right.setVoltage(Constants.shootervoltout);
    }

    //shooter no move
    public void shooterStop (){
        left.setVoltage(0);
        right.setVoltage(0);
    }

    //auto shooter
    public void shooterAuto (){
        left.setVoltage(Constants.shooterauto);
        right.setVoltage(Constants.shooterauto);
    }
}

