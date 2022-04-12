package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intakesub  extends SubsystemBase{
    private final Spark left;
    private final Spark right; 

    public intakesub() {
        left = new Spark(Constants.leftIntake);
        right = new Spark (Constants.rightIntake);
    }

    //ball goes in
    //for ball to go in, motors need to go in opposite directions
    //as long as the neg/pos voltages are opposite from the other direction
    public void intakeIn (){
        left.setVoltage(Constants.intakevolt);
        right.setVoltage(-Constants.intakevolt);
    }   

    //ball goes out
    //for ball to go out, motors need to go in opposite directions
    //as long as the neg/pos voltages are opposite from the other direction
    public void intakeOut (){
        left.setVoltage(-Constants.intakevolt);
        right.setVoltage(Constants.intakevolt);
    }

    //intake no move
    public void intakeStop (){
        left.setVoltage(0);
        right.setVoltage(0);
    }

    //auto intake
    //didnt use because we preloaded the ball for autonomous (and didnt intake another one after shooting)
    public void intakeAuto (){
        left.setVoltage(Constants.intakeauto);
        right.setVoltage(Constants.intakeauto);
    }

}

