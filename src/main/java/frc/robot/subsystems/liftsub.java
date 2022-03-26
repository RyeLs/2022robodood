package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class liftsub  extends SubsystemBase{
    private final CANSparkMax winch;
    private final CANSparkMax lift; 

    public liftsub() {
        winch = new CANSparkMax (Constants.winch, MotorType.kBrushless);
        lift = new CANSparkMax (Constants.lift, MotorType.kBrushless);
    }

    //lift goes up
    public void liftRaise (){
        lift.setVoltage(Constants.liftvoltup);
    }   

    //lift goes down
    public void liftLower (){
        lift.setVoltage(Constants.liftvoltdown);
    
    }
    //lift no move
    public void liftStop (){
        lift.setVoltage(0);
    }

    //winch goes up
    public void winchRaise (){
        winch.setVoltage(-Constants.winchvolt);
        
    }   

    //winch goes down
    public void winchLower (){
        winch.setVoltage(Constants.winchvolt);
        
    }

    //winch no move
    public void winchStop (){
        winch.setVoltage(0);
        
    }
}
