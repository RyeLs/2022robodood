package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public class triggersub extends Button {
    GenericHID trigger;
    int axis;
    private double threshold = 0.5;

    public triggersub (GenericHID trigger, int axis){
        this.trigger = trigger;
        this.axis = axis; 
    }
    /*
    public Button whenPressed(final Command command){
        whenActive(command);
        return this;
    } */

    public boolean get(){
        if(trigger.getRawAxis(axis)>threshold){
            return true;
        }
        else{
            return false;
        }
    }
}
