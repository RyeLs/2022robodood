// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class hingesub extends SubsystemBase{
    private final CANSparkMax hingemotor;

    public hingesub (){
        hingemotor= new CANSparkMax(Constants.hinge, MotorType.kBrushless);
    }
    //hinge goes up
    public void hingeup(){

        hingemotor.setVoltage (-Constants.hingevolt);

    }

    //hinge goes down
    public void hingedown(){

        hingemotor.setVoltage (Constants.hingevolt);
        
    }

    //hinge no go
    public void hingestop(){

        hingemotor.setVoltage (0);
        
    }


}