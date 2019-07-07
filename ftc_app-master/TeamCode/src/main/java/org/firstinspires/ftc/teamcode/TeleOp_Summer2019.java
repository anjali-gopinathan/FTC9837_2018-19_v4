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

            /**
             *  Alternative Input Types - doubles/floats
             *  -------------------------------------------
             *  This one can be used just like above.
             *  double leftDrive = gamepad1.left_stick_x;
             *  double rightDrive = gamepad1.right_stick_x;
             *
             *  -------------------------------------------
             *  Only forward movement w/ floats.
             *  double leftDrive = gamepad1.left_trigger;
             *  double rightDrive = gamepad1.right_trigger;
             *  if(leftDrive>0){
             *      chad.leftMotor.setPower(leftDrive);
             *  }
             *  else{
             *      chad.leftMotor.setPower(0.0);
             *  }
             *
             *  if(rightDrive>0){
             *      chad.rightMotor.setPower(rightDrive);
             *  }
             *  else{
             *      chad.rightMotor.setPower(0.0);
             *  }
             *  -------------------------------------------
             *  Only forward movement w/ booleans.
             *
             *  -------------------------------------------
             *  Four-button forward/backward movement w/ booleans.
             *  double leftForwardDrive = gamepad1.dpad_up;
             *  double rightForwardDrive = gamepad1.y;
             *  double leftBackDrive = gamepad1.dpad_down;
             *  double rightBackDrive = gamepad1.button_a;
             *  double motorPower = 0.8;
             *
             *  if (leftForwardDrive){
             *      chad.leftMotor.setPower(motorPower);
             *  }
             *  else if (leftBackDrive){
             *      chad.leftMotor.setPower(-motorPower);
             *  }
             *  else{
             *      chad.leftMotor.setPower(0.0);
             *  }
             *
             *  if (rightForwardDrive){
             *      
             *  }
            //driving motors:
            chad.leftMotor.setPower(leftDrive);
            chad.rightMotor.setPower(rightDrive);

        }
    }
}
