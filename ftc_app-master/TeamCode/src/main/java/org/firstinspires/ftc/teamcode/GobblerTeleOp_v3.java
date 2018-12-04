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

            double armMotorsUp = gamepad1.right_trigger;
            double armMotorsDown = gamepad1.left_trigger;

            boolean extendMotorOut = gamepad1.b;
            boolean extendMotorIn = gamepad1.x;

            boolean intakeIn = gamepad1.left_bumper;
            boolean intakeOut = gamepad1.right_bumper;

            boolean markerPusherIn = gamepad1.y;
            boolean markerPusherOut = gamepad1.a;

            boolean liftUp = gamepad1.dpad_up;
            boolean lowerDown = gamepad1.dpad_down;

            boolean rotateTwisterUp = gamepad1.dpad_right;
            boolean rotateTwisterDown = gamepad1.dpad_left;

            double motorPower = 0.8;

            gobbler.leftMotor.setPower(leftDrive);
            gobbler.rightMotor.setPower(rightDrive);

            if(armMotorsUp >0) {
                gobbler.armMotorLeft.setPower(armMotorsUp);
                gobbler.armMotorRight.setPower(armMotorsUp);
            }
            else if (armMotorsDown >0) {
                gobbler.armMotorLeft.setPower(-armMotorsDown);
                gobbler.armMotorRight.setPower(-armMotorsDown);
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


            if (liftUp){
                gobbler.liftUpMotor.setPower(1.0);
            }
            else if (lowerDown){
                gobbler.liftUpMotor.setPower(-1.0);
            }
            else {
                gobbler.liftUpMotor.setPower(0.0);
            }

            if(rotateTwisterUp){
//                gobbler.rotateTwisterOutside.setPosition(gobbler.rotateTwisterOutside.getPosition()+0.05);
                gobbler.rotateTwisterInside.setPosition(gobbler.rotateTwisterInside.getPosition()+0.05);
            }
            else if(rotateTwisterDown){
//                gobbler.rotateTwisterOutside.setPosition(gobbler.rotateTwisterOutside.getPosition()-0.05);
                gobbler.rotateTwisterInside.setPosition(gobbler.rotateTwisterInside.getPosition()-0.05);
            }
            else{
//                gobbler.rotateTwisterOutside.setPosition(gobbler.rotateTwisterOutside.getPosition());
                gobbler.rotateTwisterInside.setPosition(gobbler.rotateTwisterInside.getPosition());
            }

        }
    }

}
