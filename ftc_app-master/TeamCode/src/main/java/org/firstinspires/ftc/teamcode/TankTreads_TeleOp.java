package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Anjali on 1/18/2019.
 */
@TeleOp(name="TeleOp: Tank", group="Linear Opmode")
public class TankTreads_TeleOp extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){
        tank.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()){

            boolean markerPusherIn = gamepad1.y;
            boolean markerPusherOut = gamepad1.a;
            
            boolean liftUp = gamepad1.dpad_up;  //Lifts robot up
            boolean lowerDown = gamepad1.dpad_down; //lowers robot

            double armMotorUp = gamepad1.right_trigger;
            double armMotorDown = gamepad1.left_trigger;

            boolean extendMotorOut = gamepad1.b;
            boolean extendMotorIn = gamepad1.x;

            boolean intakeIn = gamepad1.left_bumper;
            boolean intakeOut = gamepad1.right_bumper;

            double motorPower = 0.8;

            tank.leftDrive.setPower(-gamepad1.left_stick_y);
            tank.rightDrive.setPower(-gamepad1.right_stick_y);

            if (liftUp){
                tank.liftUpMotor.setPower(1.0);
            }
            else if (lowerDown){
                tank.liftUpMotor.setPower(-1.0);
            }
            else {
                tank.liftUpMotor.setPower(0.0);
            }
//
//            if(armMotorUp >0) {
//                tank.armMotor.setPower(armMotorUp);
//            }
//            else if (armMotorDown >0) {
//                tank.armMotor.setPower(-armMotorDown);
//            }
//            else {
//                tank.armMotor.setPower(0.0);
//            }
//            //extend motor (rack and pinion) - b and x
//            if(extendMotorOut) {
//                tank.extendIntakeMotor.setPower(motorPower);
//            }
//            else if (extendMotorIn) {
//                tank.extendIntakeMotor.setPower(-motorPower);
//            }
//            else {
//                tank.extendIntakeMotor.setPower(0.0);
//            }
//
//            //intake - right and left bumpers
//            if (intakeIn){
//                tank.intakeMotor.setPower(1.0);
//            }
//            else if (intakeOut){
//                tank.intakeMotor.setPower(-1.0);
//            }
//            else {
//                tank.intakeMotor.setPower(0.0);
//            }
            //Servo to push marker into depot- y and a
            if (markerPusherIn){
                tank.markerPusher.setPosition(tank.markerPusher.getPosition() >= 0.98 ? 1.0 : tank.markerPusher.getPosition() + .02);
            }
            else if (markerPusherOut){
                tank.markerPusher.setPosition(tank.markerPusher.getPosition() <= 0.02 ? 0.0 : tank.markerPusher.getPosition() - .02) ;
            }
            else {
                tank.markerPusher.setPosition(tank.markerPusher.getPosition());
            }



        }

    }
}
