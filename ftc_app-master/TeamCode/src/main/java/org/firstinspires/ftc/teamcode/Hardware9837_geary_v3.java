package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Anjali on 10/19/2018.
 */

class Hardware9837_geary_v3 {
    DcMotor rightMotor;
    DcMotor leftMotor;
    
    ColorSensor colorSensorLeft;
    ColorSensor colorSensorRight;
    
    Servo markerPusher;
    
    DcMotor intakeMotor;
    DcMotor armMotor;
    DcMotor extendIntakeMotor;
    
    DcMotor liftUpMotor;

    //HardwareMap hwMap = null;
    //private ElapsedTime period  = new ElapsedTime();

    public void init(HardwareMap hwMap){
        //set direction of motors facing opposite directions
        rightMotor = hwMap.dcMotor.get("rightDrive");
        leftMotor = hwMap.dcMotor.get("leftDrive");

        colorSensorLeft = hwMap.colorSensor.get("colorSensorLeft");
        colorSensorRight = hwMap.colorSensor.get("colorSensorRight");

        markerPusher = hwMap.servo.get("marker pusher");
        markerPusher.setPosition(0);
        
        intakeMotor = hwMap.dcMotor.get("intake");
        armMotor = hwMap.dcMotor.get("arm");
        extendIntakeMotor = hwMap.dcMotor.get("extend intake");

        
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotor.setDirection(DcMotor.Direction.FORWARD);
        extendIntakeMotor.setDirection(DcMotor.Direction.FORWARD);

        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        //set pwr to 0
        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);
        intakeMotor.setPower(0.0);
        armMotor.setPower(0.0);
        extendIntakeMotor.setPower(0.0);
        liftUpMotor.setPower(0.0);
        
        

    }
}
