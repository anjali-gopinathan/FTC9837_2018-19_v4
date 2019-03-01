package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 2/28/2019.
 */

@TeleOp(name="TeleOp: Mecanum", group="Linear Opmode")
public class TeleOp_Mecanum extends LinearOpMode{
    Hardware_4MotorChassis robot = new Hardware_4MotorChassis();
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {


            double left = -gamepad1.left_stick_y;
            double right = -gamepad1.right_stick_y;
            double rightX = gamepad1.right_stick_x;

            // Driving
            if (rightX > 0.5 || rightX < -0.5) {
                double slowRightX = rightX/1.5;
                robot.leftFrontDrive.setPower(slowRightX);
                robot.leftRearDrive.setPower(-slowRightX);
                robot.rightFrontDrive.setPower(-slowRightX);
                robot.rightRearDrive.setPower(slowRightX);
            } else {
                double slowLeft = left/1.5;
                double slowRight = right/1.5;
                robot.leftFrontDrive.setPower(slowLeft);
                robot.leftRearDrive.setPower(slowLeft);
                robot.rightFrontDrive.setPower(slowRight);
                robot.rightRearDrive.setPower(slowRight);
            }

        }
    }

}
