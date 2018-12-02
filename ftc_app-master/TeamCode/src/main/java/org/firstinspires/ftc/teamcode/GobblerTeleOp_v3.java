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

            double armMotorUp = -gamepad1.right_trigger;
            double armMotorDown = -gamepad1.left_trigger;

            boolean extendMotorOut = gamepad1.b;
            boolean extendMotorIn = gamepad1.x;

            boolean intakeIn = gamepad1.left_bumper;
            boolean intakeOut = gamepad1.right_bumper;

            boolean markerPusherIn = gamepad1.y;
            boolean markerPusherOut = gamepad1.a;

            double motorPower = 0.8;

            gobbler.leftMotor.setPower(leftDrive);
            gobbler.rightMotor.setPower(rightDrive);

            if(armMotorUp >0) {
                gobbler.armMotorLeft.setPower(armMotorUp);
                gobbler.armMotorRight.setPower(armMotorUp);
            }
            else if (armMotorDown >0) {
                gobbler.armMotorLeft.setPower(armMotorDown);
                gobbler.armMotorRight.setPower(armMotorDown);
            }
            else {
                gobbler.armMotorLeft.setPower(0.0);
                gobbler.armMotorRight.setPower(0.0);
            }

            //extend motor (rack and pinion) - b and x
            if(extendMotorOut) {
                gobbler.extendIntakeMotor.setPower(motorPower);
            }
            else if (extendMotorIn) {
                gobbler.extendIntakeMotor.setPower(-motorPower);
            }
            else {
                gobbler.extendIntakeMotor.setPower(0.0);
            }

            //intake - right and left bumpers
            if (intakeIn){
                gobbler.intakeMotor.setPower(1.0);
            }
            else if (intakeOut){
                gobbler.intakeMotor.setPower(-1.0);
            }
            else {
                gobbler.intakeMotor.setPower(0.0);
            }

            //Servo to push marker into depot- y and a
            if (markerPusherIn){
                gobbler.markerPusher.setPosition(gobbler.markerPusher.getPosition()+0.05);
            }
            else if (markerPusherOut){
                gobbler.markerPusher.setPosition(gobbler.markerPusher.getPosition()-0.05);
            }
            else {
                gobbler.markerPusher.setPosition(gobbler.markerPusher.getPosition());
            }



        }
    }

}
