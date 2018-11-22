package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Anjali on 10/19/2018.
 */

@TeleOp(name="TeleOp: Gobbler", group="Linear Opmode")
public class GobblerTeleOp_v3 extends LinearOpMode{
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();
    @Override
    public void runOpMode() {
        gobbler.init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {

            double leftDrive = gamepad1.left_stick_y;
            double rightDrive = gamepad1.right_stick_y;

            boolean armMotorUp = gamepad1.dpad_up;
            boolean armMotorDown = gamepad1.dpad_down;

            boolean extendMotorOut = gamepad1.b;
            boolean extendMotorIn = gamepad1.x;

            double motorPower = 0.8;

            gobbler.leftMotor.setPower(leftDrive);
            gobbler.rightMotor.setPower(rightDrive);

            if(armMotorUp) {
                gobbler.armMotorLeft.setPower(motorPower);
                gobbler.armMotorRight.setPower(motorPower);
            }
            else if (armMotorDown) {
                gobbler.armMotorLeft.setPower(-motorPower);
                gobbler.armMotorRight.setPower(-motorPower);
            }
            else {
                gobbler.armMotorLeft.setPower(0.0);
                gobbler.armMotorRight.setPower(0.0);
            }


            if(extendMotorOut)
                gobbler.extendIntakeMotor.setPower(motorPower);
            else if (extendMotorIn)
                gobbler.extendIntakeMotor.setPower(-motorPower);
            else
                gobbler.extendIntakeMotor.setPower(0.0);

        }
    }

}
