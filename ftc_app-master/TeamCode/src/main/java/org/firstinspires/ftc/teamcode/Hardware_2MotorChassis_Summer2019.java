package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Sam on 7/4/2019.
 */

public class Hardware_2MotorChassis_Summer2019 {

    //Drive train:
    DcMotor leftMotor;
    DcMotor rightMotor;

    public void init(HardwareMap hwMap){
        //set direction of motors facing opposite directions
        leftMotor = hwMap.dcMotor.get("leftDrive");
        rightMotor = hwMap.dcMotor.get("rightDrive");

        //DcMotors: CW by default   cw on left side = forward
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        //set pwr to 0
        rightMotor.setPower(0.0);
        leftMotor.setPower(0.0);

    }
}
