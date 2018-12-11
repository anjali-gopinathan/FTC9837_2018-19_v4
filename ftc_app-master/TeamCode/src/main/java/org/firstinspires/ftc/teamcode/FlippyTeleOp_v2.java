package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 10/22/2018.
 */
@Disabled
@TeleOp(name="TeleOp: Flippy v2", group="Pushbot")

public class FlippyTeleOp_v2 extends LinearOpMode{
    Hardware9837_flippy_v2 flippyBigHotWheels = new Hardware9837_flippy_v2();
    @Override
    public void runOpMode(){
            flippyBigHotWheels.init(hardwareMap);
            waitForStart();
            while (opModeIsActive()) {
                double motorPower_flippers = 0.4;

                double leftDrive = gamepad1.left_stick_y;   //when looking from top, left motor = port 1
                double rightDrive = gamepad1.right_stick_y; //when looking from top, right motor = port 0

                //top flipper (where expansion hub is), port 0
                boolean flipperUp = gamepad1.dpad_up;
                boolean flipperDown = gamepad1.dpad_down;

                //bottom flipper, port 1
//                boolean leftFlipperUp = gamepad1.dpad_up;
//                boolean leftFlipperDown = gamepad1.dpad_down;

                //driving motors:
                flippyBigHotWheels.rightMotor.setPower(rightDrive);
                flippyBigHotWheels.leftMotor.setPower(leftDrive);

                //flips robot with dpad up/down and 'y' and 'a' keys
                if (flipperUp)
                    flippyBigHotWheels.deadwheelFlipper.setPower(motorPower_flippers);
                else if (flipperDown)
                    flippyBigHotWheels.deadwheelFlipper.setPower(-1 * motorPower_flippers);
                else
                    flippyBigHotWheels.deadwheelFlipper.setPower(0.0);

//                if (leftFlipperUp) flippyBigHotWheels.leftFlipper.setPower(motorPower_flippers);
//                else if (leftFlipperDown)
//                    flippyBigHotWheels.leftFlipper.setPower(-1 * motorPower_flippers);
//                else flippyBigHotWheels.leftFlipper.setPower(0.0);

            }
    }
}
