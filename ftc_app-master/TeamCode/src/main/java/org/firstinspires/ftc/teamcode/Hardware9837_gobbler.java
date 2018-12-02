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

    DcMotor intakeMotor;
    DcMotor armMotorLeft;
    DcMotor armMotorRight;
    DcMotor extendIntakeMotor;


//    ColorSensor colorSensorLeft;
//    ColorSensor colorSensorRight;
//
    Servo markerPusher;


    //HardwareMap hwMap = null;
    //private ElapsedTime period  = new ElapsedTime();

    public void init(HardwareMap hwMap){
        //set direction of motors facing opposite directions
        rightMotor = hwMap.dcMotor.get("rightDrive");   //port zero hub A
        leftMotor = hwMap.dcMotor.get("leftDrive");     //port 1 hub A

//        colorSensorLeft = hwMap.colorSensor.get("colorSensorLeft");
//        colorSensorRight = hwMap.colorSensor.get("colorSensorRight");
//
        markerPusher = hwMap.servo.get("marker pusher");
        markerPusher.setPosition(0);
//
        intakeMotor = hwMap.dcMotor.get("intake");          //port 0 hub b
        armMotorLeft = hwMap.dcMotor.get("arm left motor"); // port 2 hub A
        armMotorRight = hwMap.dcMotor.get("arm right motor");//port 3 hub A
        extendIntakeMotor = hwMap.dcMotor.get("extend intake");//port 1 hub b

        
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        armMotorRight.setDirection(DcMotor.Direction.REVERSE);

        extendIntakeMotor.setDirection(DcMotor.Direction.FORWARD);

//        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        //set pwr to 0
        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);
        intakeMotor.setPower(0.0);
        armMotorLeft.setPower(0.0);
        armMotorRight.setPower(0.0);
        extendIntakeMotor.setPower(0.0);

        

    }
}
