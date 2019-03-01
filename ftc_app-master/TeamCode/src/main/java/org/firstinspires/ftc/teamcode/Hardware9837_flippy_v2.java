package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Anjali on 10/22/2018.
 */

public class Hardware9837_flippy_v2 {

    DcMotor rightMotor;
    DcMotor leftMotor;

    DcMotor deadwheelFlipper;
    DcMotor leftFlipper;

//    private ElapsedTime period  = new ElapsedTime();

    public void init(HardwareMap hardwareMap){
        //set direction of motors facing opposite directions

        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        leftMotor = hardwareMap.dcMotor.get("leftDrive");

        deadwheelFlipper = hardwareMap.dcMotor.get("dead wheel Flipper");
        leftFlipper = hardwareMap.dcMotor.get("leftFlipper");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setDirection(DcMotor.Direction.FORWARD);

        //set pwr to 0

        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);

        deadwheelFlipper.setPower(0.0);
        leftFlipper.setPower(0.0);
    }

}
