package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Sam on 7/4/2019.
 */

public class Hardware_4MotorChassis_Summer2019 {

    //Drive train:
    DcMotor motorFrontRight;
    DcMotor motorBackRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackLeft;

    public void init(HardwareMap hwMap){
        //set direction of motors facing opposite directions
        motorFrontLeft = hwMap.dcMotor.get("motorFrontLeft");
        motorBackLeft = hwMap.dcMotor.get("motorBackLeft");
        motorFrontRight = hwMap.dcMotor.get("motorFrontRight");
        motorBackRight = hwMap.dcMotor.get("motorBackRight");
        
        //set brakes on motors
        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //lift motor set to current configuration
        //Dcmotors: CW by default   cw on left side = forward
        motorFrontLeft.setDirection(DcMotor.Direction.FORWARD);
        motorBackLeft.setDirection(DcMotor.Direction.FORWARD);
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotor.Direction.REVERSE);


        //set pwr to 0
        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);

    }
}
