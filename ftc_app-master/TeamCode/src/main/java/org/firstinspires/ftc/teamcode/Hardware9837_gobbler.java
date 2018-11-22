package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Anjali on 10/19/2018.
 */

class Hardware9837_gobbler {
    DcMotor rightMotor;
    DcMotor leftMotor;
    
//    ColorSensor colorSensorLeft;
//    ColorSensor colorSensorRight;
//
//    Servo markerPusher;
    
//    DcMotor intakeMotor;
    DcMotor armMotorLeft;
    DcMotor armMotorRight;
    DcMotor extendIntakeMotor;
//    DcMotor rotateIntakeMotor;

    //HardwareMap hwMap = null;
    //private ElapsedTime period  = new ElapsedTime();

    public void init(HardwareMap hwMap){
        //set direction of motors facing opposite directions
        rightMotor = hwMap.dcMotor.get("rightDrive");
        leftMotor = hwMap.dcMotor.get("leftDrive");

//        colorSensorLeft = hwMap.colorSensor.get("colorSensorLeft");
//        colorSensorRight = hwMap.colorSensor.get("colorSensorRight");
//
//        markerPusher = hwMap.servo.get("marker pusher");
//        markerPusher.setPosition(0);
//
//        intakeMotor = hwMap.dcMotor.get("intake");
        armMotorLeft = hwMap.dcMotor.get("arm left motor");
        armMotorRight = hwMap.dcMotor.get("arm right motor");
        extendIntakeMotor = hwMap.dcMotor.get("extend intake");
//        rotateIntakeMotor = hwMap.dcMotor.get("rotate intake");

        
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        
//        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        armMotorRight.setDirection(DcMotor.Direction.REVERSE);

        extendIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
//        rotateIntakeMotor.setDirection(DcMotor.Direction.FORWARD);

//        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        //set pwr to 0
        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);
//        intakeMotor.setPower(0.0);
        armMotorLeft.setPower(0.0);
        armMotorRight.setPower(0.0);
        extendIntakeMotor.setPower(0.0);
//        rotateIntakeMotor.setPower(0.0);
        
        

    }
}
