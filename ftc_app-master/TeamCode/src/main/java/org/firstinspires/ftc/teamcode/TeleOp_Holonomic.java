package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 2/28/2019.
 */


@TeleOp(name="TeleOp: Holonomic yeet", group="Linear Opmode")
public class TeleOp_Holonomic extends LinearOpMode{
    Hardware_4MotorChassis robot = new Hardware_4MotorChassis();
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {

            //left joystick: strafe forward backward with y; turn with x
            //right joystick: strafe left and right with x
            double x1 = gamepad1.left_stick_x;
            double y1 = -gamepad1.left_stick_y;
            double x2 = gamepad1.right_stick_x;

            double bl = y1-x1+x2;
            double br = y1+x1-x2;
            double fl = y1-x1-x2;
            double fr = y1+x1+x2;

            //driving
            robot.leftFrontDrive.setPower(fl);
            robot.leftRearDrive.setPower(bl);
            robot.rightFrontDrive.setPower(fr);
            robot.rightRearDrive.setPower(br);


        }
    }

}
