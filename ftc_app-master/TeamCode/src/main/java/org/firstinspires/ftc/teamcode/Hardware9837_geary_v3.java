package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
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

    HardwareMap hwMap = null;
    //private ElapsedTime period  = new ElapsedTime();

    public void init(HardwareMap hardwareMap){
        //set direction of motors facing opposite directions
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        leftMotor = hardwareMap.dcMotor.get("leftDrive");

        colorSensorLeft = hardwareMap.colorSensor.get("colorSensorLeft");
        colorSensorRight = hardwareMap.colorSensor.get("colorSensorRight");

//        markerPusher = hardwareMap.servo.get("marker pusher");
//        markerPusher.setPosition(0);

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setDirection(DcMotor.Direction.FORWARD);

        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //set pwr to 0

        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);

    }
}
