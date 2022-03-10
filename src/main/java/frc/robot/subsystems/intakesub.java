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
    public void intakeIn (){
        left.setVoltage(Constants.intakevolt);
        right.setVoltage(-Constants.intakevolt);
    }   

    //ball goes out
    public void intakeOut (){
        left.setVoltage(-Constants.intakevolt);
        right.setVoltage(Constants.intakevolt);
    }

    //intake no move
    public void intakeStop (){
        left.setVoltage(0);
        right.setVoltage(0);
    }
}
