package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Sam on 7/4/2019.
 */
@TeleOp(name="chad", group="Pushbot")
public class TeleOp_Summer2019 extends LinearOpMode{
    Hardware_2MotorChassis_Summer2019 chad = new Hardware_2MotorChassis_Summer2019();
    @Override
    public void runOpMode(){
        chad.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {

            double leftDrive = gamepad1.left_stick_y;   //when looking from top, left motor = port 0
            double rightDrive = gamepad1.right_stick_y; //when looking from top, right motor = port 1

            //driving motors:
            chad.leftMotor.setPower(leftDrive);
            chad.rightMotor.setPower(rightDrive);

        }
    }
}
