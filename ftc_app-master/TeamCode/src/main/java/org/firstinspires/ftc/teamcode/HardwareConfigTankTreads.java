package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Anjali on 1/18/2019.
 */

public class HardwareConfigTankTreads {

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor liftUpMotor;

//    DcMotor intakeMotor;
//    DcMotor extendIntakeMotor;
//    DcMotor armMotor;

    Servo markerPusher;

    public void init(HardwareMap hwMap){
        leftDrive = hwMap.dcMotor.get("leftdrive");
        rightDrive = hwMap.dcMotor.get("rightdrive");
        liftUpMotor = hwMap.dcMotor.get("liftUpMotor");

//        intakeMotor = hwMap.dcMotor.get("intake");
//        extendIntakeMotor = hwMap.dcMotor.get("extendIntake");
//        armMotor = hwMap.dcMotor.get("arm");

//        rotateTwister = hwMap.servo.get("rotate twister");
//        rotateTwister.setPosition(0);

        markerPusher = hwMap.servo.get("marker pusher");
        markerPusher.setPosition(0);

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftUpMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        extendIntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}
